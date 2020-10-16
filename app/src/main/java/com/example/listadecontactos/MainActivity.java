package com.example.listadecontactos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridLayout;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Contacto> contactos;
    private RecyclerView listaContactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        //Toolbar miActionBar = findViewById(R.id.miActionBar);
        //setSupportActionBar(miActionBar);

        listaContactos = (RecyclerView) findViewById(R.id.rvContactos);

        LinearLayoutManager llm = new LinearLayoutManager(this);
       // GridLayoutManager glm = new GridLayoutManager(this,2);


        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaContactos.setLayoutManager(llm);
        inicializarListaDeContactos();
        inicializarAdaptador();




       /* ArrayList<String >nombresContactos = new ArrayList<>();
        for (Contacto contacto : contactos){
            nombresContactos.add(contacto.getNombre());
         }
*/
        /*
        ListView lstContactos = findViewById(R.id.lstContactos);
        lstContactos.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,nombresContactos));

        lstContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, DetalleContacto.class);
                intent.putExtra(getResources().getString(R.string.pnombre),contactos.get(i).getNombre());
                intent.putExtra(getResources().getString(R.string.ptelefono),contactos.get(i).getTelefono());
                intent.putExtra(getResources().getString(R.string.pemail),contactos.get(i).getEmail());

                startActivity(intent);
            }
        });

         */
    }

    public  ContactoAdaptador adaptador;
    public void inicializarAdaptador(){
       // ContactoAdaptador adaptador= new ContactoAdaptador(contactos,this);// ya no lo utilizamos esto o pasaba a los detalles
       // listaContactos.setAdapter(adaptador);//este ya no lo utilizamos , este no no lo pasaba a los detalles
        //adaptador= new ContactoAdaptador(contactos,this);
        adaptador= new ContactoAdaptador(contactos,this);
        listaContactos.setAdapter(adaptador);


    }

    public void inicializarListaDeContactos(){

        contactos= new ArrayList<Contacto>();

        contactos.add(new Contacto(R.drawable.jillkelly,"Renso David","12345","arcadu22@hotmail.com"));
        contactos.add(new Contacto(R.drawable.tera,"Jose David","54321","arcadu22@hotmail.com"));
        contactos.add(new Contacto(R.drawable.terapatrick,"juan jose","0986","arcadu22@Gmail.com"));
        contactos.add(new Contacto(R.drawable.medellin,"Luz Edilma","678","arcadu22@Yahoo.com"));
        contactos.add(new Contacto(R.drawable.juliann,"Jesus Salvador","68956w646","hola.@l.com"));
    }

}