FROM 192.168.56.102:8080/micro-service/python:3.7
MAINTAINER zengqiang qzeng2017@163.com

RUN pip install thrift

ENV PYTHONPATH /
COPY message /message
ENTRYPOINT ["python","/message/message_service.py"]

