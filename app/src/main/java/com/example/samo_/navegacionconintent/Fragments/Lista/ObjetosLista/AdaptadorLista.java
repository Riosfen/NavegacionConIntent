package com.example.samo_.navegacionconintent.Fragments.Lista.ObjetosLista;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.samo_.navegacionconintent.R;

/**
 * Created by elko91 on 12/11/16.
 */

public class AdaptadorLista extends BaseAdapter {
    private LayoutInflater inflater;
    private Context context;
    private ListaLugares listaLugares;

    private TextView nombre, direccion, telefono;
    private ImageView imagen;

    public AdaptadorLista(Context context, ListaLugares listaLugares){
        this.context = context;
        this.listaLugares = listaLugares;
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Lugar l = listaLugares.getLugar(position);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.fragment_item, null);
        }

        nombre = (TextView) convertView.findViewById(R.id.txtNombre);
        nombre.setText(l.getNombre());
        direccion = (TextView) convertView.findViewById(R.id.txtDireccion);
        direccion.setText(l.getDireccioón());
        telefono = (TextView) convertView.findViewById(R.id.txtTelefono);
        telefono.setText(l.getTelefono());

        imagen = (ImageView) convertView.findViewById(R.id.img_lista);
        switch (l.getTipo()){
            case CAFETERIA:
                imagen.setImageResource(R.drawable.img_cafeteria);
                break;
            case DISCOTECA:
                imagen.setImageResource(R.drawable.img_disco);
                break;
            case GASOLINERA:
                imagen.setImageResource(R.drawable.img_gasolinera);
                break;
            case RESTAURANTE:
                imagen.setImageResource(R.drawable.img_restaurante);
                break;
            case HOTEL:
                imagen.setImageResource(R.drawable.img_hotel);
                break;
        }
        imagen.setScaleType(ImageView.ScaleType.FIT_END);

        return convertView;
    }

    @Override
    public int getCount() {
        return listaLugares.getTamanio();
    }

    @Override
    public Object getItem(int position) {
        return listaLugares.getLugar(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
}
