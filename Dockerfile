FROM openjdk:8u181-jre-slim
COPY /build/libs/pc-notifier-agent-email.jar pc-notifier-agent-email.jar
ENTRYPOINT ["java",  "-jar","/pc-notifier-agent-email.jar"]
