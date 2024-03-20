package eg.gov.iti.jets;

import eg.gov.iti.jets.client.ExchangeRateService;
import eg.gov.iti.jets.client.ExchangeRateServiceImplService;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import jakarta.xml.soap.SOAPException;
import jakarta.xml.ws.BindingProvider;

import java.util.Map;

@WebService(endpointInterface = "eg.gov.iti.jets.ExchangeCalculationService")
public class ExchangeCalculationServiceImpl implements ExchangeCalculationService {

    @Override
    public ExchangeResponse calculateExchange(ExchangeRequest request,String declaimer) {

        try{
            ExchangeRateServiceImplService ex = new ExchangeRateServiceImplService();
            ExchangeRateService exchangeRateService = ex.getExchangeRateServiceImplPort();
            double rate = exchangeRateService.getExchangeRate( request.getSourceCountry(),request.getDestinationCountry(),declaimer);
            ExchangeResponse response = new ExchangeResponse(request.getSourceCountry(),request.getDestinationCountry(),rate,request.getAmount(),rate*request.getAmount());
            return response;
        }
        catch (Exception e){
            throw new RuntimeException(e);

        }
    }
}
