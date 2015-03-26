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
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends FragmentActivity {

	ActionBarDrawerToggle mDrawerToggle;

	String[] data = { "About", "What is Fluid", "Type of Flow", "Impact Force",
			"Quiz", "Contact"

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
		inflater.inflate(R.menu.main, menu);
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
		case R.id.action_ver:
			Toast.makeText(this, "V3.0.2", Toast.LENGTH_SHORT).show();
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

	public void checkanswer(View view) {
		float mark = 0;
		float tmark = 0;
		RadioButton btn1, btn2, btn3, btn4, btn5, btn6;
		EditText ans1, ans2, ans3, ans4, ans5, ans6, ans7, ans8;
		String a1, a2, a3, a4, a5, a6, a7, a8;
		// Q1
		btn1 = (RadioButton) findViewById(R.id.radio0);
		btn2 = (RadioButton) findViewById(R.id.radio2);
		btn3 = (RadioButton) findViewById(R.id.radio1);

		if (btn1.isChecked()) {
			tmark = tmark + 1;
		} else {
			tmark = tmark + 0;
		}

		// Q2 （if case need to update)
		ans1 = (EditText) findViewById(R.id.editText1);
		ans2 = (EditText) findViewById(R.id.editText2);
		ans3 = (EditText) findViewById(R.id.editText3);
		ans4 = (EditText) findViewById(R.id.editText4);
		ans5 = (EditText) findViewById(R.id.editText5);
		ans6 = (EditText) findViewById(R.id.editText6);
		ans7 = (EditText) findViewById(R.id.editText7);
		ans8 = (EditText) findViewById(R.id.editText8);
		a1 = ans1.getText().toString();
		a2 = ans2.getText().toString();
		a3 = ans3.getText().toString();
		if ((a1.equalsIgnoreCase("density"))
				|| (a1.equalsIgnoreCase("viscosity"))
				|| a1.equalsIgnoreCase("temperature")
				|| a1.equalsIgnoreCase("pressure") && !a1.equalsIgnoreCase(a2)
				&& !a1.equalsIgnoreCase(a3)) {
			tmark = tmark + 1;
		} else {
			tmark = tmark + 0;
		}
		if ((a2.equalsIgnoreCase("density"))
				|| (a2.equalsIgnoreCase("viscosity"))
				|| a2.equalsIgnoreCase("temperature")
				|| a2.equalsIgnoreCase("pressure") && !a2.equalsIgnoreCase(a1)
				&& !a2.equalsIgnoreCase(a3)) {
			tmark = tmark + 1;
		} else {
			tmark = tmark + 0;
		}
		if ((a3.equalsIgnoreCase("density"))
				|| (a3.equalsIgnoreCase("viscosity"))
				|| a3.equalsIgnoreCase("temperature")
				|| a3.equalsIgnoreCase("pressure") && !a3.equalsIgnoreCase(a2)
				&& !a3.equalsIgnoreCase(a1)) {
			tmark = tmark + 1;
		} else {
			tmark = tmark + 0;
		}

		// Q3 Checking
		a4 = ans4.getText().toString();
		if (a4 == "10") {
			tmark = tmark + 1;
		} else {
			tmark = tmark + 0;
		}

		// Q4 Checking
		btn4 = (RadioButton) findViewById(R.id.radio3);
		btn5 = (RadioButton) findViewById(R.id.radio4);
		btn6 = (RadioButton) findViewById(R.id.radio5);

		if (btn5.isChecked()) {
			tmark = tmark + 1;
		} else {
			tmark = tmark + 0;
		}
		// Q5 Checking
		a5 = ans5.getText().toString();
		a6 = ans6.getText().toString();
		a7 = ans7.getText().toString();
		a8 = ans8.getText().toString();
		if ((a5.equalsIgnoreCase("water")) && !a5.equalsIgnoreCase(a6)
				&& !a5.equalsIgnoreCase(a7) && !a5.equalsIgnoreCase(a8)) {
			tmark = tmark + 1;
		} else {
			tmark = tmark + 0;
		}

		if ((a6.equalsIgnoreCase("methanol")) && !a6.equalsIgnoreCase(a5)
				&& !a6.equalsIgnoreCase(a7) && !a6.equalsIgnoreCase(a8)) {
			tmark = tmark + 1;
		} else {
			tmark = tmark + 0;
		}
		if ((a7.equalsIgnoreCase("oil")) && !a7.equalsIgnoreCase(a6)
				&& !a7.equalsIgnoreCase(a5) && !a7.equalsIgnoreCase(a8)) {
			tmark = tmark + 1;
		} else {
			tmark = tmark + 0;
		}
		if ((a8.equalsIgnoreCase("mercury")) && !a8.equalsIgnoreCase(a6)
				&& !a8.equalsIgnoreCase(a7) && !a8.equalsIgnoreCase(a5)) {
			tmark = tmark + 1;
		} else {
			tmark = tmark + 0;
		}
		mark = tmark * 10;
		int m = Math.round(mark);
		// Intent intent = new Intent(this, Spinner.class);
		// startActivity(intent);
		switch (m) {
		case 100:
		case 90:
		case 80:
			Toast.makeText(this, "You Total Mark is " + Integer.toString(m) + " out of 100. Well Done!",
					Toast.LENGTH_SHORT).show();
			break;
		
		case 70:
		case 60:
		case 50:
			Toast.makeText(this, "You Total Mark is " + Integer.toString(m) + " out of 100. You need to work harder!",
					Toast.LENGTH_SHORT).show();
			break;
		case 40:
		case 30:
		case 20:
		case 10:
		case 0:
			Toast.makeText(this, "You Total Mark is " + Integer.toString(m) + " out of 100. Study Again!",
					Toast.LENGTH_SHORT).show();
			break;
		}
		
		
		//Toast.makeText(this, "You Total Mark is " + Float.toString(mark) + "Out of 100",
			//	Toast.LENGTH_SHORT).show();

	}
}