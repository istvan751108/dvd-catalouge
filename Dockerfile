FROM openjdk:17-jdk-alpine3.14

COPY "./target/dvd-catalouge-0.0.1.jar" "/application/dvd-catalouge.jar"

CMD ["java", "-jar", "/application/dvd-catalouge.jar"]