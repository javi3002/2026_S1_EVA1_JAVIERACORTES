package cl.duoc.javieracortes.repository;

import org.springframework.stereotype.Repository;
import cl.duoc.javieracortes.model.SolicitudAtencion;
import java.util.*;

@Repository
public class SolicitudRepository {
    private final Map<Long, SolicitudAtencion> almacenamiento = new HashMap<>();

    public List<SolicitudAtencion> buscarTodos() {
        return new ArrayList<>(almacenamiento.values());
    }

    public Optional<SolicitudAtencion> buscarPorId(Long id) {
        return Optional.ofNullable(almacenamiento.get(id));
    }

    public SolicitudAtencion guardar(SolicitudAtencion solicitud) {
        almacenamiento.put(solicitud.getId(), solicitud);
        return solicitud;
    }

    public void eliminarPorId(Long id) {
        almacenamiento.remove(id);
    }

    public boolean existePorId(Long id) {
        return almacenamiento.containsKey(id);
    }
}