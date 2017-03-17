package com.fsebasorozco.tibasosaturismoapp;

import android.content.Intent;
import android.os.StrictMode;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;
import android.widget.Toast;

import static com.fsebasorozco.tibasosaturismoapp.LogginActivity.email;
import static com.fsebasorozco.tibasosaturismoapp.LogginActivity.pass;
import static com.fsebasorozco.tibasosaturismoapp.LogginActivity.repass;
import static com.fsebasorozco.tibasosaturismoapp.LogginActivity.user;

public class SitesActivity extends AppCompatActivity {


    private String categoria;
    private String tab1,tab2,tab3;
    private String titulo1,titulo2,titulo3;//Titulos para los fragment.
    private int rutaimg1,rutaimg2,rutaimg3;//Envio el ID de la imagen.
    private String descr1,descr2,descr3;//Texto para el manejo de las descripciones.

    FragmentManager fm;
    FragmentTransaction ft;
    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;
    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extras = getIntent().getExtras();

        categoria = extras.getString("categoria");
        if(categoria.equals("restaurantes")){
            tab1="Tierra de Feijoa";
            tab2="Pivijay";
            tab3="Casona Boyacense";
            titulo1="Tierra de Feijoa";
            titulo2="Pivijay Cocina Fusion";
            titulo3="Casona Boyacense";

            rutaimg1=R.drawable.tierradefeijoa;
            rutaimg2=R.drawable.pivijay;
            rutaimg3=R.drawable.casonaboyacense;

            descr1= String.valueOf(R.string.Dres1);
            descr2= String.valueOf(R.string.Dres2);
            descr3= String.valueOf(R.string.Dres3);
        }
        else if(categoria.equals("hoteles")){
            tab1=String.valueOf(R.string.Hotel1);
            tab2=String.valueOf(R.string.Hotel2);
            tab3=String.valueOf(R.string.Hotel3);

            titulo1= String.valueOf(R.string.Hotel1);
            titulo2= String.valueOf(R.string.Hotel2);
            titulo3= String.valueOf(R.string.Hotel3);


            rutaimg1=R.drawable.laromelia;
            rutaimg2=R.drawable.suescun;
            rutaimg3=R.drawable.elmilagro;

            descr1=String.valueOf(R.string.Dhotel1);
            descr2=String.valueOf(R.string.Dhotel2);
            descr3=String.valueOf(R.string.Dhotel3);
        }
        else if(categoria.equals("sitios")){//turisticos en realidad, no habian bares :'(
            tab1=String.valueOf(R.string.Bar1);
            tab2=String.valueOf(R.string.Bar2);
            tab3=String.valueOf(R.string.Bar3);

            titulo1=String.valueOf(R.string.Bar1);
            titulo2=String.valueOf(R.string.Bar2);
            titulo3=String.valueOf(R.string.Bar3);

            rutaimg1=R.drawable.guatika;
            rutaimg2=R.drawable.cascourbano;
            rutaimg3=R.drawable.cerrobolivar;


            descr1=String.valueOf(R.string.Dbar1);
            descr2=String.valueOf(R.string.Dbar2);
            descr3=String.valueOf(R.string.Dbar3);

        }


