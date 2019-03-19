FROM 192.168.56.102:8080/micro-service/openjdk:8-jre
MAINTAINER zengqiang qzeng2017@163.com

COPY target/api-gateway-zuul-1.0-SNAPSHOT.jar /api-gateway-zuul.jar

ENTRYPOINT ["java","-jar","/api-gateway-zuul.jar"]