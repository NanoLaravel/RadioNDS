package com.herfan.radionds;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Adaptador extends BaseAdapter {
    public Context context;
    private int layout;
    private List<String> nombres;
    private List<String> descripciones;
    private int[] imagenes;

    public  Adaptador(Context context, int layout, List<String> nombres, List<String> descripciones, int[] imagenes){
        this.context = context;
        this.layout = layout;
        this.nombres = nombres;
        this.descripciones = descripciones;
        this.imagenes = imagenes;
    }


    @Override
    public int getCount() {

        return nombres.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v;
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        v = layoutInflater.inflate(R.layout.elemento, null);

        String nombreActual = nombres.get(position);
        String descripcionActual = descripciones.get(position);
        int imgActual = imagenes[position];

        TextView txtNombre = v.findViewById(R.id.txtNombre);
        TextView txtDescripcion = v.findViewById(R.id.txtDescripcion);
        ImageView imgFoto = v.findViewById(R.id.imgFoto);

        txtNombre.setText(nombreActual);
        txtDescripcion.setText(descripcionActual);
        imgFoto.setImageResource(imgActual);

        return v;


    }
}
