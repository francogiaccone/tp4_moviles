package com.example.tp4_moviles.models;

import java.io.Serializable;

public class Farmacia implements Serializable {

    private String nombre,direccion, horario;
    private int foto;

    public Farmacia(String nombre, int foto, String horario, String direccion) {
        this.nombre = nombre;
        this.foto = foto;
        this.horario = horario;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
