FROM openjdk:17
COPY build/libs/printing-studio-0.0.1-SNAPSHOT.jar printing-studio.jar

ENTRYPOINT ["java", "-jar", "printing-studio.jar"]