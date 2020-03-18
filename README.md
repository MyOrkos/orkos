# Build
mvn clean package && docker build -t org.example/com.ultimateTodo .

# RUN

docker rm -f com.ultimateTodo || true && docker run -d -p 8080:8080 -p 4848:4848 --name com.ultimateTodo org.example/com.ultimateTodo 