package com.tuorg.materials.repository;

import com.tuorg.materials.entity.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface MaterialRepository extends JpaRepository<Material, Long> {
    List<Material> findByTipo(String tipo);
    List<Material> findByFechaCompra(LocalDate fechaCompra);
    List<Material> findByCiudad_Id(Long ciudadId);
}
