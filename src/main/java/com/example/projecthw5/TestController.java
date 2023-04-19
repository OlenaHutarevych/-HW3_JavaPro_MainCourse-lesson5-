package com.example.projecthw5;
//Домашнее задание 5:
//        1. Сделать все операции для цитат(прочитать все, прочитать по ид, добавить одну, добавить множество, обновить, удалить).
//        2. Создать html файл в папочке static. Создать новій контроллер и предоставить доступ клиенту к html.
//        3. Настроить валидацию:
//        3.1 Добавить зависимость в pom.xml.
//        3.2. Добавить @Validated аннотацию параметру контроллера
//        3.3 Добавить валидационное правило модели.
//        3.4 Добавить настроечку в application.properties чтобі біло відно сообщение ошибки в ответе:
//        server.error.include-message=always

//Домашнее задание 6:

//2. Попробовать собрать нашу программу через коммандную строку(в корне приложения через terminal віполнить 'mvn clean install') а также через интерфейс idea.
//        3. Добавить библиотеку lombok к нашему проекту: https://mvnrepository.com/artifact/org.projectlombok/lombok
//        4. Добавить аннотацию @Data над описанием класса для цитаті(Quote). Єто аннотация из библиотеки lombok, которая автоматически вставляет в класс getters/setters/toString/equals/hashCode. Теперь не нужно будет писать єто вручную или автогенерировать.
//        5. Доделать домашки из прошлого занятия.



import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController


public class TestController {
    // робимо поле з мапою
    private Map<Integer,String> quotes = new HashMap<>();  // в качестве поля устанавливаем мапу
    //робимо через блок ініціалізації, щоб не робити конструктор, геттери, сеттери

    {
        quotes.put(0,"Тепер, коли ми навчилися літати у повітрі, як птахи, плавати під водою, як риби, \n" +
                " нам не вистачає тільки одного: навчитися жити на землі, як люди.\n");
        quotes.put(1,"Не чекай, що стане легше, простіше, краще. Не стане. Труднощі будуть завжди.\n " +
                "Вчися бути щасливим прямо зараз. Інакше не встигнеш.\n"  +
                "Біль іноді йде, але думки-то залишаються.\n");
        quotes.put(2, "Якщо під музику не танцюють – це не музика\n");
        quotes.put(3,"– Скажіть, Дрісом, як ви думаєте, чому людей тягне до мистецтва?\n" +
                "– Може, тому що це прибутково?\n" +
                "– Ні, це єдиний спосіб залишити слід на землі.\n");
        quotes.put(4,"Прокласти свій шлях майже неможливо, якщо ступати весь час по чужих слідах.\n");
        quotes.put(5,"Наш припис призвів до того, що ми вкрали в дітей саме те, що допоможе їм стати сильними, — складнощі.\n");
        quotes.put(6,"Ідеальний чоловік - це чоловік, що вважає, що у нього ідеальна дружина. \n");
        quotes.put(7,"Життя - це не пошук себе. Життя - це створення себе. \n");
        quotes.put(8,"Люди, які вміють веселитися, не мають грошей, а люди, які мають гроші, не вміють веселитися. \n");
        quotes.put(9,"Людина - як цегла: обпалюючись, твердне.\n");
    }
    private Map<Integer,String> quotesSet = new HashMap<>();
    private int id = 9; // поле - для того счетчика, щоб записувати нові цитати від користувача

//метод, який повертає цитату по id, використовуючи не параметри, а саму URL адресу,
//  використовується анотація @PathVariable

    @GetMapping("/quote/{id}") //змінився URL, додалась змінна величина (у нас id), вказується в {}
    public String getQuote(@PathVariable Integer id) {

        return quotes.get(id);
    }

// метод, що повертає всю мапу, разом з id-шниками, тут мапа буде повернена як мапа - ключ : значення
    @GetMapping("/quotes")
    public Map<Integer,String> getQuotes() {
        return quotes;
    }

// метод, з використанням анотації валідації,що зчитує цитату  в JSON, повертає клієнту  id, під яким записав його цитату у мапу  quotes
// для цього зробили структуру IdHolder яка зберігає згенерований id, який інкримінується з кожним запитом
    @PostMapping("/quotes")
    public IdHolder postQuote(@RequestBody @Validated Quote quote){
        var responseIdToClient = new IdHolder(++id);
        quotes.put(responseIdToClient.getId(), quote.getQuote());
        return responseIdToClient;
    }
// метод для заміни цитати по id
    @PutMapping("/quote/{id}")
    public String exchangeQuoteById(@PathVariable Integer id,@RequestBody  Quote quote){
        quotes.put(id, quote.getQuote());
        return ("id "+ id + "  " + quotes.get(id));
    }
// метод, що видаляє цитату з мапи по введеному  id
    @DeleteMapping("/quote/{id}")
    public void deleteQuoteById(@PathVariable Integer id){
        quotes.remove(id);
    }

    @PostMapping("/quotesset")
    public void postMapOfQuote (@RequestBody  Quote [] quotesSet){

        for (var quote : quotesSet){
             quotes.put(++id, quote.getQuote());
        }
    }
}
