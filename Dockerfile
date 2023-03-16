FROM openjdk:17
EXPOSE 9091
ADD target/SpringBoot-Jenkins-GCP-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]