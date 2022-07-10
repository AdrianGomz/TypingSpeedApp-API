package com.example.api.quote;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuoteService {
    private final QuoteRepository quoteRepository;

    @Autowired
    public QuoteService(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    public List<Quote> getQuotes() {
        return quoteRepository.findAll();
    }

    public void addQuote(Quote quote) {
        Optional<Quote> quoteExist = quoteRepository.findQuoteByTitle(quote.getTitle());
        if (quoteExist.isPresent()) {
            throw new IllegalStateException("Title taken");
        } else if (quote.getQuote().length() > 700) {

            throw new IllegalStateException("Quote is too long");
        } else if (quote.getTitle().length() > 100) {
            throw new IllegalStateException("Title is too long");
        } else {
            quoteRepository.save(quote);

        }
    }

    public void deleteQuote(Long id) {
        if (!quoteRepository.existsById(id)) {
            throw new IllegalStateException("Quote id:" + id + " does not exist");
        } else {
            quoteRepository.deleteById(id);
        }
    }

}
