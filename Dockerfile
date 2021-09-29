FROM openjdk:11-jdk-slim

RUN mkdir /var/circleci-with-springboot

ARG DEPENDENCY=build
ADD ${DEPENDENCY}/libs/eb-scale-demo-0.0.1-SNAPSHOT.jar /var/circleci-with-springboot/circleciwithspringboot.jar

EXPOSE 8080

ENTRYPOINT ["java", "-Dserver.port=8080", "-jar","/var/circleci-with-springboot/circleciwithspringboot.jar"]
