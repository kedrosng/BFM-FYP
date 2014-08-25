package com.kedros.basicfluidmech;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
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
	private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;

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
		 mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
	        
		 //final DrawerLayout drawer = (DrawerLayout)findViewById(R.id.drawer_layout);
		 // Set the drawer toggle as the DrawerListener
	        mDrawerLayout.setDrawerListener(mDrawerToggle);

	        getActionBar().setDisplayHomeAsUpEnabled(true);
	        getActionBar().setHomeButtonEnabled(true); 
	      
	        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout ,
	                R.drawable.ic_drawer, R.string.drawer_open, R.string.drawer_closed) {

	    	 
	            /** Called when a drawer has settled in a completely closed state. */
	            public void onDrawerClosed(View view) {
	                super.onDrawerClosed(view);
	                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
	            }

	            /** Called when a drawer has settled in a completely open state. */
	            public void onDrawerOpened(View drawerView) {
	                super.onDrawerOpened(drawerView);
	                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
	            }
	           
	        };
	        
		 
		 final ListView navList = (ListView) findViewById(R.id.drawer);
		 navList.setAdapter(adapter);
		 navList.setOnItemClickListener(new OnItemClickListener(){
		         @Override
		         public void onItemClick(AdapterView<?> parent, View view, final int pos,long id){
		                 mDrawerLayout.setDrawerListener( new DrawerLayout.SimpleDrawerListener(){
		                         @Override
		                         public void onDrawerClosed(View drawerView){
		                                 super.onDrawerClosed(drawerView);
		                                 FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
		                                 tx.replace(R.id.main, Fragment.instantiate(MainActivity.this, fragments[pos]));
		                                 tx.commit();
		                         }
		                 });
		                 mDrawerLayout.closeDrawer(navList);
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

	    if (mDrawerToggle.onOptionsItemSelected(item)) {
	         return true;
	    }
		 
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
	    	
	    }
		
		return super.onOptionsItemSelected(item);
	    
	  } 
	 
	 @Override
	    protected void onPostCreate(Bundle savedInstanceState) {
	        super.onPostCreate(savedInstanceState);
	        // Sync the toggle state after onRestoreInstanceState has occurred.
	         mDrawerToggle.syncState();
	    }
	 @Override
	    public void onConfigurationChanged(Configuration newConfig) {
	        super.onConfigurationChanged(newConfig);
	        // Pass any configuration change to the drawer toggles
	        mDrawerToggle.onConfigurationChanged(newConfig);
	    }


}
