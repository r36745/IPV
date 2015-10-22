package com.rosemak.dogcentralv102;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by stevierose on 10/21/15.
 */
public class ActivitiesCategoryActivity extends Activity {

    ListView activitiesListview;
    Intent intent;
    //public HashMap<Integer, Categories> allCategories = new HashMap<Integer, Categories>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activites_category);
        if (savedInstanceState == null){
            activitiesListview = (ListView) findViewById(R.id.activities_listview);
            String[] dogActivities = new String[]{"Dog Parks", "Beaches", "Dog Bars",
                    "Pet Friendly Events"};
            //res = getResources();

            // listViewAdapter = new ListViewCategoryAdapter(ServicesCategoryActivity.this, R.layout.listview_categoryrow, dogActivities, res);
            //servicesCategoryListview.setAdapter(listViewAdapter);


            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,android.R.id.text1, dogActivities);
            activitiesListview.setAdapter(adapter);

            activitiesListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                    Log.d("TEST", "listview click");

                    int itemPosition = position;
                    String itemValue = (String) activitiesListview.getItemAtPosition(position);

                    // Toast.makeText(getApplicationContext(), "Position:" +itemPosition+" ListItem:" + itemValue, Toast.LENGTH_LONG).show();
                    intent = new Intent(ActivitiesCategoryActivity.this, ServicesDetailActivityListview.class);
                    startActivity(intent);
                }
            });
        }
    }
}
