package com.kedros.basicfluidmech;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.app.Activity;
import android.widget.ImageButton;
import android.view.View.OnClickListener;

public class NavDrawer3 extends Fragment {

	public static Fragment newInstance(Context context) {
		NavDrawer3 f = new NavDrawer3();

		return f;
	}

	View mView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// ViewGroup root = (ViewGroup) inflater.inflate(R.layout.navdrawer3,
		// null);
		mView = inflater.inflate(R.layout.navdrawer3, container, false);

		return mView;
		// return root;
	}

	ImageButton imageButton;
	Activity activity = getActivity();

	public void addListenerOnButton() {

		imageButton = (ImageButton) mView.findViewById(R.id.reyformula);

		imageButton.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {

				Toast.makeText(getActivity(), "ImageButton is clicked!",
						Toast.LENGTH_SHORT).show();

			}

		});

	}
}