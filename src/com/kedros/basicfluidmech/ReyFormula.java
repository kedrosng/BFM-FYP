package com.kedros.basicfluidmech;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ReyFormula extends Fragment {

	public static Fragment newInstance(Context context) {
		ReyFormula f = new ReyFormula();

		return f;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		ViewGroup root = (ViewGroup) inflater
				.inflate(R.layout.reyformula, null);
		return root;
	}

}