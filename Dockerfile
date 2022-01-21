FROM adoptopenjdk/openjdk16:ubi
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT java -Dbot.username=$BOT_USERNAME -Dbot.token=$BOT_TOKEN -jar app.jar

