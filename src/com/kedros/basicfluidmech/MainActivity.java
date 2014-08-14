package com.kedros.basicfluidmech;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends FragmentActivity {
	final String[] data ={
			"About",
			"Basic Knowledge",
			"Type of Flow",
			"Impact Force",
			"Help"
			
			};
	final String[] fragments ={
			"com.kedros.basicfluidmech.About",
			"com.kedros.basicfluidmech.FragmentTwo",
			"com.kedros.basicfluidmech.FragmentThree",
			"com.kedros.basicfluidmech.FragmentFour",
			"com.kedros.basicfluidmech.Help"
			};
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
	        //getMenuInflater().inflate(R.menu.main, menu);
	    	MenuInflater inflater = getMenuInflater();
	        inflater.inflate(R.menu.action_icon, menu); 
	        return true;
	    }
	 
	 @Override
	  public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	    // action with ID action_refresh was selected
	    case R.id.action_search:
	      Toast.makeText(this, "Search selected", Toast.LENGTH_SHORT)
	          .show();
	      break;
	    //case R.id.action_exit:
	    	//Intent startMain = new Intent(Intent.ACTION_MAIN);
	        //startMain.addCategory(Intent.CATEGORY_HOME);
	        //startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	        //startActivity(startMain);
	     // break;
	      
	    default:
	      break;
	    }

	    return true;
	  } 

	

}
