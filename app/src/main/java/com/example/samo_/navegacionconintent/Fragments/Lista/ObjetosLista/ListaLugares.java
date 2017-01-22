package com.example.samo_.navegacionconintent.Fragments.Lista.ObjetosLista;

import java.util.ArrayList;

/**
 * Created by elko91 on 12/11/16.
 */

public class ListaLugares {
    private ArrayList<Lugar> listaLugares;

    public ListaLugares(){
        this.listaLugares = new ArrayList<>();
    }

    public  void addLugar(Lugar lugar){
        listaLugares.add(lugar);
    }

    public int getTamanio(){
        return listaLugares.size();
    }

    public Lugar getLugar(int posicion){
        return listaLugares.get(posicion);
    }
}
