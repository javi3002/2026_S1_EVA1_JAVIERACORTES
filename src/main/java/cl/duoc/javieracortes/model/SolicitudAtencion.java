package cl.duoc.javieracortes.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SolicitudAtencion {
    @NotNull(message = "El ID no puede ser nulo")
    private Long id;

    @NotBlank(message = "El nombre del paciente es obligatorio")
    private String nombrePaciente;

    @NotBlank(message = "Debe especificar una especialidad médica")
    private String especialidad;

    @NotBlank(message = "El estado de la solicitud es obligatorio")
    private String estado; 

    @NotNull(message = "La fecha de registro es obligatoria")
    private LocalDate fechaRegistro;

    @Min(value = 1, message = "La prioridad mínima es 1")
    @Max(value = 3, message = "La prioridad máxima es 3")
    private Integer prioridad;
}