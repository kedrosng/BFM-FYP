package com.kedros.basicfluidmech;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;



public class FirstTimeRun extends FragmentActivity implements TabListener {
	ViewPager viewPager;
	ActionBar actionBar;
	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		getActionBar().hide();
		
		setContentView(R.layout.activity_first_time_run);
		viewPager=(ViewPager) findViewById(R.id.pager);
		viewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));
		//actionBar=getActionBar();
		//actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		
		//ActionBar.Tab tab1=actionBar.newTab();
		//tab1.setText("Tab 1");
		//tab1.setTabListener(this);
		//ActionBar.Tab tab2=actionBar.newTab();
		//tab2.setText("Tab 2");
		//tab2.setTabListener(this);
		//ActionBar.Tab tab3=actionBar.newTab();
		//tab3.setText("Tab 3");
		//tab3.setTabListener(this);
	
		//actionBar.addTab(tab1);
		//actionBar.addTab(tab2);
		//actionBar.addTab(tab3);
		
	}
	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}
}

class MyAdapter extends FragmentPagerAdapter
{

	public MyAdapter(FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Fragment getItem(int arg0) {
		// TODO Auto-generated method stub
		switch (arg0){
		case 0:
			return new FragmentA();
		case 1:
			return new FragmentB();
		case 2:
			return new FragmentC();
		}
		return null;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 3;
	}
	
}




