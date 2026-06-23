FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY target/customer-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
LABEL authors="OMASHOLA"
ENTRYPOINT ["java", "-jar", "app.jar"]