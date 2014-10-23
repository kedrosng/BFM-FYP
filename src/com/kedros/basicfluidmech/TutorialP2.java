package com.kedros.basicfluidmech;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
 
public class TutorialP2 extends Fragment {
 
    public static Fragment newInstance(Context context) {
    	TutorialP2 f = new TutorialP2();
 
        return f;
    }
 
    @SuppressLint("InflateParams") @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.tutorialp2, null);
        return root;
    }
 
}