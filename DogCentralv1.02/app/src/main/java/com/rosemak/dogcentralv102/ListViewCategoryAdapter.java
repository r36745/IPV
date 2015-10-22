package com.rosemak.dogcentralv102;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by stevierose on 10/19/15.
 */
public class ListViewCategoryAdapter extends BaseAdapter {

    private ArrayList<Categories> categoryData;
    private Activity activity;
    private Resources resources;
    private Categories categories;
    private LayoutInflater inflater;

    public ListViewCategoryAdapter(ServicesCategoryActivity mContext, int resource, ArrayList<Categories> categoryObjects, Resources resLocal){
        categoryData = categoryObjects;
        activity = mContext;
        resources = resLocal;

        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return categoryData.size();
    }

    @Override
    public Object getItem(int position) {
        return categoryData.get(position);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int postion, View view, ViewGroup parent) {

        View row = inflater.inflate(R.layout.listview_categoryrow, parent, false);
        categories = null;
        categories = (Categories) categoryData.get(postion);

        TextView listviewCategoryName = (TextView) row.findViewById(R.id.listView_categoryName);


        if (postion == 0) {
            listviewCategoryName.setText("Pet Services");
        } else {
            listviewCategoryName.setText(categories.getCategoryName());
        }
        return row;
    }
}
