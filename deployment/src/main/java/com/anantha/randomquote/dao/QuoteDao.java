package com.anantha.randomquote.dao;

import java.util.List;

import com.anantha.randomquote.domain.Quote;

public interface QuoteDao {

	List<Quote> findAllQuotes();

    Quote findRandomQuote();

	void saveOrUpdateQuote(Quote quote);
    
}
