package com.api.apireporte.services;

import com.api.apireporte.dto.ReporteDTO;
import com.api.apireporte.models.Reporte;
import com.api.apireporte.repository.ReporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReporteService {

    @Autowired
    private ReporteRepository reporteRepository;

    private ReporteDTO toDTO(Reporte reporte) {
        return new ReporteDTO(
                reporte.getId(),
                reporte.getTitulo(),
                reporte.getDescripcion(),
                reporte.getFechaCreacion(),
                reporte.getEstado());
    }

    private Reporte toEntity(ReporteDTO reporteDTO) {
        Reporte reporte = new Reporte();
        reporte.setId(reporteDTO.getId());
        reporte.setTitulo(reporteDTO.getTitulo());
        reporte.setDescripcion(reporteDTO.getDescripcion());
        reporte.setFechaCreacion(reporteDTO.getFechaCreacion());
        reporte.setEstado(reporteDTO.getEstado());
        return reporte;
    }

    public ReporteDTO createReporte(ReporteDTO reporteDTO) {
        Reporte reporte = toEntity(reporteDTO);
        return toDTO(reporteRepository.save(reporte));
    }

    public List<ReporteDTO> listar() {
        return reporteRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public ReporteDTO obtenerPorId(Integer id) {
        Reporte reporte = reporteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reporte no encontrado con ID: " + id));
        return toDTO(reporte);
    }

    public ReporteDTO actualizar(Integer id, ReporteDTO reporteDTO) {
        Reporte reporteExistente = reporteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reporte no encontrado con ID: " + id));
        
        reporteExistente.setTitulo(reporteDTO.getTitulo());
        reporteExistente.setDescripcion(reporteDTO.getDescripcion());
        reporteExistente.setFechaCreacion(reporteDTO.getFechaCreacion());
        reporteExistente.setEstado(reporteDTO.getEstado());
        
        return toDTO(reporteRepository.save(reporteExistente));
    }

    public void eliminar(Integer id) {
        reporteRepository.deleteById(id);
    }
    
 }
