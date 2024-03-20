package eg.gov.iti.jets;

import lombok.AllArgsConstructor;
import lombok.Data;
@AllArgsConstructor
@Data
public class ExchangeResponse {
    private String sourceCountry;
    private String destinationCountry;
    private double exchangeRate;
    private double principalAmount;
    private double ConvertedAmount;


}
