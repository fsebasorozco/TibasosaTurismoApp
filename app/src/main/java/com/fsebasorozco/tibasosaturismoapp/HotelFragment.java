package com.fsebasorozco.tibasosaturismoapp;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import  com.fsebasorozco.tibasosaturismoapp.R;

/**
 * Created by US on 13/03/2017.
 */

public class HotelFragment extends Fragment {

        public HotelFragment() {
            // empty constructor
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
            final View view = inflater.inflate(R.layout.fragment_hotel, container, false);
            return view;
        }
}

