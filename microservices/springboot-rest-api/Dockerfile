#FROM eclipse-temurin:17
## Dockerfile always starts from [base-image]
#LABEL authors="ramakrishna"
## use LABEL to add metadata
#WORKDIR /app
## use WORKDIR /path-to-dir to define working diretory in the container
#COPY target/springboot-rest-api-0.0.1-SNAPSHOT.jar /app/springboot-rest-api.jar
## use COPY src dest to copy src file from local to destination docker
#ENTRYPOINT ["java", "-jar", "springboot-rest-api.jar"]
## ENTRYPOINT ["executable", "param1", "param2", ...]
## it is the first command that will run when the image is deployed.

FROM eclipse-temurin:17
RUN mkdir /opt/app
COPY target/springboot-rest-api-0.0.1-SNAPSHOT.jar /opt/app/springboot-rest-api.jar
CMD ["java", "-jar", "/opt/app/springboot-rest-api.jar"]