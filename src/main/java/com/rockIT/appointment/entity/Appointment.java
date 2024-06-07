package com.rockIT.appointment.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rockIT.appointment.controller.dto.CreateAppointmentDto;
import com.rockIT.appointment.model.CreateAppointmentResponse;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.time.LocalTime;

@Table(name = "appointments")
@Entity
public class Appointment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "phone")
  private String phone;

  @Column(name = "appointment_time")
  @JsonFormat(pattern = "HH:mm")
  private LocalTime appointmentTime;

  @Column(name = "appointment_date")
  @JsonFormat(pattern = "dd-MM-yyyy")
  private LocalDate appointmentDate;

  @Column(name = "service")
  private String service;

  @Column(name = "price")
  private String price;

  @Column(name = "observations")
  private String observations;

  public Appointment() {
  }

  public Appointment(Long id, String phone, String name, LocalTime appointmentTime,
      LocalDate appointmentDate, String service, String price, String observations) {
    this.id = id;
    this.phone = phone;
    this.name = name;
    this.appointmentTime = appointmentTime;
    this.appointmentDate = appointmentDate;
    this.service = service;
    this.price = price;
    this.observations = observations;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public LocalTime getAppointmentTime() {
    return appointmentTime;
  }

  public void setAppointmentTime(LocalTime appointmentTime) {
    this.appointmentTime = appointmentTime;
  }

  public LocalDate getAppointmentDate() {
    return appointmentDate;
  }

  public void setAppointmentDate(LocalDate appointmentDate) {
    this.appointmentDate = appointmentDate;
  }

  public String getService() {
    return service;
  }

  public void setService(String service) {
    this.service = service;
  }

  public String getPrice() {
    return price;
  }

  public void setPrice(String price) {
    this.price = price;
  }

  public String getObservations() {
    return observations;
  }

  public void setObservations(String observations) {
    if (observations.isEmpty()) {
      this.observations = "Sem observações.";
    } else {
      this.observations = observations;
    }
  }

  public void createAppointment(CreateAppointmentDto dto) {
    this.setName(dto.name());
    this.setPhone(dto.phone());
    this.setAppointmentTime(dto.appointmentTime());
    this.setAppointmentDate(dto.appointmentDate());
    this.setService(dto.service());
    this.setPrice(dto.price());
    this.setObservations(dto.observations());
  }

  public CreateAppointmentResponse toCreateAppointmentResponse() {
    return new CreateAppointmentResponse(this.phone, this.name, this.appointmentTime,
        this.appointmentDate, this.service, this.price, this.observations);
  }
}
