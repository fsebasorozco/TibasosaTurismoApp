package com.fsebasorozco.tibasosaturismoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import static com.fsebasorozco.tibasosaturismoapp.LogginActivity.email;
import static com.fsebasorozco.tibasosaturismoapp.LogginActivity.pass;
import static com.fsebasorozco.tibasosaturismoapp.LogginActivity.repass;
import static com.fsebasorozco.tibasosaturismoapp.LogginActivity.user;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        if(id == R.id.menuover)
        {
            Toast.makeText(getApplicationContext(), "Bienvenido a su perfil", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this,PerfilActivity.class);
            intent.putExtra("User2",user);
            intent.putExtra("Pass2",pass);
            intent.putExtra("RePass2",repass);
            intent.putExtra("Email2",email);
            startActivityForResult(intent, 4567);
            setResult(RESULT_OK,intent);
            finish();
        }else if(id == R.id.menuend)
        {
            Toast.makeText(getApplicationContext(), "Ha salido correctamente", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this,LogginActivity.class);

            startActivityForResult(intent, 1234);
            setResult(RESULT_OK,intent);
            finish();
        }else if(id == R.id.menubar1)
        {
            Intent intent = new Intent(this,SitesActivity.class);
            intent.putExtra("categoria","sitios");
            startActivityForResult(intent,1111);
            setResult(RESULT_OK,intent);
            finish();
        }else if(id == R.id.menuhotel1)
        {
            Intent intent = new Intent(this,SitesActivity.class);
            intent.putExtra("categoria","hoteles");
            startActivityForResult(intent,2222);
            setResult(RESULT_OK,intent);
            //finish();
        }else if(id == R.id.menurestaurant1)
        {
            Intent intent = new Intent(this,SitesActivity.class);
            intent.putExtra("categoria","restaurantes");
            startActivityForResult(intent,3333);
            setResult(RESULT_OK,intent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
