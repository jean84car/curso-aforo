FROM openjdk:8

VOLUME /tmp
EXPOSE 8090

ADD ./target/gateway_server-0.0.1-SNAPSHOT.jar gateway_server.jar
ENTRYPOINT ["java", "-jar", "gateway_server.jar"]