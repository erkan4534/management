server:
  port: 8085
spring:
  datasource:
    username: root
    password: root
    url: jdbc:postgresql://172.22.0.3:5432/schoolDb
  jpa:
    hibernate:
      ddl-auto: update
    properties:
      hibernate:
        dialect: org.hibernate.dialect.PostgreSQLDialect
        format_sql: true
    show-sql: true

docker build -t school-management .

docker container run --name school-management-3 -p 8085:8085 --network m-dockerfile_postgres school-management
 

