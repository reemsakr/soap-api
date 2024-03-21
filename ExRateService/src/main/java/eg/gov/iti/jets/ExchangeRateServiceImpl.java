package eg.gov.iti.jets;

import eg.gov.iti.jets.exception.ParserException;
import eg.gov.iti.jets.parser.DOMParser;
import eg.gov.iti.jets.parser.XPathParser;
import jakarta.jws.WebService;
import jakarta.xml.ws.BindingType;

import java.io.File;
import java.io.FileInputStream;

//@BindingType(value = jakarta.xml.ws.soap.SOAPBinding.SOAP12HTTP_BINDING)
@WebService(endpointInterface = "eg.gov.iti.jets.ExchangeRateService")
public class ExchangeRateServiceImpl implements ExchangeRateService {

    private static final String EXCHANGE_RATE = "/exchange_rates.xml";
    @Override
    public double getExchangeRate(String sourceCountry, String destinationCountry, String disclaimer) throws ParserException {

        return switch (disclaimer) {
            case "DOM" -> getExchangeRateDOM(sourceCountry, destinationCountry);
            case "XPATH" -> getExchangeRateXPath(sourceCountry, destinationCountry);
            default -> throw new ParserException("Unsupported parsing method", "ER001");
        };
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
