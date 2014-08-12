package com.kedros.basicfluidmech;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends FragmentActivity {
	final String[] data ={"One","Two","Three"};
	final String[] fragments ={
			"com.kedros.basicfluidmech.FragmentOne",
			"com.kedros.basicfluidmech.FragmentTwo",
			"com.kedros.basicfluidmech.FragmentThree"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		 super.onCreate(savedInstanceState);
		 setContentView(R.layout.activity_main);
		
		 ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActionBar().getThemedContext(), android.R.layout.simple_list_item_1, data);

		 final DrawerLayout drawer = (DrawerLayout)findViewById(R.id.drawer_layout);
		 final ListView navList = (ListView) findViewById(R.id.drawer);
		 navList.setAdapter(adapter);
		 navList.setOnItemClickListener(new OnItemClickListener(){
		         @Override
		         public void onItemClick(AdapterView<?> parent, View view, final int pos,long id){
		                 drawer.setDrawerListener( new DrawerLayout.SimpleDrawerListener(){
		                         @Override
		                         public void onDrawerClosed(View drawerView){
		                                 super.onDrawerClosed(drawerView);
		                                 FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
		                                 tx.replace(R.id.main, Fragment.instantiate(MainActivity.this, fragments[pos]));
		                                 tx.commit();
		                         }
		                 });
		                 drawer.closeDrawer(navList);
		         }
		 });
		 FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
		 tx.replace(R.id.main,Fragment.instantiate(MainActivity.this, fragments[0]));
		 tx.commit();
	}
	 @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	        // Inflate the menu; this adds items to the action bar if it is present.
	        getMenuInflater().inflate(R.menu.main, menu);
	    	MenuInflater inflater = getMenuInflater();
	        inflater.inflate(R.menu.action_icon, menu); 
	        return true;
	    }

	

}
