FROM openjdk:21

COPY . .

RUN ./mvnw clean install -DskipTests

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "target/appointment-0.0.1.jar"]