package com.rockIT.appointment.controller;

import com.rockIT.appointment.controller.dto.CreateAppointmentDto;
import com.rockIT.appointment.entity.Appointment;
import com.rockIT.appointment.model.CreateAppointmentResponse;
import com.rockIT.appointment.model.GetAppointmentByDateResponse;
import com.rockIT.appointment.service.AppointmentService;
import jakarta.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

  private final AppointmentService appointmentService;

  public AppointmentController(AppointmentService appointmentService) {
    this.appointmentService = appointmentService;
  }

  @PostMapping
  public ResponseEntity<CreateAppointmentResponse> createAppointment(
      @RequestBody @Valid CreateAppointmentDto dto) {
    return ResponseEntity.ok(appointmentService.createAppointment(dto));
  }

  @GetMapping("/{date}")
  public ResponseEntity<List<GetAppointmentByDateResponse>> getAppointmentsByDate(
      @PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate date) {
    return ResponseEntity.ok(appointmentService.getAppointmentsByDate(date));
  }
}
