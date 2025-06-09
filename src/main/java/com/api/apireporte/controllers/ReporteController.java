package com.api.apireporte.controllers;

import com.api.apireporte.dto.ReporteDTO;
import com.api.apireporte.services.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/reportes")
public class ReporteController {
    @Autowired
    private ReporteService service;

    @PostMapping
    public ResponseEntity<ReporteDTO> create(@RequestBody ReporteDTO reporteDTO) {
        return ResponseEntity.ok(service.createReporte(reporteDTO));
    }

    @GetMapping
    public ResponseEntity<List<ReporteDTO>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReporteDTO> obtenerPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(service.obtenerPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReporteDTO> actualizar(@PathVariable Integer id, @RequestBody ReporteDTO reporteDTO) {
        return ResponseEntity.ok(service.actualizar(id, reporteDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
    
}
