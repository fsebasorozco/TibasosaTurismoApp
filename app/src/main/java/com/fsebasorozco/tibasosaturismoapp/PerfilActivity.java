package com.fsebasorozco.tibasosaturismoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import static com.fsebasorozco.tibasosaturismoapp.LogginActivity.email;
import static com.fsebasorozco.tibasosaturismoapp.LogginActivity.pass;
import static com.fsebasorozco.tibasosaturismoapp.LogginActivity.repass;
import static com.fsebasorozco.tibasosaturismoapp.LogginActivity.user;

public class PerfilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        TextView txtUser = (TextView)findViewById(R.id.txtLogin2);
        txtUser.setText(user);

        TextView txtPass = (TextView)findViewById(R.id.txtPass2);
        txtPass.setText(pass);

        TextView txtRePass = (TextView)findViewById(R.id.txtRePass2);
        txtRePass.setText(repass);

        TextView txtEmail = (TextView)findViewById(R.id.txtEmail2);
        txtEmail.setText(email);
    }
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu2,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        if(id == R.id.menu1)
        {
            Toast.makeText(getApplicationContext(), "Bienvenido de vuelta", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this,MainActivity.class);
            startActivityForResult(intent, 4567);
            setResult(RESULT_OK,intent);
            finish();
        }else if(id == R.id.menu2)
        {
            Toast.makeText(getApplicationContext(), "Vuelva pronto", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this,LogginActivity.class);
            startActivityForResult(intent, 1234);
            setResult(RESULT_OK,intent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
