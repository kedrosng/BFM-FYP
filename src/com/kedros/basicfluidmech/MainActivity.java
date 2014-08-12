package com.kedros.basicfluidmech;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //if want to hide the NAV bar when open app , use the following code
        //========
        //getWindow().
        //getDecorView().
        //setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        //========
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        //int id = item.getItemId();
        //if (id == R.id.action_settings) {
        //     return true;
        // }
        // return super.onOptionsItemSelected(item);
    	android.app.ActionBar actionBar = getActionBar();
    	switch (item.getItemId()) {
    	case R.id.action_refresh:
    		actionBar.setTitle("Refresh");
    		Toast.makeText(this, "Refresh Selected", Toast.LENGTH_SHORT)
    		.show();
    		break;
    	case R.id.action_help:
    		actionBar.setTitle("Help");
    		//setContentView(R.layout.activity_help);
    		//intent start a new activity
    		startActivity(new Intent(MainActivity.this, Help.class));
    		Toast.makeText(this, "Help Selected", Toast.LENGTH_SHORT)
    		.show();
    		
    		break;
    	case R.id.action_settings:
    		actionBar.setTitle("Settings");
    		Toast.makeText(this, "Settings Selected", Toast.LENGTH_SHORT)
    		.show();
    		break;
    	
    	default:
    	break;
    		
    	}
    	return true;
    	
    }
}
