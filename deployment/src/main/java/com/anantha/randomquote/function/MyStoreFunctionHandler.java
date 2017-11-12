package com.anantha.randomquote.function;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.anantha.randomquote.dao.DynamoDBQuoteDao;
import com.anantha.randomquote.domain.Quote;
import com.anantha.randomquote.util.Hostname;

public class MyStoreFunctionHandler implements RequestHandler<Quote,String>{
	private static final DynamoDBQuoteDao quoteDao = DynamoDBQuoteDao.instance();
	
	@Override
	public String handleRequest(Quote input, Context context) {
        
	context.getLogger().log("Input: " + Hostname.getHostname() + " : " + input);
	
	try
	{
		quoteDao.saveOrUpdateQuote(input);
	}
	catch (Exception e)
	{
		context.getLogger().log("Input: " + Hostname.getHostname() + " :asd ");
		return "failure";
	}
	
	return "succcess";
	
	}

}
