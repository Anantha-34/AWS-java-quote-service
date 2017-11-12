package com.anantha.randomquote.dao;

import java.util.List;
import java.util.Random;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.Select;
import com.anantha.randomquote.domain.Quote;
import com.anantha.randomquote.manager.DynamoDBManager;

public class DynamoDBQuoteDao implements QuoteDao {

    private static Random random = new Random();

    private static final DynamoDBMapper mapper = DynamoDBManager.mapper();

    private static volatile DynamoDBQuoteDao instance;	
	
    private DynamoDBQuoteDao() { }

    public static DynamoDBQuoteDao instance() {

        if (instance == null) {
            synchronized(DynamoDBQuoteDao.class) {
                if (instance == null)
                    instance = new DynamoDBQuoteDao();
            }
        }
        return instance;
    }   
    
	@Override
	public List<Quote> findAllQuotes() {
        return mapper.scan(Quote.class, new DynamoDBScanExpression());
	}

    @Override
    public void saveOrUpdateQuote(Quote quote) {
        mapper.save(quote);
    }	
	
	@Override
	public Quote findRandomQuote() {
		DynamoDBScanExpression scanExpression = new DynamoDBScanExpression();
        scanExpression.setSelect(Select.COUNT);

        int count = mapper.count(Quote.class, scanExpression);
        Quote quote = mapper.load(Quote.class, random.nextInt(count-1));
        
		while ( quote == null)
		{
			quote = mapper.load(Quote.class, random.nextInt(count-1));
		}

		return quote;
	}


}
