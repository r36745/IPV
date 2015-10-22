package com.rosemak.dogcentralv102;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by stevierose on 10/20/15.
 */
public class ServicesCategoryActivity extends Activity {

    Resources res;
    ListViewCategoryAdapter listViewAdapter;
    ListView servicesCategoryListview;
    Intent intent;
    //public HashMap<Integer, Categories> allCategories = new HashMap<Integer, Categories>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services_category);
        if (savedInstanceState == null){
            servicesCategoryListview = (ListView) findViewById(R.id.services_listview);
            String[] services = new String[]{"Grooming", "Boarding", "Dog walking",
                    "adoption", "Dog Sitting"};
            //res = getResources();

           // listViewAdapter = new ListViewCategoryAdapter(ServicesCategoryActivity.this, R.layout.listview_categoryrow, dogActivities, res);
            //servicesCategoryListview.setAdapter(listViewAdapter);


            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,android.R.id.text1, services);
            servicesCategoryListview.setAdapter(adapter);

            servicesCategoryListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                    Log.d("TEST", "listview click");

                    int itemPosition = position;
                    String itemValue = (String) servicesCategoryListview.getItemAtPosition(position);

                    // Toast.makeText(getApplicationContext(), "Position:" +itemPosition+" ListItem:" + itemValue, Toast.LENGTH_LONG).show();
                    intent = new Intent(ServicesCategoryActivity.this, ServicesDetailActivityListview.class);
                    startActivity(intent);
                }
            });
        }
    }

}
