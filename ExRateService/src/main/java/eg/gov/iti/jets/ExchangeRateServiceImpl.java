package eg.gov.iti.jets;

import eg.gov.iti.jets.Enums.Disclaimer;
import eg.gov.iti.jets.parser.DOMParser;
import eg.gov.iti.jets.parser.XPathParser;
import jakarta.jws.WebService;
import java.io.File;
import java.io.FileInputStream;

@WebService(endpointInterface = "eg.gov.iti.jets.ExchangeRateService")
public class ExchangeRateServiceImpl implements ExchangeRateService {

    private static final String EXCHANGE_RATE = "/exchange_rates.xml";
    @Override
    public double getExchangeRate(String sourceCountry, String destinationCountry, Disclaimer disclaimer) {
        double exchange_rate = 0.0;
         switch (disclaimer){
            case DOM :
                 exchange_rate = getExchangeRateDOM(sourceCountry,destinationCountry);
            case XPATH:
                 exchange_rate =getExchangeRateXPath(sourceCountry,destinationCountry);

        }
         return exchange_rate;
    }

    @Override
    public double getExchangeRateDOM(String sourceCountry, String destinationCountry) {
        try{
            FileInputStream xmStream = new FileInputStream(new File(getClass().getResource(EXCHANGE_RATE).toURI()));
            return DOMParser.getExchangeRate(xmStream,sourceCountry,destinationCountry);
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public double getExchangeRateXPath(String sourceCountry, String destinationCountry) {
        try{
            FileInputStream xmStream = new FileInputStream(new File(getClass().getResource(EXCHANGE_RATE).toURI()));
            return XPathParser.getExchangeRate(xmStream,sourceCountry,destinationCountry);
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }
}
