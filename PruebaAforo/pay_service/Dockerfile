FROM openjdk:8

VOLUME /tmp
EXPOSE 8280

ADD ./target/pay_service-0.0.1-SNAPSHOT.jar pay_service.jar
ENTRYPOINT ["java", "-jar", "pay_service.jar"]