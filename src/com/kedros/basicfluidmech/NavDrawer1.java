package com.kedros.basicfluidmech;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
 
public class NavDrawer1 extends Fragment {
 
    public static Fragment newInstance(Context context) {
    	NavDrawer1 f = new NavDrawer1();
 
        return f;
    }
 
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.navdrawer1, null);
        return root;
    }
 
}