package cl.duoc.javieracortes.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentRequest {
    @NotNull(message = "El ID no puede ser nulo")
    private Long id;

    @NotBlank(message = "El nombre del paciente es obligatorio")
    private String patientName;

    @NotBlank(message = "Debe especificar una especialidad médica")
    private String specialty;

    @NotBlank(message = "El estado de la solicitud es obligatorio")
    private String status; 

    @NotNull(message = "La fecha de registro es obligatoria")
    private LocalDate registrationDate;

    @Min(value = 1, message = "La prioridad mínima es 1")
    @Max(value = 3, message = "La prioridad máxima es 3")
    private Integer priority;

}
