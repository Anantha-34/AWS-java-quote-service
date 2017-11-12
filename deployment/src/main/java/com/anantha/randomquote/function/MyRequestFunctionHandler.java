package com.anantha.randomquote.function;

import java.util.Map;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.anantha.randomquote.dao.DynamoDBQuoteDao;
import com.anantha.randomquote.domain.Quote;
import com.anantha.randomquote.util.Hostname;

public class MyRequestFunctionHandler implements RequestHandler<Map<String,String>, Quote> {
	private static final DynamoDBQuoteDao quoteDao = DynamoDBQuoteDao.instance();
	
    @Override
    public Quote handleRequest(Map<String,String> input, Context context) {
        context.getLogger().log("Input" + Hostname.getHostname() + " : " + input);

		Quote quote = quoteDao.findRandomQuote();

		return quote;
    }  
}
