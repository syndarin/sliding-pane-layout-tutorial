package com.skd.slidingpanelayouttest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v4.widget.SlidingPaneLayout.PanelSlideListener;
import android.util.Log;
import android.view.View;

public class MainActivity extends FragmentActivity implements NavigationListener{

	public final static String tag = MainActivity.class.getSimpleName();
	
	private SlidingPaneLayout mSlidingPanel;

	private SlidingPaneLayout.PanelSlideListener sidePanelListener = new PanelSlideListener() {
		
		@Override
		public void onPanelSlide(View arg0, float arg1) {
			Log.i(tag, "onPanelSlide " + arg1);
		}
		
		@Override
		public void onPanelOpened(View arg0) {
			getFragmentById(R.id.fragment_navigation).setHasOptionsMenu(true);
			getFragmentById(R.id.fragment_content).setHasOptionsMenu(false);
		}
		
		@Override
		public void onPanelClosed(View arg0) {
			getFragmentById(R.id.fragment_navigation).setHasOptionsMenu(false);
			getFragmentById(R.id.fragment_content).setHasOptionsMenu(true);
		}
	};
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sliding_pane_layout);
        mSlidingPanel = (SlidingPaneLayout) findViewById(R.id.slidingPanel);
        mSlidingPanel.setPanelSlideListener(sidePanelListener);
    }
    
	private Fragment getFragmentById(int id){
		return getSupportFragmentManager().findFragmentById(id);
	}

	@Override
	public void onNavigationChanged(String arg) {
		mSlidingPanel.closePane();
		((ContentFragment)getFragmentById(R.id.fragment_content)).setContent(arg);
	}
}
