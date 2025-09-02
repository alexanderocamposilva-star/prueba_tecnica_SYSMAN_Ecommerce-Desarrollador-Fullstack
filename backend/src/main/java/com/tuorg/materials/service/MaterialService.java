package com.tuorg.materials.service;

import com.tuorg.materials.dto.MaterialCreateDto;
import com.tuorg.materials.dto.MaterialDto;

import java.time.LocalDate;
import java.util.List;

public interface MaterialService {
    List<MaterialDto> getAll();
    List<MaterialDto> getByTipo(String tipo);
    List<MaterialDto> getByFechaCompra(LocalDate fecha);
    List<MaterialDto> getByCiudad(Long ciudadId);
    MaterialDto create(MaterialCreateDto dto);
    MaterialDto update(Long id, MaterialCreateDto dto);
}
