FROM 192.168.56.102:8080/micro-service/openjdk:8-jre
MAINTAINER zengqiang qzeng2017@163.com

COPY target/course-edge-service-2.1.3.RELEASE.jar /course-edge-service.jar

ENTRYPOINT ["java","-jar","/course-edge-service.jar"]