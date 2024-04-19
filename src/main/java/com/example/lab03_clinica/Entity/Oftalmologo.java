package com.example.lab03_clinica.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="oftalmologo")
public class Oftalmologo {

    @Id
    @Column(name = "id")
    private int id;

    private String nombre;
    private String correo;

    @ManyToOne
    @JoinColumn(name = "clinica_id")
    private  Clinica clinica;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Clinica getClinica() {
        return clinica;
    }

    public void setClinica(Clinica clinica) {
        this.clinica = clinica;
    }
}
