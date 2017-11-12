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

/**
 * A simple test harness for locally invoking your Lambda function handler.
 */
public class MyRequestFunctionHandlerTest {

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
    	MyRequestFunctionHandler handler = new MyRequestFunctionHandler();
        Context ctx = createContext();
        
        Map<String,String> map = new HashMap<String,String>();
        
        map.put("test", "test");

        Quote quote =  handler.handleRequest(map, ctx);

        Assert.assertNotNull(quote);
       
        Assert.assertNotNull(quote.getQuote());
      
        Assert.assertTrue(quote.getQuoteId()>0);
    }
}
