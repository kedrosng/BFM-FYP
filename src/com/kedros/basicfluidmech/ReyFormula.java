package com.kedros.basicfluidmech;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class ReyFormula extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.reyformula);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.rey_formula, menu);
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

	// Reynolds Number Calculation//
	public void reyCalculate(View view) {
		float num1 = 0;
		float num2 = 0;
		float num3 = 0;
		float num4 = 0;
		EditText number1 = (EditText) findViewById(R.id.rey_density);
		EditText number2 = (EditText) findViewById(R.id.rey_velocity);
		EditText number3 = (EditText) findViewById(R.id.rey_dia);
		EditText number4 = (EditText) findViewById(R.id.rey_viscosity);
		EditText rey = (EditText) findViewById(R.id.rey_answer);

		num1 = Float.parseFloat(number1.getText().toString());
		num2 = Float.parseFloat(number2.getText().toString());
		num3 = Float.parseFloat(number3.getText().toString());
		num4 = Float.parseFloat(number4.getText().toString());

		float result = (num1 * num2 * num3) / num4;
		rey.setText("Reynolds Number is" + " " + Float.toString(result));

		// Toast.makeText(this, "Calculate Button is clicked!",
		// Toast.LENGTH_SHORT)
		// .show();

	}
}
