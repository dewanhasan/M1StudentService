FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/StudentServiceM1-0.0.1-SNAPSHOT.jar /app

EXPOSE 8081

CMD ["java", "-jar", "StudentServiceM1-0.0.1-SNAPSHOT.jar", "--spring.profiles.active=docker"]