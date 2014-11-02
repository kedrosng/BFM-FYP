package com.kedros.basicfluidmech;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SpinnerCalculator extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.spinner_calculator);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.spinner_calculator, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public void sans(View view) {
		float Q = 0;
		float jetnum = 0;
		float jetout = 0;
		float outangle = 60;
		float fluidden = 0;
		float Qjet = 0;
		float Vjet = 0;
		float T = 0;
		float r = 0;
		float cosangle = 0;

		TextView spinnertor = (TextView) findViewById(R.id.spinner_torque);
		spinnertor.setText(Float.toString(Qjet));
		Toast.makeText(this, "Cal is clicked!", Toast.LENGTH_SHORT).show();

	}
}
