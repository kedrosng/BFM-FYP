package com.kedros.basicfluidmech;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
 
public class TutorialP3 extends Fragment {
	Button button;
    public static Fragment newInstance(Context context) {
    	TutorialP3 f = new TutorialP3();
 
        return f;
    }
 
    @SuppressLint("InflateParams") @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.tutorialp3, null);
        Button mButton = (Button) root.findViewById(R.id.button1);
        mButton.setOnClickListener(new OnClickListener() {
           public void onClick(View v) {
        	   Intent intent = new Intent(getActivity(), MainActivity.class);
        	    startActivity(intent);

           }
        });
        return root;
        
    }
 
}