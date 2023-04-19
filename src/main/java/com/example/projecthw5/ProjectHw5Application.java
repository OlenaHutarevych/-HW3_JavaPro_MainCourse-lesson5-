package com.example.projecthw5;

//Домашнее задание 6:

//2. Попробовать собрать нашу программу через коммандную строку(в корне приложения через terminal віполнить 'mvn clean install') а также через интерфейс idea.
//        3. Добавить библиотеку lombok к нашему проекту: https://mvnrepository.com/artifact/org.projectlombok/lombok
//        4. Добавить аннотацию @Data над описанием класса для цитаті(Quote). Єто аннотация из библиотеки lombok, которая автоматически вставляет в класс getters/setters/toString/equals/hashCode. Теперь не нужно будет писать єто вручную или автогенерировать.
//        5. Доделать домашки из прошлого занятия.

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectHw5Application {

    public static void main(String[] args) {
        SpringApplication.run(ProjectHw5Application.class, args);
    }

}
