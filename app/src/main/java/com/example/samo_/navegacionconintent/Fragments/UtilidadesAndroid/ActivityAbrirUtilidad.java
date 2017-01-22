package com.example.samo_.navegacionconintent.Fragments.UtilidadesAndroid;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.samo_.navegacionconintent.R;

/**
 * Created by elko91 on 12/11/16.
 */

public class ActivityAbrirUtilidad extends AppCompatActivity {
    private TextView txtutilidad, txtTitulo;
    private EditText editUtilidad;
    private Button ok;
    private String utilidad, codigoUtilidad, cadenaUtilidad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abrir_utilidad);

        txtutilidad=(TextView)findViewById(R.id.txtUtilidad);
        txtTitulo = (TextView) findViewById(R.id.txtTitulo);
        editUtilidad=(EditText)findViewById(R.id.editUtilidad);
        ok=(Button)findViewById(R.id.btnUtilidad);

        Bundle extras=getIntent().getExtras();
        if (extras==null){
            return;
        }

        utilidad=extras.getString("utilidad");
        txtutilidad.setText(utilidad);
        codigoUtilidad = extras.getString("codigoUtilidad");
        cadenaUtilidad = extras.getString("cadenaUtilidad");
        switch(cadenaUtilidad){
            case "tel:":
                txtTitulo.setText("llamada");
                break;
            case "http://":
                txtTitulo.setText("navegar");
                break;
            case "geo:0,0?q=":
                txtTitulo.setText("Mapa");
                break;
        }

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editUtilidad.getText().toString().equals("")){

                }else{
                    Intent intent = new Intent(codigoUtilidad);
                    intent.setData(Uri.parse(cadenaUtilidad + editUtilidad.getText()));
                    startActivity(intent);
                }
            }
        });
    }
}
