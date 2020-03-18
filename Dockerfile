FROM airhacks/glassfish
COPY ./target/com.ultimateTodo.war ${DEPLOYMENT_DIR}
