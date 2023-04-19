package com.example.projecthw5;

//2. Создать html файл в папочке static. Создать новій контроллер и предоставить доступ клиенту к html.

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class TestControllerHTML {
    @GetMapping("/hello")
    public String hello(){
        return "index.html";
    }

}
