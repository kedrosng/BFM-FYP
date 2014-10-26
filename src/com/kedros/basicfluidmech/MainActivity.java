package com.kedros.basicfluidmech;

import android.content.Intent;
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
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends FragmentActivity {

	ActionBarDrawerToggle mDrawerToggle;

	String[] data = { "About", "What is Fluid", "Type of Flow", "Impact Force",
			"Quiz", "Help"

	};
	String[] fragments = { "com.kedros.basicfluidmech.NavDrawer1",
			"com.kedros.basicfluidmech.NavDrawer2",
			"com.kedros.basicfluidmech.NavDrawer3",
			"com.kedros.basicfluidmech.NavDrawer4",
			"com.kedros.basicfluidmech.SmallQuiz",
			"com.kedros.basicfluidmech.HelpPage", };

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// if (isFirstTime()) {
		// What you do when the Application is Opened First time Goes here
		// Toast.makeText(this, "Hello 1st time user", Toast.LENGTH_SHORT)
		// .show();

		// }

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActionBar()
				.getThemedContext(), R.layout.adaptertheme, data);

		final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

		mDrawerToggle = new ActionBarDrawerToggle(this, drawer,
				R.drawable.ic_drawer, R.string.drawer_open,
				R.string.drawer_closed) {

			/** Called when a drawer has settled in a completely closed state. */
			public void onDrawerClosed(View view) {
				super.onDrawerClosed(view);
				/*
				 * the invalidateOptionsMenu function you only need when you
				 * want to change the Menu later if i understand it in the right
				 * way you won't do this
				 */
				// invalidateOptionsMenu(); // creates call to
				// onPrepareOptionsMenu()
			}

			/** Called when a drawer has settled in a completely open state. */
			public void onDrawerOpened(View drawerView) {
				super.onDrawerOpened(drawerView);
				/*
				 * the invalidateOptionsMenu function you only need when you
				 * want to change the Menu later if i understand it in the right
				 * way you won't do this
				 */
				// invalidateOptionsMenu(); // creates call to
				// onPrepareOptionsMenu()
			}
		};

		final ListView navList = (ListView) findViewById(R.id.drawer);
		navList.setAdapter(adapter);
		navList.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					final int pos, long id) {
				drawer.setDrawerListener(new DrawerLayout.SimpleDrawerListener() {
					@Override
					public void onDrawerClosed(View drawerView) {
						super.onDrawerClosed(drawerView);
						FragmentTransaction tx = getSupportFragmentManager()
								.beginTransaction();
						tx.replace(R.id.main, Fragment.instantiate(
								MainActivity.this, fragments[pos]));
						tx.commit();
					}
				});
				drawer.closeDrawer(navList);
			}
		});
		FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
		tx.replace(R.id.main,
				Fragment.instantiate(MainActivity.this, fragments[0]));
		tx.commit();

		// Set the drawer toggle as the DrawerListener
		/*
		 * I saw on you latest Version that you didn't set the toggle as
		 * Listener so the syncstate won't work
		 */
		drawer.setDrawerListener(mDrawerToggle);

		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setHomeButtonEnabled(true);

	}

	// private boolean isFirstTime()
	// {
	// SharedPreferences preferences = getPreferences(MODE_PRIVATE);
	// boolean ranBefore = preferences.getBoolean("RanBefore", false);
	// if (!ranBefore) {
	// first time
	// SharedPreferences.Editor editor = preferences.edit();
	// editor.putBoolean("RanBefore", true);
	// editor.commit();
	// }
	// return !ranBefore;
	// }
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		// getMenuInflater().inflate(R.menu.main, menu);
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.action_icon, menu);
		return true;
	}

	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		// Sync the TOGGLE!!! state
		/*
		 * you haven't use the toogle in you latest Github version ;)
		 */
		mDrawerToggle.syncState();
	}

	@Override
	// set the configuration for toggle
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		mDrawerToggle.onConfigurationChanged(newConfig);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		// exit when Toggle Button pressed
		if (mDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}

		switch (item.getItemId()) {
		// action with ID action_refresh was selected
		case R.id.action_search:
			Toast.makeText(this, "Search selected", Toast.LENGTH_SHORT).show();
			break;
		// case R.id.action_exit:
		// Intent startMain = new Intent(Intent.ACTION_MAIN);
		// startMain.addCategory(Intent.CATEGORY_HOME);
		// startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		// startActivity(startMain);
		// break;

		default:
			break;
		}

		return super.onOptionsItemSelected(item);
	}

	// manage button clicked//

	// Reynolds Number Calculation//
	public void reyCalculate(View view) {
		EditText number1 = (EditText) findViewById(R.id.rey_density);
		EditText number2 = (EditText) findViewById(R.id.rey_velocity);
		EditText number3 = (EditText) findViewById(R.id.rey_dia);
		EditText number4 = (EditText) findViewById(R.id.rey_viscosity);
		EditText reyresult = (EditText) findViewById(R.id.rey_answer);

		float result = Float.parseFloat(number1.getText().toString())
				* Float.parseFloat(number2.getText().toString())
				* Float.parseFloat(number3.getText().toString())
				/ Float.parseFloat(number4.getText().toString());
		reyresult.setText("Reynolds Number is" + " " + Float.toString(result));

		// Toast.makeText(this, "Calculate Button is clicked!",
		// Toast.LENGTH_SHORT)
		// .show();

	}

	// NavDrawer 3 Related//
	public void button_tur(View view) {
		Intent intent = new Intent(this, TurbulentLaminar.class);
		startActivity(intent);
		// Toast.makeText(this, "ImageButton is clicked!", Toast.LENGTH_SHORT)
		// .show();

	}

	public void uniform(View view) {
		Intent intent = new Intent(this, Uniform.class);
		startActivity(intent);
		// Toast.makeText(this, "ImageButton is clicked!", Toast.LENGTH_SHORT)
		// .show();

	}

	public void steady(View view) {
		Intent intent = new Intent(this, Steady.class);
		startActivity(intent);
		// Toast.makeText(this, "ImageButton is clicked!", Toast.LENGTH_SHORT)
		// .show();

	}

	public void compressibility(View view) {
		Intent intent = new Intent(this, Compressibility.class);
		startActivity(intent);
		// Toast.makeText(this, "ImageButton is clicked!", Toast.LENGTH_SHORT)
		// .show();

	}

	public void viscosity(View view) {
		Intent intent = new Intent(this, Viscosity.class);
		startActivity(intent);
		// Toast.makeText(this, "ImageButton is clicked!", Toast.LENGTH_SHORT)
		// .show();

	}

	// Page of Water Jet//
	public void waterjet(View view) {
		Intent intent = new Intent(this, WaterJet.class);
		startActivity(intent);
		// Toast.makeText(this, "ImageButton is clicked!", Toast.LENGTH_SHORT)
		// .show();

	}

	// Page of Water Nozzle//
	public void Nozzle(View view) {
		Intent intent = new Intent(this, WaterNozzle.class);
		startActivity(intent);
		// Toast.makeText(this, "ImageButton is clicked!", Toast.LENGTH_SHORT)
		// .show();

	}

	// Detail of water//
	public void waterglass(View v) {
		Intent intent = new Intent(this, WaterDetail.class);
		startActivity(intent);
	}

	public void spinner(View view) {
		Intent intent = new Intent(this, Spinner.class);
		startActivity(intent);
		// Toast.makeText(this, "ImageButton is clicked!", Toast.LENGTH_SHORT)
		// .show();

	}

}