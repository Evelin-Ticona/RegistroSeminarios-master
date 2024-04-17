/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.emergentes.registroseminarios;

/**
 *
 * @author Apaza
 */
public class Persona {
     private int id;
    private String nombres;
    private String apellidos;
    private String turno;
    private String seminarios;

    

    public Persona(){
    this.id = 0;
    this.nombres = "";
    this.apellidos = "";
    this.turno = "";
    this.seminarios = "";
    
    }

    public int getId() {
        return id;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getTurno() {
        return turno;
    }

    public String getSeminarios() {
        return seminarios;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public void setSeminarios(String seminarios) {
        this.seminarios = seminarios;
    }
    
    
}
