package com.example.listadecontactos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DetalleContacto extends AppCompatActivity {

   private  TextView tvNombre;
   private  TextView tvTelefono;
   private  TextView tvEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);

       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Toolbar miActionBar = findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        Bundle parametros   = getIntent().getExtras();
        String nombre       = parametros.getString(getResources().getString(R.string.pnombre));
        String telefono     = parametros.getString(getResources().getString(R.string.ptelefono));
        String email        = parametros.getString(getResources().getString(R.string.pemail));

        tvNombre   = findViewById(R.id.tvNombre);
        tvTelefono = findViewById(R.id.tvTelefono);
        tvEmail    = findViewById(R.id.tvEmail);

        tvNombre.setText(nombre);
        tvTelefono.setText(telefono);
        tvEmail.setText(email);
    }

    public void llamar(View v){
        String telefono=tvTelefono.getText().toString();
        startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel"+ telefono)));

    }

    public void enviarEmail(View v){
      String email= tvEmail.getText().toString();
      Intent emailInten = new Intent(Intent.ACTION_SEND);
      emailInten.setData(Uri.parse("mailto"));
      emailInten.putExtra(Intent.EXTRA_EMAIL,email);
      startActivity(Intent.createChooser(emailInten,"Email"));
    }
}