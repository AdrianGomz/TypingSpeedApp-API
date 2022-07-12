package com.example.api.quote;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class QuoteService {
    private final QuoteRepository quoteRepository;
    private Random random = new Random();

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

    @Transactional
    public void updateQuote(Long id, String title, String quote, String author) {
        Quote quoteObj = quoteRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Quote id:" + id + " does not exist"));
        if (title != null && title.length() > 0) {
            Optional<Quote> quoteExist = quoteRepository.findQuoteByTitle(title);
            if (quoteExist.isPresent()) {
                throw new IllegalStateException("Quote with title: " + title + " already exist");
            } else {

                quoteObj.setTitle(title);
            }
        }
        if (quote != null && quote.length() > 0) {
            quoteObj.setQuote(quote);
        }
        if (author != null && author.length() > 0) {
            quoteObj.setAuthor(author);
        }

    }

    public void updateQuote(Quote updateQuote) {
        System.out.println(updateQuote);
        Quote quoteObj = quoteRepository.findById(updateQuote.getId())
                .orElseThrow(() -> new IllegalStateException("Quote id:" + updateQuote.getId() + " does not exist"));
        if (updateQuote.getTitle() != null && updateQuote.getTitle().length() > 0) {
            Optional<Quote> quoteExist = quoteRepository.findQuoteByTitle(updateQuote.getTitle());
            if (quoteExist.isPresent()) {
                throw new IllegalStateException("Quote with title: " + updateQuote.getTitle() + " already exist");
            } else {
                quoteObj.setTitle(updateQuote.getTitle());

            }
        }
        if (updateQuote.getQuote() != null && updateQuote.getQuote().length() > 0) {
            quoteObj.setQuote(updateQuote.getQuote());
        }
        if (updateQuote.getAuthor() != null && updateQuote.getAuthor().length() > 0) {
            quoteObj.setAuthor(updateQuote.getAuthor());
        }
        quoteRepository.save(quoteObj);
    }

    public Quote getRandomQuote() {
        List<Quote> quotes = quoteRepository.findAll();
        int index = random.nextInt(quotes.size());
        return quotes.get(index);
    }

    public Quote findById(Long id) {
        Quote q = quoteRepository.findById(id).get();
        return q;
    }

}
