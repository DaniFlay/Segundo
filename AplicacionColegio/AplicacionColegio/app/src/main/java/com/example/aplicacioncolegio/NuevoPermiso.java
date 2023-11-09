package com.example.aplicacioncolegio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class NuevoPermiso extends AppCompatActivity implements  View.OnClickListener, AdapterView.OnItemSelectedListener {
    Spinner sp2 = null;

    Spinner sp1 = null;
    Permiso p= new Permiso();
    String permiso = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_permiso);
        sp2 = (Spinner) findViewById(R.id.spinner_tipo_permiso);
        sp1 = (Spinner) findViewById(R.id.spinner_razon_permiso);
        sp2.setActivated(false);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.permisos_razones, android.R.layout.simple_spinner_dropdown_item);
        sp1.setOnItemSelectedListener(this);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp1.setAdapter(adapter);
        Button b = (Button) findViewById(R.id.boton_guardar);
        b.setOnClickListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        permiso = parent.getSelectedItem().toString();
        sp2.setActivated(true);
        if (id == 0) {
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.permisos_familia, android.R.layout.simple_spinner_dropdown_item);
            sp2.setOnItemSelectedListener(this);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            sp2.setAdapter(adapter);
            permiso += sp2.getSelectedItem().toString();
        } else if (id == 1) {
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.permisos_naa, android.R.layout.simple_spinner_dropdown_item);
            sp2.setOnItemSelectedListener(this);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            sp2.setAdapter(adapter);
            permiso += sp2.getSelectedItem().toString();
        } else if (id == 2) {
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.permisos_asuntos_personales, android.R.layout.simple_spinner_dropdown_item);
            sp2.setOnItemSelectedListener(this);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            sp2.setAdapter(adapter);
            permiso += sp2.getSelectedItem().toString();
        } else if (id == 3) {
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.permisos_salud_propia, android.R.layout.simple_spinner_dropdown_item);
            sp2.setOnItemSelectedListener(this);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            sp2.setAdapter(adapter);
            permiso += sp2.getSelectedItem().toString();
        } else if (id == 4) {
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.permisos_formacion, android.R.layout.simple_spinner_dropdown_item);
            sp2.setOnItemSelectedListener(this);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            sp2.setAdapter(adapter);
            permiso += sp2.getSelectedItem().toString();
        } else if (id == 5) {
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.permisos_deberes_civiles, android.R.layout.simple_spinner_dropdown_item);
            sp2.setOnItemSelectedListener(this);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            sp2.setAdapter(adapter);
            permiso += sp2.getSelectedItem().toString();
        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {
        p.setEstado("pendiente");
        p.setNombre(permiso);
        Log.i("Permiso", p.getEstado()+" "+p.getNombre());
        if (!sp2.isActivated()) {
            new MaterialAlertDialogBuilder(NuevoPermiso.this)
                    .setMessage(R.string.rellenarPermiso)
                    .setPositiveButton(R.string.ok, null)
                    .show();
        } else  {
            Intent intent = new Intent(NuevoPermiso.this, EstadosPermisosActivity.class);
            intent.putExtra("permiso", p);
            startActivity(intent);

        }
    }
}