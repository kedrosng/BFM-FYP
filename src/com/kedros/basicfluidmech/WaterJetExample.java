package com.kedros.basicfluidmech;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class WaterJetExample extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.waterjet_example);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.water_jet_example, menu);
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

	public void checkjetanswer(View view) {
		EditText number1 = (EditText) findViewById(R.id.answera);
		EditText number2 = (EditText) findViewById(R.id.answerb);

		if (number1.getText().toString().equals("269")) {
			CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox1);
			checkBox.setChecked(true);

		}

		if (number2.getText().toString().equals("151")) {
			CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox2);
			checkBox.setChecked(true);
			return;
		}

		Toast.makeText(this, "Answer Checked!", Toast.LENGTH_SHORT)
				.show();

	}
}
