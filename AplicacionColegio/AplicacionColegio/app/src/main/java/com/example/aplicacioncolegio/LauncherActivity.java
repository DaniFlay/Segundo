package com.example.aplicacioncolegio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class LauncherActivity extends AppCompatActivity implements View.OnClickListener {
    RadioGroup rd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        rd= findViewById(R.id.radioGroupPuestos);
        Button botonRegistro= (Button) findViewById(R.id.botonRegistro);
        Button botonInicioSesion= (Button) findViewById(R.id.botonInicioSesion);

        botonRegistro.setOnClickListener(this);
        botonInicioSesion.setOnClickListener(this);

        rd.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb= findViewById(checkedId);
            }
        });


    }

    @Override
    public void onClick(View view) {
        rd= findViewById(R.id.radioGroupPuestos);
        if(view.getId()==R.id.botonRegistro){
            Intent registro = new Intent(LauncherActivity.this, RegistroActivity.class);
            startActivity(registro);
        }else if(view.getId()==R.id.botonInicioSesion){
            EditText nombre= (EditText) findViewById(R.id.contentUsername);
            EditText pwd= (EditText) findViewById(R.id.contentPassword);
            String[] texto={nombre.getText().toString(),"Perez",nombre.getText().toString().toLowerCase()+"perez@gmail.com",pwd.getText().toString()};
            int puesto= rd.getCheckedRadioButtonId();
            int[] puestos = {puesto,1};
            Intent inicioSesion= new Intent(LauncherActivity.this,MenuPrincipal.class);
            inicioSesion.putExtra("texto",texto);
            inicioSesion.putExtra("botones",puestos);
            startActivity(inicioSesion);

        }
    }
}