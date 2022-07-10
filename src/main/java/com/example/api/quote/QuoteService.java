package com.example.api.quote;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class QuoteService {
    public List<Quote> getQuotes() {
        return List.of(
                new Quote(
                        1L,
                        "quote",
                        "author",
                        LocalDate.of(200, Month.JANUARY, 5)));
    }

}
