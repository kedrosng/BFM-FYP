package com.kedros.basicfluidmech;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class WaterDetail extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.waterdetail);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.water_detail, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_back) {
			finish();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public void waterdensity(View view) {
		Intent intent = new Intent(this, WaterDensity.class);
		startActivity(intent);
		// Toast.makeText(this, "ImageButton is clicked!", Toast.LENGTH_SHORT)
		// .show();

	}
	public void waterviscosity(View view) {
		Intent intent = new Intent(this, WaterViscosity.class);
		startActivity(intent);
		// Toast.makeText(this, "ImageButton is clicked!", Toast.LENGTH_SHORT)
		// .show();

	}
	public void watertemp(View view) {
		Intent intent = new Intent(this, WaterTension.class);
		startActivity(intent);
		// Toast.makeText(this, "ImageButton is clicked!", Toast.LENGTH_SHORT)
		// .show();

	}
	public void waterpressure(View view) {
		Intent intent = new Intent(this, WaterPressure.class);
		startActivity(intent);
		// Toast.makeText(this, "ImageButton is clicked!", Toast.LENGTH_SHORT)
		// .show();

	}
}
