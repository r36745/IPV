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
 * Created by stevierose on 10/20/15.
 */
public class ServicesDetailActivityListview extends Activity {

    ListView servicesDetailListview;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services_details_listview);
        if (savedInstanceState == null){
            servicesDetailListview = (ListView) findViewById(R.id.services_details_listview);
            String[] dogActivities = new String[]{"Jans Walking Service", "Happy Walkers", "Walking For Life",
                    "Big Dog Walker", "Fido Walks", "Bark Bark Walk ", "Leash Time"};
            //res = getResources();

            // listViewAdapter = new ListViewCategoryAdapter(ServicesCategoryActivity.this, R.layout.listview_categoryrow, dogActivities, res);
            //servicesCategoryListview.setAdapter(listViewAdapter);


            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,android.R.id.text1, dogActivities);
            servicesDetailListview.setAdapter(adapter);

            servicesDetailListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                    Log.d("TEST", "listview click");

                    int itemPosition = position;
                    String itemValue = (String)servicesDetailListview.getItemAtPosition(position);

                    // Toast.makeText(getApplicationContext(), "Position:" +itemPosition+" ListItem:" + itemValue, Toast.LENGTH_LONG).show();
                    //Put Intent here
                    intent = new Intent(ServicesDetailActivityListview.this, DetailActivity.class);
                    startActivity(intent);

                }
            });
        }
    }

}
