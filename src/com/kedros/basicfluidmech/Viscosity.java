package com.kedros.basicfluidmech;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class Viscosity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.viscosity);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.viscosity, menu);
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
	public void button_vis_ans(View view) {
		final TextView mTextView = (TextView) findViewById(R.id.vis_ans);
		mTextView.setText("Yes, if the shear stresses in the flow are small and act over such small areas that they do not signigicantly affect the flow field.");
	}
}
