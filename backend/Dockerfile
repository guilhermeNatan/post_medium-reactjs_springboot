FROM maven:3.8.6-openjdk-11 as build

WORKDIR /app

COPY ./pom.xml .

RUN mvn dependency:go-offline -B

COPY ./src src

RUN mvn clean package

RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

#FROM openjdk:8-jdk-alpine
FROM openjdk:11

ARG DEPENDENCY=/app/target/dependency

# Copia as dependências do projeto a partir da imagem 'build'
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app

ENTRYPOINT ["java","-cp","app:app/lib/*","com.app.backend.BackendApplication"]
