package com.kedros.basicfluidmech;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
 
public class TutorialP1 extends Fragment {
 
    public static Fragment newInstance(Context context) {
    	TutorialP1 f = new TutorialP1();
 
        return f;
    }
 
    @SuppressLint("InflateParams") @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.tutorialp1, null);
        return root;
    }
 
}