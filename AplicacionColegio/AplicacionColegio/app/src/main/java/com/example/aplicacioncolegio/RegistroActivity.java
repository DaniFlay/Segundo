package com.example.aplicacioncolegio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class RegistroActivity extends AppCompatActivity {
    private RadioGroup rd;
    private RadioGroup rd2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        rd= findViewById(R.id.radioGroupPuestos);
        rd2= findViewById(R.id.radioGroupSexo);

        rd.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb= findViewById(checkedId);
            }
        });

        rd2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb= findViewById(checkedId);

            }
        });

        Button b = findViewById(R.id.botonRegistro);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre;
                String apellidos;
                String correo;
                String contraseña;
                Intent intent = null;
                EditText n= (EditText) findViewById(R.id.nombreRegistro);
                EditText a= (EditText) findViewById(R.id.apellidosRegistro);
                EditText c= (EditText) findViewById(R.id.correoRegistro);
                EditText pwd= (EditText) findViewById(R.id.contraseñaRegistro);
                nombre= n.getText().toString();
                apellidos= a.getText().toString();
                correo= c.getText().toString();
                contraseña= pwd.getText().toString();
                String[] datosTextuales= {nombre, apellidos, correo, contraseña};
                int[] botones= {rd.getCheckedRadioButtonId(),rd2.getCheckedRadioButtonId()};
                intent= new Intent(RegistroActivity.this, MenuPrincipal.class);
                intent.putExtra("botones",botones);
                intent.putExtra("texto",datosTextuales);
                startActivity(intent);
            }
        });

    }
}