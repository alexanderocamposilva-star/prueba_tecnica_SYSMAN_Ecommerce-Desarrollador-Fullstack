package com.tuorg.materials.config;

import com.tuorg.materials.entity.Ciudad;
import com.tuorg.materials.entity.Departamento;
import com.tuorg.materials.entity.Material;
import com.tuorg.materials.repository.CiudadRepository;
import com.tuorg.materials.repository.DepartamentoRepository;
import com.tuorg.materials.repository.MaterialRepository;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

/**
 * Inserta datos iniciales de prueba en la BD.
 */
@Component
public class DataInitializer {

    private static final Logger log = LoggerFactory.getLogger(DataInitializer.class);

    private final CiudadRepository ciudadRepository;
    private final DepartamentoRepository departamentoRepository;
    private final MaterialRepository materialRepository;

    public DataInitializer(
            CiudadRepository ciudadRepository,
            DepartamentoRepository departamentoRepository,
            MaterialRepository materialRepository
    ) {
        this.ciudadRepository = ciudadRepository;
        this.departamentoRepository = departamentoRepository;
        this.materialRepository = materialRepository;
    }

    @PostConstruct
    public void init() {
        if (departamentoRepository.count() > 0) {
            log.info("Los datos iniciales ya existen. No se insertan nuevamente.");
            return;
        }

        // 1. Crear 5 departamentos
        String[][] departamentos = {
                {"05", "Antioquia"},
                {"08", "Atlántico"},
                {"11", "Bogotá D.C."},
                {"13", "Bolívar"},
                {"76", "Valle del Cauca"}
        };

        List<Departamento> depList = new ArrayList<>();
        for (String[] dep : departamentos) {
            Departamento d = new Departamento();
            d.setCodigo(dep[0]);
            d.setNombre(dep[1]);
            departamentoRepository.save(d);
            depList.add(d);
        }

        // 2. Crear 20 ciudades asociadas a los departamentos
        String[][] ciudades = {
                {"05001", "Medellín", "05"},
                {"05002", "Envigado", "05"},
                {"05003", "Bello", "05"},
                {"08001", "Barranquilla", "08"},
                {"08002", "Soledad", "08"},
                {"08003", "Malambo", "08"},
                {"11001", "Bogotá", "11"},
                {"13001", "Cartagena", "13"},
                {"13002", "Magangué", "13"},
                {"13003", "Turbaco", "13"},
                {"76001", "Cali", "76"},
                {"76002", "Palmira", "76"},
                {"76003", "Jamundí", "76"},
                {"76004", "Buenaventura", "76"},
                {"76005", "Buga", "76"},
                {"05004", "Rionegro", "05"},
                {"05005", "Itagüí", "05"},
                {"08004", "Puerto Colombia", "08"},
                {"13004", "Arjona", "13"},
                {"76006", "Tuluá", "76"}
        };

        Map<String, Departamento> depMap = new HashMap<>();
        depList.forEach(d -> depMap.put(d.getCodigo(), d));

        List<Ciudad> ciudadList = new ArrayList<>();
        for (String[] c : ciudades) {
            Ciudad ciudad = new Ciudad();
            ciudad.setCodigo(c[0]);
            ciudad.setNombre(c[1]);
            ciudad.setDepartamento(depMap.get(c[2]));
            ciudadRepository.save(ciudad);
            ciudadList.add(ciudad);
        }

        // 3. Crear 15 materiales asociados a ciudades
        String[] tipos = {"Construcción", "Electricidad", "Carpintería", "Pintura", "Plomería"};
        String[] estados = {"Disponible", "Usado", "En reparación", "Vendido"};

        Random random = new Random();

        for (int i = 1; i <= 15; i++) {
            Material m = new Material();
            m.setNombre("Material " + i);
            m.setDescripcion("Descripción del material " + i);
            m.setTipo(tipos[random.nextInt(tipos.length)]);
            m.setPrecio(BigDecimal.valueOf(1000 + random.nextInt(5000)));

            // Generar fechas
            LocalDate fechaCompra = LocalDate.now().minusDays(random.nextInt(100) + 10);
            LocalDate fechaVenta = fechaCompra.plusDays(random.nextInt(30) + 1);
            m.setFechaCompra(fechaCompra);
            m.setFechaVenta(fechaVenta);

            m.setEstado(estados[random.nextInt(estados.length)]);
            m.setCiudad(ciudadList.get(random.nextInt(ciudadList.size())));

            materialRepository.save(m);
        }

        log.info("Datos iniciales insertados: 5 departamentos, 20 ciudades, 15 materiales.");
    }
}

