package com.technionrankerv1;

import java.util.ArrayList;
import java.util.Arrays;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

public class SearchableActivity extends ListActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.w("MyApp", "In Searchable");
		// show the
		// results
		// Get the intent, verify the action and get the query

		Intent intent = getIntent();
		if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
			String query = intent.getStringExtra(SearchManager.QUERY);
			Log.d("MyApp", "value:"+query);
			Bundle b = new Bundle();
			b.putString("query", query);
			Intent newIntent = new Intent(getApplicationContext(),SearchResults.class);
			newIntent.putExtras(b);
			startActivity(newIntent);
		}

		//Toast.makeText(getApplicationContext(), "bbb", Toast.LENGTH_LONG)
			//	.show();

		// }

		/*
		 * public void doMySearch(String query) { Context
		 * context=getBaseContext(); SearchableAdapter sa=new
		 * SearchableAdapter(getBaseContext()); sa. }
		 */
		/*
		 * public class MyAdapter { public MyAdapter(Context context, int
		 * layoutResourceId, String[] places) { super(context, layoutResourceId,
		 * places); this.context = context;
		 * 
		 * this.data = Arrays.asList(places); this.origData = new
		 * ArrayList<String>(this.data);
		 * 
		 * } }
		 */
	}

	/*
	 * @Override public boolean onCreateOptionsMenu(Menu menu) { // Inflate the
	 * menu items for use in the action bar MenuInflater inflater =
	 * getMenuInflater(); inflater.inflate(R.menu.main_activity_actions, menu);
	 * // Get the SearchView and set the searchable configuration MenuItem
	 * searchItem=menu.findItem(R.id.action_search); SearchView
	 * searchView=(SearchView)MenuItemCompat.getActionView(searchItem);
	 * SearchManager searchManager = (SearchManager)
	 * getSystemService(Context.SEARCH_SERVICE); //SearchView searchView =
	 * (SearchView) menu.findItem(R.id.action_search) // .getActionView(); //
	 * Assumes current activity is the searchable activity
	 * searchView.setSearchableInfo(searchManager
	 * .getSearchableInfo(getComponentName()));
	 * searchView.setIconifiedByDefault(false); // Do not iconify the widget; //
	 * expand it by default // searchView.setSubmitButtonEnabled(true); return
	 * true; }
	 *//*
		 * @Override public boolean onCreateOptionsMenu(Menu menu) { // Inflate
		 * the menu items for use in the action bar MenuInflater inflater =
		 * getMenuInflater(); inflater.inflate(R.menu.main_activity_actions,
		 * menu); // Get the SearchView and set the searchable configuration
		 * MenuItem searchItem = menu.findItem(R.id.action_search); SearchView
		 * searchView = (SearchView) MenuItemCompat .getActionView(searchItem);
		 * SearchManager searchManager = (SearchManager)
		 * getSystemService(Context.SEARCH_SERVICE); // SearchView searchView =
		 * (SearchView) // menu.findItem(R.id.action_search) //
		 * .getActionView(); // Assumes current activity is the searchable
		 * activity searchView.setSearchableInfo(searchManager
		 * .getSearchableInfo(getComponentName()));
		 * searchView.setIconifiedByDefault(false); // Do not iconify the //
		 * widget; // expand it by default //
		 * searchView.setSubmitButtonEnabled(true);
		 * 
		 * return true; }
		 */
}
