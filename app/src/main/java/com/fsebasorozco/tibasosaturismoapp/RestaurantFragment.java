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


        private int categoria;
        public RestaurantFragment() {
            // empty constructor
        }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
            switch(categoria){
                case 0:
                    final View view1 = inflater.inflate(R.layout.fragment_restaurant, container, false);
                    return view1;
                case 1:
                    final View view2 = inflater.inflate(R.layout.fragment_restaurant2, container, false);
                    return view2;
                case 2:
                    final View view3 = inflater.inflate(R.layout.fragment_restaurant3, container, false);
                    return view3;
                default:return null;
            }
        }
}

