package com.example.samo_.navegacionconintent.Fragments.Calcular;

import android.content.Intent;
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

public class ActivityVuelta extends AppCompatActivity {

    private TextView total;
    private EditText recibido;
    private Button ok;
    private int value1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcular_devolver);

        total=(TextView)findViewById(R.id.txtTotal);
        recibido=(EditText)findViewById(R.id.editRecibido);
        ok=(Button)findViewById(R.id.botonOk);

        Bundle extras=getIntent().getExtras();
        if (extras==null){
            return;
        }

        value1=extras.getInt("total");

        total.setText(total.getText() + String.valueOf(value1));

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void finish() {

        int dev;

        Intent data=new Intent();
        if(recibido.getText().toString().trim().length() > 0) {
            dev=Integer.parseInt(recibido.getText().toString())-value1;

            data.putExtra("cambio", " " + dev);
            //devuelve todos los datos que queremos
            setResult(RESULT_OK, data);
        }

        super.finish();
    }

}
