FROM openjdk:17-oracle
EXPOSE 8081
ADD target/*.jar m-dockerfile-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/m-dockerfile-0.0.1-SNAPSHOT.jar"]
