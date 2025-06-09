package com.api.apireporte.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "reportes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
     
    private String titulo;
    private String descripcion;
    private String fechaCreacion;
    private String estado;
    
}
