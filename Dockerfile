FROM openjdk:17-alpine

COPY ./target/demo_docker-0.0.1-SNAPSHOT.jar /

RUN sh -c 'touch demo_docker-0.0.1-SNAPSHOT.jar'

ENTRYPOINT ["java","-jar","/demo_docker-0.0.1-SNAPSHOT.jar"]

RUN chmod +x /demo_docker-0.0.1-SNAPSHOT.jar