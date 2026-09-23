/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miapp.modelo;

public class Profesor extends Persona {

    private final double salarioBase;

    public Profesor(int id, String nombre, String apellido, double salarioBase) {
        super(id, nombre, apellido);
        this.salarioBase = salarioBase;
    }

    @Override
    public double calcularPago() {
        return salarioBase;
    }

    public void impartirClase() {
        System.out.println(getNombre() + " " + getApellido() + " está impartiendo una clase.");
    }

    public double getSalarioBase() {
        return salarioBase;
    }
}