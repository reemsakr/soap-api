package eg.gov.iti.jets;

import jakarta.jws.WebService;

@WebService
public interface ExchangeCalculationService {
    public double calculateExchange(ExchangeRequest request);
}
