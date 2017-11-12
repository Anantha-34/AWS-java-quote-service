package com.anantha.randomquote.function;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.amazonaws.services.lambda.runtime.Context;
import com.anantha.randomquote.domain.Quote;
import com.anantha.randomquote.function.MyRequestFunctionHandler;
import com.anantha.randomquote.function.MyStoreFunctionHandler;

/**
 * A simple test harness for locally invoking your Lambda function handler.
 */
public class MyStoreFunctionHandlerTest {

    private static Object input;

    @BeforeClass
    public static void createInput() throws IOException {
        // TODO: set up your sample input object here.
        input = null;
    }

    private Context createContext() {
        TestContext ctx = new TestContext();

        // TODO: customize your context here if needed.
        ctx.setFunctionName("Your Function Name");

        return ctx;
    }

    @Test
    public void testLambdaFunctionHandler() {
    	MyStoreFunctionHandler handler = new MyStoreFunctionHandler();
        Context ctx = createContext();
        
        Quote quote = new Quote();
        
        quote.setQuoteId(4343);
        quote.setQuote("teere");
        
        String output = handler.handleRequest(quote, ctx);

        Assert.assertEquals("succcess", output);
        
    }

    @Test
    public void testFailureLambdaFunctionHandler() {
    	MyStoreFunctionHandler handler = new MyStoreFunctionHandler();
        Context ctx = createContext();
        
        Quote quote = new Quote();
        
        quote=null;
        
        String output = handler.handleRequest(quote, ctx);

        Assert.assertEquals("failure", output);

    }
    
}
