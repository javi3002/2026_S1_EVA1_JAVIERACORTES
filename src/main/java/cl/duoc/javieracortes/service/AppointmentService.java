package cl.duoc.javieracortes.service;

import cl.duoc.javieracortes.model.AppointmentRequest;
import cl.duoc.javieracortes.repository.AppointmentRepository;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class AppointmentService {
    private final AppointmentRepository repository;

    public AppointmentService(AppointmentRepository repository) {
        this.repository = repository;
    }

    public List<AppointmentRequest> getAll() { 
        return repository.findAll(); 
    }

    public Optional<AppointmentRequest> getById(Long id) { 
        return repository.findById(id); 
    }

    public AppointmentRequest create(AppointmentRequest request) {
        return repository.save(request);
    }

    public Optional<AppointmentRequest> update(Long id, AppointmentRequest request) {
        if (repository.existsById(id)) {
            request.setId(id);
            return Optional.of(repository.save(request));
        }
        return Optional.empty();
    }

    public boolean delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<AppointmentRequest> findBySpecialty(String specialty) {
        return repository.findAll().stream()
                .filter(a -> a.getSpecialty().equalsIgnoreCase(specialty))
                .collect(Collectors.toList());
    }




}
