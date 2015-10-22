package com.rosemak.dogcentralv102;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.parse.Parse;

public class MainActivity extends Activity {
    private Intent intent;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "e9YxQzIudswNTuHt8Z61Y6vj9G16UZ2xaM0zuXZH", "V89mKRxkAt9pkw7MFN4BBmrrjR47oQ9ZZs45Juy7");

       /* ParseObject testObject = new ParseObject("TestObject");
        testObject.put("foo", "bar");
        testObject.saveInBackground();*/

        if (savedInstanceState == null){
            HomeFragment homeFragment = new HomeFragment();
            getFragmentManager().beginTransaction()
                    .replace(R.id.container, homeFragment, HomeFragment.TAG)
                    .commit();
        }



    }



}
