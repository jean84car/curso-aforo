FROM openjdk:8

VOLUME /tmp
EXPOSE 8082

ADD ./target/transaction-service-0.0.1-SNAPSHOT.jar transaction-service.jar
ENTRYPOINT ["java", "-jar", "transaction-service.jar"]