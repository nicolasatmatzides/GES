release: ./mvnw flyway:migrate
web: java -Dserver.port=$PORT $JAVA_OPTS -Xss2m -jar target/gpms-0.0.1-SNAPSHOT.jar