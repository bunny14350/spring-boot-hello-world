package com.patrickgrimard;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.*;

import java.io.IOException;

/**
 * Created by XTL on 8/14/2014.
 */
@RequestMapping("/quotes/**")
@RestController
public class WidgetController {


    @RequestMapping(method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Object getQuotes() throws IOException {

        //TODO: call yahoo API
        //return new Widget("green", 10, 7);

        System.out.println("getting quotes...");

        //String url = "http://download.finance.yahoo.com/d/quotes?bypass=true&s=GOOG%20AAPL&f=snl1";
        String url = "http://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20yahoo.finance.quotes%20where%20symbol%20in%20(%22YHOO%22%2C%22AAPL%22%2C%22GOOG%22%2C%22MSFT%22)%0A%09%09&env=http%3A%2F%2Fdatatables.org%2Falltables.env&format=json";


        HttpClient client = new HttpClient();
        //client.getHostConfiguration().setHost( url , 80, "http" );
        HttpMethod method = new GetMethod(url);
        client.executeMethod(method);
        System.out.println(method.getStatusLine());

        //method.releaseConnection();

        return method.getResponseBodyAsString();
    }

}
