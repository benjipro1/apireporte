package com.api.apireporte.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReporteDTO {

    private Integer id;
    private String titulo;
    private String descripcion;
    private String fechaCreacion;
    private String estado;

}
