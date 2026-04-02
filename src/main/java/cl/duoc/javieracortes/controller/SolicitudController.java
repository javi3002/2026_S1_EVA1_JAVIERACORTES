package cl.duoc.javieracortes.controller;

import cl.duoc.javieracortes.model.SolicitudAtencion;
import cl.duoc.javieracortes.service.SolicitudService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/solicitudes") // URL semántica en español
public class SolicitudController {

    private final SolicitudService service;

    public SolicitudController(SolicitudService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<SolicitudAtencion>> obtenerTodas() {
        return ResponseEntity.ok(service.obtenerTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SolicitudAtencion> obtenerPorId(@PathVariable Long id) {
        return service.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<SolicitudAtencion> crear(@Valid @RequestBody SolicitudAtencion solicitud) {
        return new ResponseEntity<>(service.crear(solicitud), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SolicitudAtencion> actualizar(@PathVariable Long id, @Valid @RequestBody SolicitudAtencion solicitud) {
        return service.actualizar(id, solicitud)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        return service.eliminar(id) 
                ? ResponseEntity.noContent().build() 
                : ResponseEntity.notFound().build();
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<SolicitudAtencion>> buscarPorEspecialidad(@RequestParam String especialidad) {
        return ResponseEntity.ok(service.buscarPorEspecialidad(especialidad));
    }
}