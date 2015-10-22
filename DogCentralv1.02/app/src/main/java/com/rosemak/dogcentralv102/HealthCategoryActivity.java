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
public class HealthCategoryActivity extends Activity {
    ListView healthListview;
    Intent intent;
    //public HashMap<Integer, Categories> allCategories = new HashMap<Integer, Categories>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_category);
        if (savedInstanceState == null){
            healthListview = (ListView) findViewById(R.id.health_listview);
            String[] dogActivities = new String[]{"Vet"};
            //res = getResources();

            // listViewAdapter = new ListViewCategoryAdapter(ServicesCategoryActivity.this, R.layout.listview_categoryrow, dogActivities, res);
            //servicesCategoryListview.setAdapter(listViewAdapter);


            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,android.R.id.text1, dogActivities);
            healthListview.setAdapter(adapter);

            healthListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                    Log.d("TEST", "listview click");

                    int itemPosition = position;
                    String itemValue = (String) healthListview.getItemAtPosition(position);

                    // Toast.makeText(getApplicationContext(), "Position:" +itemPosition+" ListItem:" + itemValue, Toast.LENGTH_LONG).show();
                    intent = new Intent(HealthCategoryActivity.this, ServicesDetailActivityListview.class);
                    startActivity(intent);
                }
            });
        }
    }
}
