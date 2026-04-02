package cl.duoc.javieracortes.service;

import cl.duoc.javieracortes.model.SolicitudAtencion;
import cl.duoc.javieracortes.repository.SolicitudRepository;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class SolicitudService {
    private final SolicitudRepository repository;

    public SolicitudService(SolicitudRepository repository) {
        this.repository = repository;
    }

    public List<SolicitudAtencion> obtenerTodas() { 
        return repository.buscarTodos(); 
    }

    public Optional<SolicitudAtencion> obtenerPorId(Long id) { 
        return repository.buscarPorId(id); 
    }

    public SolicitudAtencion crear(SolicitudAtencion solicitud) {
        return repository.guardar(solicitud);
    }

    public Optional<SolicitudAtencion> actualizar(Long id, SolicitudAtencion solicitud) {
        if (repository.existePorId(id)) {
            solicitud.setId(id);
            return Optional.of(repository.guardar(solicitud));
        }
        return Optional.empty();
    }

    public boolean eliminar(Long id) {
        if (repository.existePorId(id)) {
            repository.eliminarPorId(id);
            return true;
        }
        return false;
    }

    // Transformación: buscar por especialidad
    public List<SolicitudAtencion> buscarPorEspecialidad(String especialidad) {
        return repository.buscarTodos().stream()
                .filter(s -> s.getEspecialidad().equalsIgnoreCase(especialidad))
                .collect(Collectors.toList());
    }
}