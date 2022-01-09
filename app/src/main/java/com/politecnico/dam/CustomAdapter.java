package com.politecnico.dam;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter <CustomAdapter.MyViewHolder>
{

    ArrayList<String> centroNames;
    ArrayList<String> centroDireccion;
    ArrayList<String> centroLocalidad;
    ArrayList<String> centroTelefono;
    Context context;

    public CustomAdapter(Context context, ArrayList<String> centroNames, ArrayList<String> centroDireccion, ArrayList<String> centroLocalidad , ArrayList<String> centroTelefono) {
        this.context = context;
        this.centroNames = centroNames;
        this.centroDireccion = centroDireccion;
        this.centroLocalidad = centroLocalidad;
        this.centroTelefono = centroTelefono;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // infalte the item Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlayout, parent, false);
        MyViewHolder vh = new MyViewHolder(v); // pass the view to View Holder
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        // set the data in items
        holder.nombre.setText(centroNames.get(position));
        holder.direccion.setText(centroDireccion.get(position));
        holder.localidad.setText(centroLocalidad.get(position));
        holder.telefono.setText(centroTelefono.get(position));

        // implement setOnClickListener event on item view. Al pinchar se muestra el telefono unos segundos
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // display a toast with person name on item click
                Toast.makeText(context, centroTelefono.get(position), Toast.LENGTH_SHORT).show();
            }
        });

    }


    @Override
    public int getItemCount() {
        return centroNames.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nombre, direccion, localidad,telefono;// init the item view's

        public MyViewHolder(View itemView) {
            super(itemView);

            // get the reference of item view's
            nombre = (TextView) itemView.findViewById(R.id.nombre);
            direccion = (TextView) itemView.findViewById(R.id.direccion);
            localidad = (TextView) itemView.findViewById(R.id.localidad);
            telefono = (TextView) itemView.findViewById(R.id.telefono);

        }
    }
}
