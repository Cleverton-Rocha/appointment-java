FROM openjdk:21

COPY . .

RUN ./mvnw clean install -DskipTests

ENV SPRING_DATASOURCE_URL=jdbc:postgresql://aws-0-sa-east-1.pooler.supabase.com:5432/postgres
ENV SPRING_DATASOURCE_USERNAME=postgres.vtzcunndkkiwbgneufkl
ENV SPRING_DATASOURCE_PASSWORD=Allonsy908@

ENTRYPOINT ["java", "-jar", "target/appointment-0.0.1.jar"]