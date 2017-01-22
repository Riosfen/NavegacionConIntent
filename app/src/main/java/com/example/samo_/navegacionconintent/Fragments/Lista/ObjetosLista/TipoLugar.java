package com.example.samo_.navegacionconintent.Fragments.Lista.ObjetosLista;

import com.example.samo_.navegacionconintent.R;

/**
 * Created by elko91 on 12/11/16.
 */

public enum TipoLugar {
    RESTAURANTE("restaurante", R.drawable.img_restaurante),
    GASOLINERA("gasolinera", R.drawable.img_gasolinera),
    CAFETERIA("Cafeteria",R.drawable.img_cafeteria),
    DISCOTECA("Discoteca",R.drawable.img_disco),
    HOTEL("Hotel",R.drawable.img_hotel);

    String tipo;
    int tipoImagen;

    TipoLugar(String tipo, int tipoImagen) {
        this.tipo = tipo;
        this.tipoImagen = tipoImagen;
    }

    public int getTipoImagen() {
        return tipoImagen;
    }

    public String getTipo() {
        return tipo;
    }
}
