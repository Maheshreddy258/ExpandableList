package com.example.mahesh.expandablelist;



import android.app.Activity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends Activity {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);
    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("TVs");
        listDataHeader.add("Bikes");
        listDataHeader.add("Laptops");

        // Adding child data
        List<String> TVs = new ArrayList<String>();
        TVs.add("LCDs");
        TVs.add("LEDs");
        TVs.add("SMART");
        TVs.add("ANDROID");


        List<String> Bikes = new ArrayList<String>();
        Bikes.add("Hero");
        Bikes.add("Honda");
        Bikes.add("Bajaj");
        Bikes.add("KTM");

        List<String> Laptops = new ArrayList<String>();
        Laptops.add("Hp");
        Laptops.add("Dell");
        Laptops.add("Lenevo");

        listDataChild.put(listDataHeader.get(0), TVs); // Header, Child data
        listDataChild.put(listDataHeader.get(1), Bikes);
        listDataChild.put(listDataHeader.get(2), Laptops);
    }
}