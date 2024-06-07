package com.rockIT.appointment.service;

import com.rockIT.appointment.controller.dto.CreateAppointmentDto;
import com.rockIT.appointment.entity.Appointment;
import com.rockIT.appointment.exception.DateAndHourAlreadyTakenException;
import com.rockIT.appointment.model.CreateAppointmentResponse;
import com.rockIT.appointment.model.GetAppointmentByDateResponse;
import com.rockIT.appointment.repository.AppointmentRepository;
import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {

  private final AppointmentRepository appointmentRepository;

  public AppointmentService(AppointmentRepository appointmentRepository) {
    this.appointmentRepository = appointmentRepository;
  }

  public CreateAppointmentResponse createAppointment(CreateAppointmentDto dto) {

    if (appointmentRepository.findAppointmentByAppointmentDateAndAppointmentTime(
        dto.appointmentDate(), dto.appointmentTime()).isPresent()) {
      throw new DateAndHourAlreadyTakenException();
    }

    Appointment NewAppointment = new Appointment();

    NewAppointment.createAppointment(dto);
    appointmentRepository.save(NewAppointment);

    return NewAppointment.toCreateAppointmentResponse();
  }

  public List<GetAppointmentByDateResponse> getAppointmentsByDate(LocalDate date) {
    return appointmentRepository.findAppointmentsByAppointmentDate(date);
  }

}