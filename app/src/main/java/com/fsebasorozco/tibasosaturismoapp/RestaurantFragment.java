package com.fsebasorozco.tibasosaturismoapp;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by US on 13/03/2017.
 */

public class RestaurantFragment extends Fragment {

        public RestaurantFragment() {
            // empty constructor
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
            final View view = inflater.inflate(R.layout.fragment_restaurant, container, false);
            return view;
        }
}

