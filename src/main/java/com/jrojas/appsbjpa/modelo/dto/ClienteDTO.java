package com.jrojas.appsbjpa.modelo.dto;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "clientes")
public class ClienteDTO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cli")
    private Integer id;

    @NotEmpty
    @Column(name = "nom_cli")
    private String nombre;

    @NotEmpty
    @Column(name = "ape_cli")
    private String apellido;

    @NotEmpty
    @Email
    @Column(name = "cor_cli")
    private String correoE;

    @NotNull
    @Column(name = "cre_cli")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date creacion;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dir_cli")
    @Valid
    private DireccionDTO direccion;



    @OneToMany(mappedBy = "cliente")
    private List<AreaDTO> areas;

    public List<AreaDTO> getAreas() {
        return areas;
    }

    public void setAreas(List<AreaDTO> areas) {
        this.areas = areas;
    }

    public DireccionDTO getDireccion() {
        return direccion;
    }

    public void setDireccion(DireccionDTO direccion) {
        this.direccion = direccion;
    }

    /*@PrePersist
    public void antesDePersistir(){
        creacion = new Date();
    }*/


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getCorreoE() {
        return correoE;
    }

    public void setCorreoE(String correoE) {
        this.correoE = correoE;
    }

    public Date getCreacion() {
        return creacion;
    }

    public void setCreacion(Date creacion) {
        this.creacion = creacion;
    }
}
