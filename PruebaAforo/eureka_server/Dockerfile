FROM openjdk:8

VOLUME /tmp
EXPOSE 8761

ADD ./target/eureka_server-0.0.1-SNAPSHOT.jar eureka_server.jar 
ENTRYPOINT ["java", "-jar", "eureka_server.jar"]