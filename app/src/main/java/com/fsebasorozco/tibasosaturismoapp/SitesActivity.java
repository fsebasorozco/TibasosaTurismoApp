package com.fsebasorozco.tibasosaturismoapp;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.PagerAdapter;
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

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private PagerAdapter mPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sites);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.

        mPagerAdapter = new PagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mPagerAdapter);

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

        }else if(id == R.id.menuhotel3)
        {

        }else if(id == R.id.menurestaurant3)
        {

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

    public class PagerAdapter extends FragmentPagerAdapter{

        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0: BarFragment tab1 = new BarFragment();
                    return tab1;
                case 1: HotelFragment tab2 = new HotelFragment();
                    return tab2;
                case 2: RestaurantFragment tab3 = new RestaurantFragment();
                    return tab3;
                default: return null;
            }
        }

        @Override
        public int getCount() {
            return 0;
        }
    }

}
