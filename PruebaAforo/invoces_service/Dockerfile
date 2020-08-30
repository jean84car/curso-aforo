FROM openjdk:8

VOLUME /tmp
EXPOSE 8180

ADD ./target/invoces_service-0.0.1-SNAPSHOT.jar invoces_service.jar
ENTRYPOINT ["java", "-jar", "invoces_service.jar"]