package com.rockIT.appointment.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import java.time.LocalTime;

public record GetAppointmentByDateResponse(String name, String phone,
                                           @JsonFormat(pattern = "HH:mm") LocalTime appointmentTime,
                                           @JsonFormat(pattern = "dd-MM-yyyy") LocalDate appointmentDate,
                                           String service, String price,
                                           String observations) {
}
