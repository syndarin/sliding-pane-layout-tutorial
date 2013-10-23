package com.skd.slidingpanelayouttest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ContentFragment extends Fragment {

	public final static String KEY_TEXT = "key_text";
	private TextView mTextContent;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		setHasOptionsMenu(true);
		View view = inflater.inflate(R.layout.content_fragment, container, false);
		mTextContent = (TextView) view.findViewById(R.id.textContent);
		return view;
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		menu.clear();
		inflater.inflate(R.menu.content_menu, menu);
	}

	public void setContent(String content) {
		mTextContent.setText(content);
	}

}
