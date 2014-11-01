package com.kedros.basicfluidmech;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class NozzleCal extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.nozzlecalculator);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.nozzle_cal, menu);
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

	public void nozzlecala(View view) {
		float din = 0;
		float dout = 0;
		float inp = 0;
		float outv = 0;
		float fluidden = 0;
		float dx = 0;
		float dy = 0;
		float Qrate = 0;
		float fx = 0;
		float fy = 0;
		float moment = 0;
		float inv = 0;
		float inA = 0;
		EditText inletdiameter = (EditText) findViewById(R.id.inletdiameter);
		EditText inletpressure = (EditText) findViewById(R.id.inletpressure);
		EditText outletdiameter = (EditText) findViewById(R.id.outletdiameter);
		EditText outletvelocity = (EditText) findViewById(R.id.outletvelocity);
		EditText fluiddensity = (EditText) findViewById(R.id.fluiddensity);
		EditText distx = (EditText) findViewById(R.id.distx);
		EditText disty = (EditText) findViewById(R.id.disty);
		TextView flowrate = (TextView) findViewById(R.id.flowrate);
		TextView forcex = (TextView) findViewById(R.id.forcex);
		TextView forcey = (TextView) findViewById(R.id.forcey);
		TextView momentoutput = (TextView) findViewById(R.id.momentoutput);

		din = Float.parseFloat(inletdiameter.getText().toString());
		dout = Float.parseFloat(outletdiameter.getText().toString());
		inp = Float.parseFloat(inletpressure.getText().toString());
		outv = Float.parseFloat(outletvelocity.getText().toString());
		fluidden = Float.parseFloat(fluiddensity.getText().toString());
		dx = Float.parseFloat(distx.getText().toString());
		dy = Float.parseFloat(disty.getText().toString());
		inA = (float) (3.14 / 4 * din * din);
		inv = outv * (dout * dout) / (din * din);
		Qrate = (float) (3.14 / 4 * dout * dout * outv);
		fx = fluidden * Qrate * (outv - inv) + inp * inA;
		fy = fluidden * Qrate * (outv - inv) * -1;
		moment = fx * dx + fy * dy;

		flowrate.setText("The Flow Rate = " + Float.toString(Qrate));

		forcey.setText("Force(Y-Dir) on Pipe = " + Float.toString(fy));
		forcex.setText("Force(X-Dir) on Pipe = " + Float.toString(fx));
		momentoutput.setText("Moment Induced to Nozzle = "
				+ Float.toString(moment));

	}
}
