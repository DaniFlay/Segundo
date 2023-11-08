package com.example.aplicacioncolegio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class MenuPrincipal extends AppCompatActivity {

    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[] texto= getIntent().getStringArrayExtra("texto");
        int[] botones= getIntent().getIntArrayExtra("botones");
            if(botones[0]==R.id.radioButtonJefe){
                setContentView(R.layout.activity_menu_principal_jefe);
                //el icono para abrir y cerrar
                drawerLayout=findViewById(R.id.drawer_layout_jefe);
                actionBarDrawerToggle=new ActionBarDrawerToggle(this, drawerLayout,R.string.abrir_menu_deslizante,R.string.cerrar_menu_deslizante);
                //Poner el escuchador para la aapertura y cierre
                drawerLayout.addDrawerListener(actionBarDrawerToggle);
                actionBarDrawerToggle.syncState();
                //Que aparezca el icono para abrir y cerrar
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                getSupportActionBar().setTitle(R.string.menu_principal);
                NavigationView nav_view= findViewById(R.id.nav_view);
                nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                        Intent intent=null;

                        if(item.getItemId()==R.id.nav_cerrarSesion){
                            intent= new Intent(MenuPrincipal.this, LauncherActivity.class);
                            startActivity(intent);
                        }
                        else if (item.getItemId()==R.id.nav_micuenta) {
                            intent = new Intent(MenuPrincipal.this, EditarPerfilActivity.class);
                            intent.putExtra("texto", texto);
                            intent.putExtra("botones", botones);
                            startActivity(intent);
                        }
                        return true;
                    }
                });
            } else if (botones[0]== R.id.radioButtonCoordinador) {
                setContentView(R.layout.activity_menu_principal_coordinador);

                //el icono para abrir y cerrar
                drawerLayout=findViewById(R.id.drawer_layout_coordinador);
                actionBarDrawerToggle=new ActionBarDrawerToggle(this, drawerLayout,R.string.abrir_menu_deslizante,R.string.cerrar_menu_deslizante);
                //Poner el escuchador para la aapertura y cierre
                drawerLayout.addDrawerListener(actionBarDrawerToggle);
                actionBarDrawerToggle.syncState();
                //Que aparezca el icono para abrir y cerrar
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                NavigationView nav_view= findViewById(R.id.nav_view);

                nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                        Intent intent=null;

                        if(item.getItemId()==R.id.nav_cerrarSesion){
                            intent= new Intent(MenuPrincipal.this, LauncherActivity.class);
                            startActivity(intent);
                        }
                        else if (item.getItemId()==R.id.nav_micuenta) {
                            intent = new Intent(MenuPrincipal.this, EditarPerfilActivity.class);
                            intent.putExtra("texto", texto);
                            intent.putExtra("botones", botones);
                            startActivity(intent);
                        }else if (item.getItemId()==R.id.nav_permisos) {
                            intent= new Intent(MenuPrincipal.this,PermisosActivity.class);
                            intent.putExtra("texto", texto);
                            intent.putExtra("botones", botones);
                            startActivity(intent);
                        }
                        return true;
                    }
                });
            } else if (botones[0]== R.id.radioButtonDocente) {
                setContentView(R.layout.activity_menu_principal_docente);

                //el icono para abrir y cerrar
                drawerLayout=findViewById(R.id.drawer_layout_docente);
                actionBarDrawerToggle=new ActionBarDrawerToggle(this, drawerLayout,R.string.abrir_menu_deslizante,R.string.cerrar_menu_deslizante);
                //Poner el escuchador para la aapertura y cierre
                drawerLayout.addDrawerListener(actionBarDrawerToggle);
                actionBarDrawerToggle.syncState();
                //Que aparezca el icono para abrir y cerrar
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                NavigationView nav_view= findViewById(R.id.nav_view);
                nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                        Intent intent=null;

                        if(item.getItemId()==R.id.nav_cerrarSesion){
                            intent= new Intent(MenuPrincipal.this, LauncherActivity.class);
                            startActivity(intent);
                        }
                        else if (item.getItemId()==R.id.nav_micuenta) {
                            intent = new Intent(MenuPrincipal.this, EditarPerfilActivity.class);
                            intent.putExtra("texto", texto);
                            intent.putExtra("botones", botones);
                            startActivity(intent);
                        } else if (item.getItemId()==R.id.nav_permisos) {
                            intent= new Intent(MenuPrincipal.this,PermisosActivity.class);
                            intent.putExtra("texto", texto);
                            intent.putExtra("botones", botones);
                            startActivity(intent);
                        }
                        return true;
                    }
                });

            }
        }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(actionBarDrawerToggle.onOptionsItemSelected(item)) {

            return true;
        }


        return super.onOptionsItemSelected(item);
    }
}