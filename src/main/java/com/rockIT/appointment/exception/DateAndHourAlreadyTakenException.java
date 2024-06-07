package com.rockIT.appointment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class DateAndHourAlreadyTakenException extends AppointmentException {

  @Override
  public ProblemDetail toProblemDetail() {
    var pb = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);

    pb.setTitle("Date and Hour already taken.");
    pb.setDetail("The date and hour are already taken.");

    return pb;
  }
}
