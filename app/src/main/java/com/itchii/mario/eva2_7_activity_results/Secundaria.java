package com.itchii.mario.eva2_7_activity_results;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Secundaria extends AppCompatActivity {

    EditText edtTxtResultado;
    Button btnSecundaria;

    Intent resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secundaria);

        edtTxtResultado = (EditText) findViewById(R.id.edtTxtResultado);
        btnSecundaria = (Button) findViewById(R.id.btnSecundaria);

        resultado = new Intent();
    }

    public void clickSegunda(View v) {
        String texto = edtTxtResultado.getText().toString();
        resultado.putExtra("misDatos", texto);
        setResult(Activity.RESULT_OK, resultado);
        finish();
    }
}
