package org.makaia.clinica.models;

import javax.persistence.*;

@Entity
@Table(name = "odontologo")
public class Odontologo {
    @Id
    @Column(name = "matricula")
    private Integer matricula;
    @Column(name= "nombre")
    private String nombre;
    @Column(name= "apellido")
    private String apellido;

    @OneToOne(mappedBy = "odontologo", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Cita cita;

    public Odontologo(){
    }

    public Odontologo(Integer matricula, String nombre, String apellido) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
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
}
