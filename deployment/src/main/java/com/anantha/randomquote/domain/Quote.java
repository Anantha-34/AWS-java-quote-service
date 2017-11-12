package com.anantha.randomquote.domain;

import java.io.Serializable;

import com.amazonaws.services.dynamodbv2.datamodeling.*;

@DynamoDBTable(tableName = "Quote")
public class Quote implements Serializable
{
	 private static final long serialVersionUID = -82431454238016232L;

	 @DynamoDBHashKey(attributeName = "quoteId")
	 private int quoteId;

	 @DynamoDBAttribute
	 private String quote;

	 public Quote() { }

	 public Quote(int quoteId, String quote) {
	     this.quoteId = quoteId;
	     this.quote = quote;
	 }

	 public int getQuoteId() {
		return quoteId;
	}
	 
	public void setQuoteId(int quoteId) {
		this.quoteId = quoteId;
	}
	
	public String getQuote() {
		return quote;
	}
	
	public void setQuote(String quote) {
		this.quote = quote;
	}
	 
}

