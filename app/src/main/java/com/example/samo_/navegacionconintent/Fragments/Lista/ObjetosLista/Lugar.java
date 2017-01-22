package com.example.samo_.navegacionconintent.Fragments.Lista.ObjetosLista;

/**
 * Created by elko91 on 12/11/16.
 */

public class Lugar {
    private String nombre, direccioón, telefono;
    private TipoLugar tipo;

    public Lugar(String nombre, String direccioón, String telefono, TipoLugar tipo){
        this.nombre = nombre;
        this.direccioón = direccioón;
        this.telefono = telefono;
        this.tipo = tipo;
    }

    public String getDireccioón() {
        return direccioón;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public TipoLugar getTipo() {
        return tipo;
    }

    public long getId(){
        return Lugar.this.getId();
    }
}
