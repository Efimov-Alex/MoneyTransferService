FROM openjdk:17 as build
EXPOSE 8080
ADD target/springBootDemoApplication-1.0-SNAPSHOT.jar myapp.jar
ENTRYPOINT ["java","-jar","/myapp.jar"]