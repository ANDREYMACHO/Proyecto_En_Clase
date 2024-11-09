package com.tienda.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name="Categoria")
public class Categoria implements Serializable { //@Data y implements serializable crea gets y sets a todo el codigo
    
    private static final long serialVersionUID = 1L; //Autoincrementar de 1 en 1  
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column (name="id_categoria")
    private long idCategoria;
    
    private String descripcion;
    @Column (name="ruta_imagen")    
    private String rutaImagen;
    private boolean activo;

    @OneToMany
    @JoinColumn(name = "id_categoria")
    List<Producto> productos;

    
    //Constructores
    public Categoria() {
    }

    public Categoria(String descripcion, String rutaImagen, boolean activo) {
        this.descripcion = descripcion;
        this.rutaImagen = rutaImagen;
        this.activo = activo;
    }
}
