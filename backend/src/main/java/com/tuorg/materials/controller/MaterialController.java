package com.tuorg.materials.controller;

import com.tuorg.materials.dto.ApiResponse;
import com.tuorg.materials.dto.MaterialCreateDto;
import com.tuorg.materials.dto.MaterialDto;
import com.tuorg.materials.service.MaterialService;
import jakarta.validation.Valid;
import org.slf4j.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

/**
 * REST controller for materials.
 */
@RestController
@RequestMapping("/api/materials")
public class MaterialController {

    private static final Logger log = LoggerFactory.getLogger(MaterialController.class);
    private final MaterialService service;

    public MaterialController(MaterialService service) { this.service = service; }

    @GetMapping
    public ResponseEntity<ApiResponse<List<MaterialDto>>> getAll(
            @RequestParam(required = false) String tipo,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaCompra) {
        if (tipo != null) {
            var list = service.getByTipo(tipo);
            if (list.isEmpty()) return ResponseEntity.status(404).body(new ApiResponse<>(404, "No se encontraron materiales para tipo: " + tipo, list));
            return ResponseEntity.ok(new ApiResponse<>(200, "Materiales por tipo", list));
        }
        if (fechaCompra != null) {
            var list = service.getByFechaCompra(fechaCompra);
            if (list.isEmpty()) return ResponseEntity.status(404).body(new ApiResponse<>(404, "No se encontraron materiales para fechaCompra: " + fechaCompra, list));
            return ResponseEntity.ok(new ApiResponse<>(200, "Materiales por fecha de compra", list));
        }
        var all = service.getAll();
        if (all.isEmpty()) return ResponseEntity.status(404).body(new ApiResponse<>(404, "No se encontraron materiales", all));
        return ResponseEntity.ok(new ApiResponse<>(200, "Todos los materiales", all));
    }

    @GetMapping("/city/{cityId}")
    public ResponseEntity<ApiResponse<List<MaterialDto>>> getByCity(@PathVariable Long cityId) {
        var list = service.getByCiudad(cityId);
        if (list.isEmpty()) return ResponseEntity.status(404).body(new ApiResponse<>(404, "No se encontraron materiales para la ciudad", list));
        return ResponseEntity.ok(new ApiResponse<>(200, "Materiales por ciudad", list));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<MaterialDto>> create(@Valid @RequestBody MaterialCreateDto dto) {
        log.info("Create request: {}", dto.getNombre());
        var created = service.create(dto);
        return ResponseEntity.ok(new ApiResponse<>(200, "Material creado exitosamente", created));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<MaterialDto>> update(@PathVariable Long id, @Valid @RequestBody MaterialCreateDto dto) {
        log.info("Update request id={}", id);
        var updated = service.update(id, dto);
        return ResponseEntity.ok(new ApiResponse<>(200, "Material actualizado", updated));
    }
}
