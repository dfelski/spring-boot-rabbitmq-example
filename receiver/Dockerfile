FROM adoptopenjdk:11-jre-openj9
COPY ./build/libs/application-0.0.1.jar application.jar
ENTRYPOINT ["java", "-jar", "application.jar"]