FROM openjdk:17

WORKDIR /usr/src/app

COPY target/appointment-0.0.1-SNAPSHOT.jar .

CMD ["java", "-jar", "appointment-0.0.1-SNAPSHOT.jar"]