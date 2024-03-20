package eg.gov.iti.jets;

import jakarta.xml.ws.Endpoint;

public class ExchangeRateServicePublisher {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:7070/exchangeRateService",new ExchangeRateServiceImpl());
        System.out.println("Exchange Rate Service is running...");
    }
}
