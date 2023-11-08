package com.example.aplicacioncolegio;

import java.io.Serializable;

public class Permiso implements Serializable {
    private String estado;
    private String nombre;

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Permiso(String estado, String nombre) {
        this.estado = estado;
        this.nombre = nombre;
    }

    public Permiso() {
    }
}
