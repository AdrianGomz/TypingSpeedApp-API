package com.example.api.quote;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/quotes")
public class QuoteController {
    private final QuoteService quoteService;

    @Autowired
    public QuoteController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @GetMapping
    public List<Quote> getQuotes() {
        return quoteService.getQuotes();
    }

    @PostMapping
    public void registerQuote(@RequestBody Quote quote) {
        quoteService.addQuote(quote);
    }

    @DeleteMapping(path = "{quoteId}")
    public void deleteQuote(@PathVariable("quoteId") Long id) {
        quoteService.deleteQuote(id);
    }

    @PutMapping(path = "{quoteId}")
    public void updateQuote(@PathVariable("quoteId") Long id, @RequestParam(required = false) String title,
            @RequestParam(required = false) String quote,
            @RequestParam(required = false) String author) {
        quoteService.updateQuote(id, title, quote, author);
    }

    @PutMapping(path = "/json/{quoteId}")
    public void updateQuote(@PathVariable("quoteId") Long id, @RequestBody Quote quote) {
        quoteService.updateQuote(quote);
    }

    @GetMapping(path = "/random")
    public Quote getRandomQuote() {

        return quoteService.getRandomQuote();

    }

}
