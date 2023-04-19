package com.example.projecthw5;

// ця структура для зберігання того, аби могли введену цитату обгортати в JSON і додавати в quotes, передавати і ті

import jakarta.validation.constraints.Size;// імпорт анотації валідації по розміру
import lombok.Data;
@Data
public class Quote
{
    @Size(max = 40,  message = "Size should be max 40 chars") // вводимо валідацію по розміру, тут вказали 40 символів,
    // тепер Spring буде автоматом перевіряти цитату на розмір, чи менший він 40

    private String quote;
    //додали анотацію @Data, тож гетери і сетери вже можна не писати

//    public String getQuote()
//    {
//        return quote;
//    }
//
//    public void setQuote(String quote)
//    {
//        this.quote = quote;
//    }

  }
