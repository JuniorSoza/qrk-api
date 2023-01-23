package org.api.models;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import javax.persistence.*;

@Entity
@Table(name = "persona")
public class Persona {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombres")
    private String nombres;

    @Column(name = "apellidos")
    private String apellidos;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Persona() {
    }

    public Persona(Integer id, String nombres, String apellidos) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }
}
