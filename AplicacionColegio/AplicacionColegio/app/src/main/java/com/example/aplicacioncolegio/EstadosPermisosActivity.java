package com.example.aplicacioncolegio;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.ArrayList;
import java.util.List;

public class EstadosPermisosActivity extends AppCompatActivity {
    ListView listView;
    List<Permiso> permisos;
    Permiso p;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estados_permisos);

        getSupportActionBar().setTitle("Tus permisos");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        listView= findViewById(R.id.listaPermisos);
        AdaptadorPermisos adaptadorPermisos = new AdaptadorPermisos(this, getData());
        listView.setAdapter(adaptadorPermisos);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Permiso p= permisos.get(position);
                new MaterialAlertDialogBuilder(EstadosPermisosActivity.this)
                        .setMessage("Permiso: "+p.getNombre()+"\nEstado:"+p.getEstado())
                        .setPositiveButton("OK",null)
                        .show();
            }
        });

    }

    private List<Permiso> getData() {
       Permiso p= getIntent().getParcelableExtra("permiso");
        permisos= new ArrayList<Permiso>();

        if(p!=null){
            permisos.add(p);
        }

        permisos.add(new Permiso("pendiente","Baja por paternidad"));
        permisos.add(new Permiso("aprobado","Permiso por matrimonio de un familiar"));
        permisos.add(new Permiso("rechazado","Permiso por fallecimiento de un familiar"));
        permisos.add(new Permiso("rechazado","Reducción de jornada por guarda legal"));
        permisos.add(new Permiso("pendiente","Baja por paternidad"));
        permisos.add(new Permiso("aprobado","Permiso por matrimonio de un familiar"));
        permisos.add(new Permiso("rechazado","Permiso por fallecimiento de un familiar"));
        permisos.add(new Permiso("rechazado","Reducción de jornada por guarda legal"));
        permisos.add(new Permiso("pendiente","Baja por paternidad"));
        permisos.add(new Permiso("aprobado","Permiso por matrimonio de un familiar"));
        permisos.add(new Permiso("rechazado","Permiso por fallecimiento de un familiar"));
        permisos.add(new Permiso("rechazado","Reducción de jornada por guarda legal"));

        return permisos;
    }
}