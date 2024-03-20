package eg.gov.iti.jets;


import eg.gov.iti.jets.Enums.Disclaimer;
import jakarta.jws.WebService;

@WebService
public interface ExchangeRateService {
    public  double getExchangeRate(String sourceCountry , String destinationCountry, Disclaimer disclaimer);
    public double getExchangeRateDOM(String sourceCountry , String destination);

    public double getExchangeRateXPath(String sourceCountry , String destination);
}
