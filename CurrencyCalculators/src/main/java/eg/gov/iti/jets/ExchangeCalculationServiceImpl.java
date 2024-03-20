package eg.gov.iti.jets;


import eg.gov.iti.jets.client.Disclaimer;
import eg.gov.iti.jets.client.ExchangeRateService;
import eg.gov.iti.jets.client.ExchangeRateServiceImplService;
import jakarta.jws.WebService;

@WebService(endpointInterface = "eg.gov.iti.jets.ExchangeCalculationService")
public class ExchangeCalculationServiceImpl implements ExchangeCalculationService {

    @Override
    public double calculateExchange(ExchangeRequest request) {

         ExchangeRateServiceImplService ex = new ExchangeRateServiceImplService();
         ExchangeRateService exchangeRateService = ex.getExchangeRateServiceImplPort();
         double rate = exchangeRateService.getExchangeRate(request.getSourceCountry(),request.getDestinationCountry(), Disclaimer.DOM);
         return rate*request.getAmount();

    }
}
