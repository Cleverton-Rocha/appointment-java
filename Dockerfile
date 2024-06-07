FROM openjdk:21

COPY . .

RUN ./mvnw clean install -DskipTests

ENTRYPOINT ["java", "-jar", "target/appointment-0.0.1-SNAPSHOT.jar"]