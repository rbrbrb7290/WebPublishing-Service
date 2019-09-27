# Start with a base image containing Java runtime
FROM openjdk:8-jdk
# Add a volume to /tmp
VOLUME /tmp
# Make port 8080 available to the world outside this container
EXPOSE 8080
# The application's jar file
# ADD? File host -> container + [source] 기능
# COPY? 단순 복사 기능
ARG JAR_FILE=build/libs/shopping-mall-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} shopping-mall.jar
# Run the jar file
# CMD / ENTRYPOINT 차이 알아두기
#ENTRYPOINT - 컨테이너 실행 시 반드시 지정된 명령수행
#CMD - 컨테이너 실행 시 인자값이 주어지면 CMD값을 대신하여 지정한 인자값으로 변경하고 실행
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/shopping-mall.jar"]