        setContentView(R.layout.activity_sites);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());


        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sites, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.perfil1) {
            Toast.makeText(getApplicationContext(), "Bienvenido a su perfil", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this,PerfilActivity.class);
            intent.putExtra("User2",user);
            intent.putExtra("Pass2",pass);
            intent.putExtra("RePass2",repass);
            intent.putExtra("Email2",email);
            startActivityForResult(intent, 4567);
            setResult(RESULT_OK,intent);
            finish();
        }else if(id == R.id.menubar3)
        {
            Intent intent = new Intent(this,SitesActivity.class);
            intent.putExtra("categoria","sitios");
            startActivityForResult(intent,1234);
            setResult(RESULT_OK,intent);
            finish();
        }else if(id == R.id.menuhotel3)
        {
            Intent intent = new Intent(this,SitesActivity.class);
            intent.putExtra("categoria","hoteles");
            startActivityForResult(intent,2222);
            setResult(RESULT_OK,intent);
            finish();
        }else if(id == R.id.menurestaurant3)
        {
            Intent intent = new Intent(this,SitesActivity.class);
            intent.putExtra("categoria","restaurantes");
            startActivityForResult(intent,3333);
            setResult(RESULT_OK,intent);
            finish();
        }else if(id == R.id.menuend2)
        {
            Toast.makeText(getApplicationContext(), "Ha salido correctamente", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this,LogginActivity.class);

            startActivityForResult(intent, 1234);
            setResult(RESULT_OK,intent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).

            Bundle data;

            if(categoria.equals("restaurantes")){
                switch (position){
                    case 0:
                        RestaurantFragment tab1=new RestaurantFragment();
                        tab1.setCategoria(0);/*
                        data = new Bundle();
                        data.putString("titulo", titulo1);
                        data.putInt("imagen", rutaimg1);
                        data.putString("informacion", descr1);
                        tab1.setArguments(data);*/
                        return tab1;

                    case 1:
                        RestaurantFragment tab2=new RestaurantFragment();
                        tab2.setCategoria(1);
                        data = new Bundle();
                        data.putString("titulo", titulo2);
                        data.putInt("imagen", rutaimg2);
                        data.putString("informacion", descr2);
                        tab2.setArguments(data);
                        return tab2;
                    case 2:
                        RestaurantFragment tab3=new RestaurantFragment();
                        tab3.setCategoria(2);
                        data = new Bundle();
                        data.putString("titulo", titulo3);
                        data.putInt("imagen", rutaimg3);
                        data.putString("informacion", descr3);
                        tab3.setArguments(data);
                        return tab3;
                    default:return null;
                }
            }
            else if(categoria.equals("hoteles")){
                switch (position){
                    case 0:
                        HotelFragment tab1=new HotelFragment();
                        tab1.setCategoria(0);/*
                        data = new Bundle();
                        data.putString("titulo", titulo1);
                        data.putInt("imagen", rutaimg1);
                        data.putString("informacion", descr1);
                        tab1.setArguments(data);*/
                        return tab1;

                    case 1:
                        HotelFragment tab2=new HotelFragment();
                        tab2.setCategoria(1);
                        data = new Bundle();
                        data.putString("titulo", titulo2);
                        data.putInt("imagen", rutaimg2);
                        data.putString("informacion", descr2);
                        tab2.setArguments(data);
                        return tab2;
                    case 2:
                        HotelFragment tab3=new HotelFragment();
                        tab3.setCategoria(2);
                        data = new Bundle();
                        data.putString("titulo", titulo3);
                        data.putInt("imagen", rutaimg3);
                        data.putString("informacion", descr3);
                        tab3.setArguments(data);
                        return tab3;
                    default:return null;
                }
            }
            else if(categoria.equals("turisticos")){
                switch (position){
                    case 0:
                        BarFragment tab1=new BarFragment();
                        tab1.setCategoria(0);
                        data = new Bundle();
                        data.putString("titulo", titulo1);
                        data.putInt("imagen", rutaimg1);
                        data.putString("informacion", descr1);
                        tab1.setArguments(data);
                        return tab1;

                    case 1:
                        BarFragment tab2=new BarFragment();
                        tab2.setCategoria(1);
                        data = new Bundle();
                        data.putString("titulo", titulo2);
                        data.putInt("imagen", rutaimg2);
                        data.putString("informacion", descr2);
                        tab2.setArguments(data);
                        return tab2;
                    case 2:
                        BarFragment tab3=new BarFragment();
                        tab3.setCategoria(2);
                        data = new Bundle();
                        data.putString("titulo", titulo3);
                        data.putInt("imagen", rutaimg3);//LLeva el id de la imagen en tipo int.
                        data.putString("informacion", descr3);
                        tab3.setArguments(data);
                        return tab3;
                    default:return null;
                }
            }
            else{
                return null;
            }

            //Esto es lo que carga los fragment.

        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            //Log.d("dato", tab1);
            switch (position) {

                case 0:
                    return tab1;
                case 1:
                    return tab2;
                case 2:
                    return tab3;
            }
            return null;
        }
    }
}
