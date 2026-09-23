/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miapp.modelo;

import java.util.ArrayList;
import java.util.List;

public class Curso {

    private String codigo;
    private String nombre;
    private int creditos;

    private List<Estudiante> estudiantes = new ArrayList<>();

    public Curso(String codigo, String nombre, int creditos) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.creditos = creditos;
    }

    public void agregarEstudiante(Estudiante e) {
        if (e != null && !estudiantes.contains(e)) {
            estudiantes.add(e);
        }
    }

    public boolean removerEstudiante(Estudiante e) {
        return estudiantes.remove(e);
    }

    public List<Estudiante> getEstudiantes() { return estudiantes; }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getCreditos() { return creditos; }
    public void setCreditos(int creditos) { this.creditos = creditos; }

    @Override
    public String toString() {
        return "Curso[" + codigo + " - " + nombre + ", creditos: " + creditos + "]";
    }
}