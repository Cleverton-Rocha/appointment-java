package com.rockIT.appointment.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalTime;

public record CreateAppointmentDto(@NotBlank String name,
                                   @NotBlank String phone,
                                   @NotNull @JsonFormat(pattern = "HH:mm") LocalTime appointmentTime,
                                   @NotNull @FutureOrPresent @JsonFormat(pattern = "dd-MM-yyyy") LocalDate appointmentDate,
                                   @NotBlank String service,
                                   @NotBlank String price,
                                   @Size(max = 150) String observations) {

}
