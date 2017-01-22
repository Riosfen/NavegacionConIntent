package com.example.samo_.navegacionconintent.Fragments.Lista;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.samo_.navegacionconintent.Fragments.Lista.ObjetosLista.AdaptadorLista;
import com.example.samo_.navegacionconintent.Fragments.Lista.ObjetosLista.ListaLugares;
import com.example.samo_.navegacionconintent.Fragments.Lista.ObjetosLista.Lugar;
import com.example.samo_.navegacionconintent.Fragments.Lista.ObjetosLista.TipoLugar;
import com.example.samo_.navegacionconintent.R;


public class ListFragmentLugares extends ListFragment {
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;
    private ListaLugares listaLugares;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_listalugares, container, false);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        listaLugares = new ListaLugares();

        listaLugares.addLugar(new Lugar("Dunkin Coffe", "Calle Buenavista", "954469391", TipoLugar.CAFETERIA));
        listaLugares.addLugar(new Lugar("Bar Moral", "Calle Olivo", "954111391", TipoLugar.RESTAURANTE));
        listaLugares.addLugar(new Lugar("El Sitio", "Calle Limonero", "954422291", TipoLugar.CAFETERIA));
        listaLugares.addLugar(new Lugar("Camelot", "Calle Sinceridad", "958889391", TipoLugar.DISCOTECA));
        listaLugares.addLugar(new Lugar("Repsol", "Avenida de Sevilla", "954465491", TipoLugar.GASOLINERA));
        listaLugares.addLugar(new Lugar("La Mafia se Sienta en la Mesa", "Calle Aire", "954785391", TipoLugar.RESTAURANTE));
        listaLugares.addLugar(new Lugar("Los Rosales", "Calle Futuro", "989469391", TipoLugar.HOTEL));
        listaLugares.addLugar(new Lugar("Barcelo", "Calle Franquicia", "954475391", TipoLugar.HOTEL));
        listaLugares.addLugar(new Lugar("Dedalo", "Calle Constitucion", "951239391", TipoLugar.DISCOTECA));
        listaLugares.addLugar(new Lugar("Bar de Rosa", "Calle Pirotecnia", "954456391", TipoLugar.CAFETERIA));

        AdaptadorLista adaptadorLista = new AdaptadorLista(getActivity().getApplicationContext(), listaLugares);
        setListAdapter(adaptadorLista);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnListFragmentInteractionListener {
        void onListFragmentInteraction(ListaLugares item);
    }
}
