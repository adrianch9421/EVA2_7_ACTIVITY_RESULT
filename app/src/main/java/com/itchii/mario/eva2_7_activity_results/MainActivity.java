package com.itchii.mario.eva2_7_activity_results;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txtVwResultado;
    Button btnAccion, btnContactos;

    private final int misDatos=1000;
    private final int misContactos=2000;
    Intent regresarDatos, regresaContacto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAccion = (Button) findViewById(R.id.btnAccion);
        btnContactos = (Button) findViewById(R.id.btnContactos);
        txtVwResultado = (TextView) findViewById(R.id.txtVwResultado);
        regresarDatos = new Intent(this, Secundaria.class);
        Uri uriContacto = android.provider.ContactsContract.Contacts.CONTENT_URI;
        regresaContacto =  new Intent(Intent.ACTION_PICK, uriContacto);
    }

    public void clickMain(View v) {
        startActivityForResult(regresarDatos, misDatos);
    }

    public void clickContatos(View v){
        startActivityForResult(regresaContacto, misContactos);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == misDatos) {
            if (resultCode == Activity.RESULT_OK) {
                txtVwResultado.setText(data.getStringExtra("misDatos"));
            }
        } else if (requestCode == misContactos) {
            if (resultCode == Activity.RESULT_OK) {
                //Recuperar los datos
                String contacto = data.getDataString();
//                Toast.makeText(this, data.getDataString(), Toast.LENGTH_SHORT).show();
                Intent editarContacto  = new Intent(Intent.ACTION_EDIT, Uri.parse(contacto));
                startActivity(editarContacto);
            }
        }
    }
}
