package eg.gov.iti.jets;


import eg.gov.iti.jets.Enums.Disclaimer;
import eg.gov.iti.jets.exception.ParserException;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

@WebService
public interface ExchangeRateService {
    public  double getExchangeRate(String sourceCountry , String destinationCountry, String disclaimer) throws ParserException;
    public double getExchangeRateDOM(String sourceCountry , String destination);

    public double getExchangeRateXPath(String sourceCountry , String destination);
}
