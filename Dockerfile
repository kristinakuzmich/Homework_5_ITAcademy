FROM tomcat:11.0.9-jdk21
LABEL authors="kris"

WORKDIR /usr/local/tomcat/webapps
ADD target/Homework_4_ITAcademy-2.0.war .

CMD ["catalina.sh", "run"]