package helloworld;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

/**
 * Handler for requests to Lambda function.
 */

public class App  {

    @SneakyThrows
    public APIGatewayProxyResponseEvent createOrder(APIGatewayProxyRequestEvent request) {
        ObjectMapper mapper  = new ObjectMapper();
        Order order =   mapper.readValue(request.getBody(), Order.class);
        return new APIGatewayProxyResponseEvent().withStatusCode(200).withBody("Order created with id: "+order.getId());
    }

    private String getPageContents(String address) throws IOException{
        URL url = new URL(address);
        try(BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()))) {
            return br.lines().collect(Collectors.joining(System.lineSeparator()));
        }
    }
}
