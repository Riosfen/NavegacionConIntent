package com.example.samo_.navegacionconintent.Fragments.Calcular;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.samo_.navegacionconintent.R;

import static android.app.Activity.RESULT_OK;

public class FragmentCalcular extends Fragment {
    private static final int REQUEST_CODE = 10;
    private OnFragmentInteractionListener mListener;
    private EditText editCantidad, editPrecio;
    private Button btnCalcular;
    private TextView txtVuelta;


    public FragmentCalcular() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_calcular, container, false);

        editCantidad = (EditText) v.findViewById(R.id.editCantidad);
        editPrecio = (EditText) v.findViewById(R.id.editPrecio);
        btnCalcular = (Button) v.findViewById(R.id.btnCalcular);
        txtVuelta = (TextView) v.findViewById(R.id.txtVuelta);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int total;
                String cadenaCantidad, cadenaPrecio;

                cadenaCantidad=editCantidad.getText().toString();
                cadenaPrecio=editPrecio.getText().toString();

                if (!cadenaCantidad.equalsIgnoreCase("") && !cadenaPrecio.equalsIgnoreCase("")){
                    total=Integer.parseInt(cadenaCantidad)*Integer.parseInt(cadenaPrecio);
                    //Crea pantalla dos
                    Intent i=new Intent(getActivity().getApplicationContext(), ActivityVuelta.class);

                    //Creamos la variable que vamos a manipular
                    i.putExtra("total", total);

                    startActivityForResult(i, REQUEST_CODE);
                }
            }
        });

        return v;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        String cambioDos;

        //Esto dos valores coinciden si ha recogido los valores
        if (resultCode==RESULT_OK && requestCode==REQUEST_CODE) {
            if (data.hasExtra("cambio")) {
                cambioDos = data.getExtras().getString("cambio");

                txtVuelta.setText(txtVuelta.getText().toString() + String.valueOf(cambioDos));
            }
        }
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
