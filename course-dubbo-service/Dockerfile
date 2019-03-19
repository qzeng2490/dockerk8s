FROM 192.168.56.102:8080/micro-service/openjdk:8-jre
MAINTAINER zengqiang qzeng2017@163.com

COPY target/course-dubbo-service-2.1.3.RELEASE.jar /course-dubbo-service.jar

ENTRYPOINT ["java","-jar","/course-dubbo-service.jar"]