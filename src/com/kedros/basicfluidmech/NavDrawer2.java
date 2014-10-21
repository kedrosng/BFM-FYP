package com.kedros.basicfluidmech;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
 
public class NavDrawer2 extends Fragment {
 
    public static Fragment newInstance(Context context) {
    	NavDrawer2 f = new NavDrawer2();
 
        return f;
    }
 
    @SuppressLint("InflateParams") @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.navdrawer2, null);
        
        return root;
        
    }
    
 
}