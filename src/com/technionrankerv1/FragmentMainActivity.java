package com.technionrankerv1;

import java.util.HashMap;

import android.app.ActionBar;
import android.app.ActionBar.TabListener;
import android.app.FragmentTransaction;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

public class FragmentMainActivity extends SearchResults implements TabListener {
	private ViewPager viewPager;
	private TabsPagerAdapter mAdapter;
	private ActionBar actionBar;
	// Tab titles
	private String[] tabs = { "HOME", "COURSES", "PROFESSORS" };
	private String[] professorValuesToPassToAdapter;
	private String[] courseValuesToPassToAdapter;
	public HashMap<String, String> facultyMap;
	ApplicationWithGlobalVariables a;

	@SuppressWarnings("unchecked")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_main_activity);
		Bundle b = getIntent().getExtras();
		courseValuesToPassToAdapter = b.getStringArray("courseValues");
		professorValuesToPassToAdapter = b.getStringArray("professorValues");
		facultyMap = (HashMap<String, String>) getIntent().getSerializableExtra("facultyMap");
		
		a = ((ApplicationWithGlobalVariables) getApplication());
		// Initilization
		viewPager = (ViewPager) findViewById(R.id.pager);
		actionBar = getActionBar();
		actionBar.setStackedBackgroundDrawable(new ColorDrawable(getResources()
				.getColor(R.color.blueish)));
		mAdapter = new TabsPagerAdapter(getSupportFragmentManager());

		viewPager.setAdapter(mAdapter);
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		// Adding Tabs
		for (String tab_name : tabs) {
			actionBar.addTab(actionBar.newTab().setText(tab_name)
					.setTabListener(this));
		}
		viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

			@Override
			public void onPageSelected(int position) {
				// on changing the page make respected tab selected
				actionBar.setSelectedNavigationItem(position);
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
			}
		});
	}
	
	public String[] getProfessorValues() {
		return professorValuesToPassToAdapter;
	}

	public String[] getCourseValues() {
		return courseValuesToPassToAdapter;
	}

	@Override
	public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
	}

	@Override
	public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
		// on tab selected
		// show respected fragment view
		viewPager.setCurrentItem(tab.getPosition(), true);
	}

	@Override
	public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
	}


	@Override
	public void onBackPressed(){
		
	}
}
