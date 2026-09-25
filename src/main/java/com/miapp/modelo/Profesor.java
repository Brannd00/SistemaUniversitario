/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miapp.modelo;

import java.util.ArrayList;
import java.util.List;

public class Profesor extends Persona {

    private double salarioBase;

    private List<Curso> cursos = new ArrayList<>();

    public Profesor(int id, String nombre, String apellido, double salarioBase) {
        super(id, nombre, apellido);
        this.salarioBase = salarioBase;
    }

    @Override
    public double calcularPago() {
        return salarioBase;
    }

    public void impartirClase() {
        System.out.println(getNombre() + " " + getApellido() + " esta impartiendo una clase.");
    }

    public boolean asignarCurso(Curso curso) {
        if (curso == null || cursos.contains(curso)) {
            return false;
        }
        cursos.add(curso);
        curso.setProfesor(this);
        return true;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    @Override
    public String toString() {
        return getNombre() + " " + getApellido();
    }
}