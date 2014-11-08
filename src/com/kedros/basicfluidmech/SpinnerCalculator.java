package com.kedros.basicfluidmech;

import android.R.string;
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
		if (id == R.id.action_back) {
			finish();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public void sans(View view) {
		float Q = 0;
		float jetnum = 0;
		float outjet = 0;
		float outangle = 0;
		float fluidden = 0;
		float Qjet = 0;
		float Vjet = 0;
		float T = 0;
		float r = 0;
		double cosangle = 0;

		TextView spinnertor = (TextView) findViewById(R.id.spinner_torque);
		EditText qflow = (EditText) findViewById(R.id.spinnerflowrate);
		EditText jetnumber = (EditText) findViewById(R.id.jetnumber);
		EditText outarea = (EditText) findViewById(R.id.jetout);
		EditText angle = (EditText) findViewById(R.id.editText1);
		EditText density = (EditText) findViewById(R.id.editText2);
		EditText nozzlel = (EditText) findViewById(R.id.nozzlelength);
		Q = Float.parseFloat(qflow.getText().toString());
		jetnum = Float.parseFloat(jetnumber.getText().toString());
		outjet = Float.parseFloat(outarea.getText().toString());
		cosangle = Double.parseDouble(angle.getText().toString());
		outangle = (float) (Math.cos(Math.toRadians(cosangle)));
		fluidden = Float.parseFloat(density.getText().toString());
		r = Float.parseFloat(nozzlel.getText().toString());
		Qjet = (Q / 1000) / 3;
		Vjet = Qjet / (outjet /1000000);
		T = fluidden * Qjet * (Vjet * outangle - 0) * r * jetnum;

		spinnertor.setText("The resisting Torque = " + Float.toString(T));

		//Toast.makeText(this, "Cal is clicked!", Toast.LENGTH_SHORT).show();

	}
}
