FROM openjdk:21-jdk
COPY target/university-course-management-system.jar .
EXPOSE 8080
ENTRYPOINT ["java","-jar","university-course-management-system.jar"]
