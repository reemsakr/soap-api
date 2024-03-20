package eg.gov.iti.jets;

import jakarta.xml.ws.Endpoint;

public class ExchangeCalculationServicePublisher {
    public static void main(String[] args) {

        Endpoint.publish("http://localhost:6060/exchangeRateService",new ExchangeCalculationServiceImpl());
        System.out.println("Exchange Calculator Service is running...");
    }
}