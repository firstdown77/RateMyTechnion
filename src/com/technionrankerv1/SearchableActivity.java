package com.technionrankerv1;

import java.util.ArrayList;
import java.util.Arrays;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class SearchableActivity extends ListActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	//	setContentView(R.layout.search);// xml file thats supposed 2 show the
										// results

		// Get the intent, verify the action and get the query
		Intent intent = getIntent();
		if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
			String query = intent.getStringExtra(SearchManager.QUERY);
			doMySearch(query);
		}
	}

	public void doMySearch(String query) {
		Context context=getBaseContext();
		SearchableAdapter sa=new SearchableAdapter(getBaseContext());
	}
/*
	public class MyAdapter {
		public MyAdapter(Context context, int layoutResourceId, String[] places) {
			super(context, layoutResourceId, places);
			this.context = context;

			this.data = Arrays.asList(places);
			this.origData = new ArrayList<String>(this.data);

		}
	}*/
}