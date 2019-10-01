FROM openjdk:8-jdk-alpine
EXPOSE 8080
ADD /target/mongoboot-0.0.1-SNAPSHOT.jar mongoboot.jar
ENTRYPOINT ["java", "-Dspring.data.mongodb.uri=mongodb://mongodb:27017/test", "-jar", "mongoboot.jar"]