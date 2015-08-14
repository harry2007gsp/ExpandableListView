package com.example.expandablelistview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;
import android.widget.ExpandableListView.OnChildClickListener;

public class MainActivity extends ActionBarActivity {
	
    ExpandableListAdapter mAdapter;
    ExpandableListView	mListView;
    List<String> mBranches;
    HashMap<String, List<String>> mStudentsData;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		createStudentData();
		mListView=(ExpandableListView)findViewById(R.id.expanList);
		mAdapter = new ExpandableListAdapter(this, mBranches,mStudentsData);
		mListView.setAdapter(mAdapter);
		mListView.setOnChildClickListener(new OnChildClickListener() {
			
			@Override
			public boolean onChildClick(ExpandableListView arg0, View arg1, int arg2,
					int arg3, long arg4) {
				Toast.makeText(MainActivity.this, " Show Toast", Toast.LENGTH_LONG).show();
				return false;
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	private void createStudentData() {
		mBranches = new ArrayList<String>();
		mStudentsData = new HashMap<String, List<String>>();
 
        mBranches.add("Computer");
        mBranches.add("Mechanical");
        mBranches.add("Electrical");
 
        List<String> compStudents = new ArrayList<String>();
        compStudents.add("ABC");
        compStudents.add("KLM");
        compStudents.add("XYZ");
       
        List<String> mechStudents = new ArrayList<String>();
        mechStudents.add("123");
        mechStudents.add("787");
        mechStudents.add("456");
       
        List<String> electricalStudents = new ArrayList<String>();
        electricalStudents.add("ABC123");
        electricalStudents.add("KLM787");
        electricalStudents.add("XYZ456");
       
        mStudentsData.put(mBranches.get(0), compStudents); 
        mStudentsData.put(mBranches.get(1), mechStudents);
        mStudentsData.put(mBranches.get(2), electricalStudents);
}
}
