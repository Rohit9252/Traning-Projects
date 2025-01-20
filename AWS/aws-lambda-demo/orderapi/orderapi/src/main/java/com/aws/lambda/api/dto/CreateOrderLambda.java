package com.aws.lambda.api.dto;


import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

public class CreateOrderLambda {




    @SneakyThrows
    public APIGatewayProxyResponseEvent createOrder(APIGatewayProxyRequestEvent request) {
        ObjectMapper mapper  = new ObjectMapper();
        Order order =   mapper.readValue(request.getBody(), Order.class);
        return new APIGatewayProxyResponseEvent().withStatusCode(200).withBody("Order created with id: "+order.getId());

    }



}
