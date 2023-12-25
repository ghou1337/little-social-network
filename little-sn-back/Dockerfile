# Используем базовый образ с OpenJDK
FROM openjdk:17-jdk-alpine

# Устанавливаем Maven
RUN apk --no-cache add maven

# Создаем директорию для приложения
RUN mkdir -p /app

# Устанавливаем рабочую директорию
WORKDIR /app

# Копируем только файл POM для кэширования зависимостей
COPY pom.xml /app/

# Запускаем Maven для загрузки зависимостей
RUN mvn dependency:go-offline

# Копируем остальной исходный код приложения
COPY src /app/src

# Собираем приложение
RUN mvn clean package

# Динамически находим JAR-файл (предполагается, что существует только один JAR-файл)
RUN mv $(find /app/target -name '*.jar') /app/app.jar

# Открываем порт, на котором будет работать приложение
EXPOSE 8080

# Задаем команду для запуска приложения при старте контейнера
CMD ["java", "-jar", "/app/app.jar"]


#FROM maven:3.8.4-openjdk-17-slim
#
## Копируем собранные файлы из предыдущего этапа
#COPY --from=build /app/target/*.jar /app/app.jar
#
## Определяем переменные окружения
#ENV SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/social_network_db
#ENV SPRING_DATASOURCE_USERNAME=postgres
#ENV SPRING_DATASOURCE_PASSWORD=228322
#
## Открываем порт, на котором будет работать приложение
#EXPOSE 8080
#
## Команда, которая будет выполнена при старте контейнера
#CMD ["java", "-jar", "/app/app.jar"]