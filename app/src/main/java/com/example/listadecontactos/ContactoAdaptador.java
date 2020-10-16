package com.example.listadecontactos;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactoAdaptador extends RecyclerView.Adapter<ContactoAdaptador.ContactoViewHolder>{

    ArrayList<Contacto> contactos;
    Activity activity;

    public ContactoAdaptador (ArrayList<Contacto> contactos,Activity activity){
        this.contactos =contactos;
        this.activity = activity;
    }

    @Override
    public ContactoViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_contacto,parent,false);
   //infla el layout y lo pasa al view holder para obtener los view
        return new ContactoViewHolder(v);
    }

    @Override
    public void onBindViewHolder( ContactoViewHolder contactoViewHolder, int position) {
       final Contacto contacto = contactos.get(position);
       contactoViewHolder.imgFoto.setImageResource(contacto.getFoto());
       contactoViewHolder.tvNombreCv.setText(contacto.getNombre());
       contactoViewHolder.tvTelefonoCv.setText(contacto.getTelefono());

       contactoViewHolder.imgFoto.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Toast.makeText(activity, contacto.getNombre(),Toast.LENGTH_SHORT).show();
               Intent intent = new Intent(activity,DetalleContacto.class);
               intent.putExtra("nombre",contacto.getNombre());
               intent.putExtra("telefono",contacto.getTelefono());
               intent.putExtra("email",contacto.getEmail());
               activity.startActivity(intent);
           }
       });

       contactoViewHolder.btnLike.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Toast.makeText(activity,"Se dio Like a "+ contacto.getNombre(),
                       Toast.LENGTH_SHORT).show();
           }
       });

    }

    @Override
    public int getItemCount() {  //cantidad de elementos que contiene mi lista
        return contactos.size();
    }

    public static class ContactoViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        private TextView tvNombreCv;
        private TextView tvTelefonoCv;
        private ImageButton btnLike;

        public ContactoViewHolder( View itemView) {
            super(itemView);
            imgFoto      = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombreCv   =(TextView) itemView.findViewById(R.id.tvNombreCv);
            tvTelefonoCv =(TextView) itemView.findViewById(R.id.tvTelefonoCv);
            btnLike =itemView.findViewById(R.id.btnLike);
        }
    }
}
