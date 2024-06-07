package com.rockIT.appointment.repository;

import com.rockIT.appointment.entity.Appointment;
import com.rockIT.appointment.model.GetAppointmentByDateResponse;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

  Optional<Appointment> findAppointmentByAppointmentDateAndAppointmentTime(
      LocalDate appointmentDate, LocalTime appointmentTime);

  List<GetAppointmentByDateResponse> findAppointmentsByAppointmentDate(LocalDate date);
}
