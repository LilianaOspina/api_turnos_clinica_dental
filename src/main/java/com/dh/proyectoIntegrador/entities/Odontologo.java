package com.dh.proyectoIntegrador.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

//Entidad tabla y nombre de tabla
@Entity
@Table(name="odontologos")
public class Odontologo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String matricula;
    @Column
    private String nombre;
    @Column
    private String apellido;

    //El odontologo tiene varios turnos
    //Tiene que estar mapeado por la relacion que tiene con el turno; es odontologo
    @JsonIgnore
    @OneToMany(mappedBy = "odontologo",fetch = FetchType.LAZY)
    private Set<Turno> turnos= new HashSet<>();

    public Odontologo() {
    }

    public Odontologo(Long id, String matricula, String nombre, String apellido) {
        this.id = id;
        this.matricula = matricula;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Odontologo(String matricula, String nombre, String apellido) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    @Override
    public String toString(){
        return "\nID= "+id
                +"\nMatricula= "+matricula
                +"\nNombre= "+nombre
                +"\nApellido= "+apellido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Set<Turno> getTurnos() {
        return turnos;
    }

    public void setTurnos(Set<Turno> turnos) {
        this.turnos = turnos;
    }
}
