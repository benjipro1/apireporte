package com.api.apireporte.dto;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReporteDTO extends RepresentationModel<ReporteDTO>{

    private Integer id;
    private String titulo;
    private String descripcion;
    private String fechaCreacion;
    private String estado;

}
