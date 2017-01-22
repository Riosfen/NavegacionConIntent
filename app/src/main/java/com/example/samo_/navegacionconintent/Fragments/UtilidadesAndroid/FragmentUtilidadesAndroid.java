package com.example.samo_.navegacionconintent.Fragments.UtilidadesAndroid;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.samo_.navegacionconintent.R;

public class FragmentUtilidadesAndroid extends Fragment {
    private OnFragmentInteractionListener mListener;
    private Button btnLlamada, btnNavegar, btnMaps;
    private static final int REQUEST_CODE = 10;

    public FragmentUtilidadesAndroid() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_utilidades_android, container, false);

        btnLlamada = (Button) v.findViewById(R.id.btnLlamada);
        btnNavegar = (Button) v.findViewById(R.id.btnNavegar);
        btnMaps = (Button) v.findViewById(R.id.btnMaps);

        btnLlamada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String utilidad, codigoUtilidad, cadenaUtilidad;
                codigoUtilidad = Intent.ACTION_DIAL;
                utilidad = "Introduce el teléfono";
                cadenaUtilidad = "tel:";

                Intent i=new Intent(getActivity().getApplicationContext(), ActivityAbrirUtilidad.class);

                i.putExtra("utilidad", utilidad);
                i.putExtra("codigoUtilidad", codigoUtilidad);
                i.putExtra("cadenaUtilidad", cadenaUtilidad);

                startActivityForResult(i, REQUEST_CODE);

            }
        });

        btnNavegar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String utilidad, codigoUtilidad, cadenaUtilidad;
                codigoUtilidad = Intent.ACTION_VIEW;
                utilidad = "Introduce la URL";
                cadenaUtilidad = "http://";

                Intent i=new Intent(getActivity().getApplicationContext(), ActivityAbrirUtilidad.class);

                i.putExtra("utilidad", utilidad);
                i.putExtra("codigoUtilidad", codigoUtilidad);
                i.putExtra("cadenaUtilidad", cadenaUtilidad);

                startActivityForResult(i, REQUEST_CODE);
            }
        });

        btnMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String utilidad, codigoUtilidad, cadenaUtilidad;
                codigoUtilidad = Intent.ACTION_VIEW;
                utilidad = "Introduce la direccion\n(Calle, Localidad)";
                cadenaUtilidad = "geo:0,0?q=";

                Intent i=new Intent(getActivity().getApplicationContext(), ActivityAbrirUtilidad.class);

                i.putExtra("utilidad", utilidad);
                i.putExtra("codigoUtilidad", codigoUtilidad);
                i.putExtra("cadenaUtilidad", cadenaUtilidad);

                startActivityForResult(i, REQUEST_CODE);
            }
        });

        return v;
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
