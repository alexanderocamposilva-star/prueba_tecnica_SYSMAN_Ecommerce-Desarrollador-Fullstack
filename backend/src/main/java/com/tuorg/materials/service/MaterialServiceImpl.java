package com.tuorg.materials.service;

import com.tuorg.materials.dto.MaterialCreateDto;
import com.tuorg.materials.dto.MaterialDto;
import com.tuorg.materials.entity.Ciudad;
import com.tuorg.materials.entity.Material;
import com.tuorg.materials.exception.BadRequestException;
import com.tuorg.materials.exception.NotFoundException;
import com.tuorg.materials.repository.CiudadRepository;
import com.tuorg.materials.repository.MaterialRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MaterialServiceImpl implements MaterialService {

    private static final Logger log = LoggerFactory.getLogger(MaterialServiceImpl.class);
    private final MaterialRepository materialRepository;
    private final CiudadRepository ciudadRepository;

    public MaterialServiceImpl(MaterialRepository materialRepository, CiudadRepository ciudadRepository) {
        this.materialRepository = materialRepository;
        this.ciudadRepository = ciudadRepository;
    }

    @Override
    public List<MaterialDto> getAll() {
        log.info("Fetching all materials");
        return materialRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public List<MaterialDto> getByTipo(String tipo) {
        log.info("Fetching by tipo={}", tipo);
        return materialRepository.findByTipo(tipo).stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public List<MaterialDto> getByFechaCompra(LocalDate fecha) {
        log.info("Fetching by fechaCompra={}", fecha);
        return materialRepository.findByFechaCompra(fecha).stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public List<MaterialDto> getByCiudad(Long ciudadId) {
        log.info("Fetching by ciudadId={}", ciudadId);
        return materialRepository.findByCiudad_Id(ciudadId).stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public MaterialDto create(MaterialCreateDto dto) {
        log.info("Creating material nombre={}", dto.getNombre());
        validateDates(dto.getFechaCompra(), dto.getFechaVenta());
        Ciudad ciudad = ciudadRepository.findById(dto.getCiudadId())
                .orElseThrow(() -> new NotFoundException("Ciudad no encontrada con id: " + dto.getCiudadId()));
        Material m = new Material();
        m.setNombre(dto.getNombre()); m.setDescripcion(dto.getDescripcion());
        m.setTipo(dto.getTipo()); m.setPrecio(dto.getPrecio());
        m.setFechaCompra(dto.getFechaCompra()); m.setFechaVenta(dto.getFechaVenta());
        m.setEstado(dto.getEstado()); m.setCiudad(ciudad);
        var saved = materialRepository.save(m);
        log.info("Material created id={}", saved.getId());
        return toDto(saved);
    }

    @Override
    public MaterialDto update(Long id, MaterialCreateDto dto) {
        log.info("Updating material id={}", id);
        var existing = materialRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Material no encontrado con id: " + id));
        validateDates(dto.getFechaCompra(), dto.getFechaVenta());
        Ciudad ciudad = ciudadRepository.findById(dto.getCiudadId())
                .orElseThrow(() -> new NotFoundException("Ciudad no encontrada con id: " + dto.getCiudadId()));
        existing.setNombre(dto.getNombre()); existing.setDescripcion(dto.getDescripcion());
        existing.setTipo(dto.getTipo()); existing.setPrecio(dto.getPrecio());
        existing.setFechaCompra(dto.getFechaCompra()); existing.setFechaVenta(dto.getFechaVenta());
        existing.setEstado(dto.getEstado()); existing.setCiudad(ciudad);
        var saved = materialRepository.save(existing);
        log.info("Material updated id={}", saved.getId());
        return toDto(saved);
    }

    private void validateDates(LocalDate compra, LocalDate venta) {
        if (compra != null && venta != null && compra.isAfter(venta)) {
            log.warn("Invalid dates compra={} venta={}", compra, venta);
            throw new BadRequestException("La fecha de compra no puede ser posterior a la fecha de venta.");
        }
    }

    private MaterialDto toDto(Material m) {
        MaterialDto dto = new MaterialDto();
        dto.setId(m.getId()); dto.setNombre(m.getNombre()); dto.setDescripcion(m.getDescripcion());
        dto.setTipo(m.getTipo()); dto.setPrecio(m.getPrecio()); dto.setFechaCompra(m.getFechaCompra());
        dto.setFechaVenta(m.getFechaVenta()); dto.setEstado(m.getEstado());
        if (m.getCiudad() != null) { dto.setCiudadId(m.getCiudad().getId()); dto.setCiudadNombre(m.getCiudad().getNombre()); }
        return dto;
    }
}
