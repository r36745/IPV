package com.rosemak.dogcentralv102;

import android.app.Fragment;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;

import com.parse.ui.ParseLoginBuilder;

import java.util.HashMap;

/**
 * Created by stevierose on 10/19/15.
 */
public class HomeFragment extends Fragment {
    Resources res;
    ListViewCategoryAdapter listViewCategoryAdapter;
    ListView categoryListview;
    public static final String TAG = "HomeFragment.TAG";

    public HashMap<Integer, Categories> allCategories = new HashMap<Integer, Categories>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_view_fragment, container, false);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ParseLoginBuilder builder = new ParseLoginBuilder(getActivity());
        startActivityForResult(builder.build(), 0);



    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        ImageButton healthButton = (ImageButton) getActivity().findViewById(R.id.health);
        ImageButton serviceButton = (ImageButton) getActivity().findViewById(R.id.services);
        ImageButton activityButton = (ImageButton) getActivity().findViewById(R.id.activities);

        healthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getActivity(), HealthCategoryActivity.class);
                startActivity(intent1);
            }
        });

        serviceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getActivity(), ServicesCategoryActivity.class);
                startActivity(intent1);
            }
        });

        activityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getActivity(), ActivitiesCategoryActivity.class);
                startActivity(intent1);
            }
        });
    }
}
