package com.rosemak.dogcentralv102;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by stevierose on 10/21/15.
 */
public class MapFragment extends com.google.android.gms.maps.MapFragment {
    public static final String TAG = "MapFragment.TAG";
    private GoogleMap mMap;
    private OnMapClick mListener;

    public interface OnMapClick{
        public double onLat();
        public double onLng();
        public String onMapPlace();
    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof OnMapClick) {
            mListener = (OnMapClick) activity;
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mMap = getMap();

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(mListener.onLat(), mListener.onLng()))
                .title(mListener.onMapPlace()));

        mMap.setInfoWindowAdapter(new MarkerAdapter());
        // mMap.setOnInfoWindowClickListener(this);
        // mMap.setOnMapClickListener(this);
        //mMap.setOnMapLongClickListener(this);
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(mListener.onLat(), mListener.onLng()), 16));
    }

    private class MarkerAdapter implements GoogleMap.InfoWindowAdapter {

        TextView mText;

        public MarkerAdapter() {
            mText = new TextView(getActivity());
        }

        @Override
        public View getInfoContents(Marker marker) {
            mText.setText(marker.getTitle());
            return mText;
        }

        @Override
        public View getInfoWindow(Marker marker) {
            return null;
        }
    }

}
