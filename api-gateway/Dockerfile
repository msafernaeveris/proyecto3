FROM openjdk:8-alpine
COPY "./target/api-gateway-0.0.1-SNAPSHOT.jar" "app-api-gateway.jar"
EXPOSE 8080
ENTRYPOINT ["java","-jar","app-api-gateway.jar"]