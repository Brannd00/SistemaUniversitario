package com.miapp.modelo;

import com.miapp.servicios.Inscribible;
import com.miapp.Utilidades.EstadoMatricula;

import java.util.ArrayList;
import java.util.List;

public class Estudiante extends Persona implements Inscribible {

    private static int totalEstudiantes = 0;

    public static  int MAX_MATERIAS = 5;
    public static  int PROMEDIO_MINIMO = 0;
    public static  int PROMEDIO_MAXIMO = 5;
    public static  String CARRERA_PREDETERMINADA = "Sin especificar";

    private String carrera;
    private double promedio;
    private EstadoMatricula estado;

    private List<Curso> cursos = new ArrayList<>();

    public Estudiante(int id, String nombre, String apellido, String carrera, double promedio) {
        super(id, nombre, apellido);
        this.carrera = carrera;

        if (promedio >= PROMEDIO_MINIMO && promedio <= PROMEDIO_MAXIMO) {
            this.promedio = promedio;
        } else {
            this.promedio = 0.0;
        }

        this.estado = EstadoMatricula.ACTIVO; 

        totalEstudiantes++;
    }

    @Override
    public double calcularPago() {
        return 0.0;
    }

    @Override
    public boolean inscribir(Curso curso) {
        if (curso == null) return false;
        if (cursos.size() >= MAX_MATERIAS) return false;
        if (cursos.contains(curso)) return false;

        cursos.add(curso);
        curso.agregarEstudiante(this);
        return true;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public static int getTotalEstudiantes() { return totalEstudiantes; }
    public static void reiniciarContador() { totalEstudiantes = 0; }
    public static int getProximoId() { return totalEstudiantes + 1; }

    public String getCarrera() { return carrera; }
    public void setCarrera(String carrera) { this.carrera = carrera; }

    public double getPromedio() { return promedio; }
    public void setPromedio(double p) {
        if (p >= PROMEDIO_MINIMO && p <= PROMEDIO_MAXIMO) {
            this.promedio = p;
        }
    }

    public EstadoMatricula getEstado() { return estado; }
    public void setEstado(EstadoMatricula estado) { this.estado = estado; }

    @Override
    public String toString() {
        return "ID: " + getId()
             + " | Nombre: " + getNombre()
             + " | Apellido: " + getApellido()
             + " | Carrera: " + carrera
             + " | Promedio: " + String.format("%.2f", promedio)
             + " | Estado: " + estado;
    }
}