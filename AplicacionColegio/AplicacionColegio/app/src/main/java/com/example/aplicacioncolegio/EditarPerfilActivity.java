package com.example.aplicacioncolegio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class EditarPerfilActivity extends AppCompatActivity {

    private RadioGroup rd;
    private RadioGroup rd2;

    private Button b;
    private EditText nombre;
    private EditText apellidos;
    private EditText correo;
    private EditText contraseña;
    private EditText contraseña2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_perfil);
        getSupportActionBar().setTitle(R.string.miCuenta);
        String[] texto= getIntent().getStringArrayExtra("texto");
        int[] botones = getIntent().getIntArrayExtra("botones");
        nombre= (EditText) findViewById(R.id.nombreRegistro);
        apellidos= (EditText) findViewById(R.id.apellidosRegistro);
        correo= (EditText) findViewById(R.id.correoRegistro);
        contraseña= (EditText) findViewById(R.id.contraseñaRegistro);
        contraseña2= (EditText) findViewById(R.id.contraseña2Registro);
        nombre.setText(texto[0]);
        apellidos.setText(texto[1]);
        correo.setText(texto[2]);
        contraseña.setText(texto[3]);
        contraseña2.setText(texto[3]);
        RadioButton puesto= (RadioButton) findViewById(botones[0]);
        RadioButton sexo = (RadioButton) findViewById(R.id.radioButtonHombre);
        puesto.setChecked(true);
        sexo.setChecked(true);
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
                RadioButton rb2= findViewById(checkedId);

            }
        });

        b= findViewById(R.id.botonRegistro);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] texto2= {nombre.getText().toString(),apellidos.getText().toString(),correo.getText().toString(),contraseña.getText().toString()};
                int[] botones= {rd.getCheckedRadioButtonId(),rd2.getCheckedRadioButtonId()};
                Intent intent;
                intent= new Intent(EditarPerfilActivity.this, MenuPrincipal.class);
                intent.putExtra("botones",botones);
                intent.putExtra("texto",texto2);

                if (rd.getCheckedRadioButtonId()==-1){
                   new MaterialAlertDialogBuilder(EditarPerfilActivity.this)
                           .setMessage(R.string.escoge_perfil)
                           .setPositiveButton(R.string.ok,null)
                           .show();
                }
                else{
                    startActivity(intent);
                }
            }
        });

    }
}