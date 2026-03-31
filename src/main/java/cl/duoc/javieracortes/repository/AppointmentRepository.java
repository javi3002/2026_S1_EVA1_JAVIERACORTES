package cl.duoc.javieracortes.repository;

import org.springframework.stereotype.Repository;
import cl.duoc.javieracortes.model.AppointmentRequest;
import java.util.*;

@Repository
public class AppointmentRepository {
    private final Map<Long, AppointmentRequest> storage = new HashMap<>();

    public List<AppointmentRequest> findAll() {
        return new ArrayList<>(storage.values());
    }

    public Optional<AppointmentRequest> findById(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

    public AppointmentRequest save(AppointmentRequest request) {
        storage.put(request.getId(), request);
        return request;
    }

    public void deleteById(Long id) {
        storage.remove(id);
    }

    public boolean existsById(Long id) {
        return storage.containsKey(id);
    }

}
