FROM eclipse-temurin:17-jdk-alpine
WORKDIR /workspace/app
COPY build/libs/*-SNAPSHOT.jar ./app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]