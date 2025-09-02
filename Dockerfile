FROM openjdk:21-jdk
WORKDIR /app
COPY target/university-course-management-system.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]
