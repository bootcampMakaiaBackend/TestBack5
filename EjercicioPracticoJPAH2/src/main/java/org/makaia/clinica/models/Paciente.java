package org.makaia.clinica.models;

import javax.persistence.*;

@Entity
@Table(name = "paciente")
public class Paciente {
    @Id
    @Column(name = "dni")
    private Integer dni;
    @Column(name= "nombre")
    private String nombre;
    @Column(name= "apellido")
    private String apellido;
    @Column(name= "domicilio")
    private String domicilio;

    @OneToOne(mappedBy = "paciente", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Cita cita;

    public Paciente(){
    }

    public Paciente(Integer dni, String nombre, String apellido, String domicilio) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.domicilio = domicilio;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
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

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }
}
