FROM openjdk:17-oracle
EXPOSE 8081
ADD target/*.jar m-dockerfile.jar
ENTRYPOINT ["java","-jar","/m-dockerfile.jar"]
