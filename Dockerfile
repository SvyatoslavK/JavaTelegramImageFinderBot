FROM adoptopenjdk/openjdk11:ubi
ARG JAR_FILE=target/*.jar
ENV BOT_USERNAME = ${BOT_USERNAME}
ENV BOT_TOKEN = ${BOT_TOKEN}
ENV DBNAME = ${DBNAME}
ENV PASSWORD = ${PASSWORD}
EXPOSE 8080
COPY ${JAR_FILE} app.jar
ENTRYPOINT java -Dbot.username=$BOT_USERNAME -Dbot.token=$BOT_TOKEN -DDBNAME=$DBNAME -DPASSWORD=$PASSWORD -jar app.jar

