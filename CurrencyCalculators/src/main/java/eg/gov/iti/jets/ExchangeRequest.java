package eg.gov.iti.jets;

import lombok.Data;

//@NoArgsConstructor
//@AllArgsConstructor
//@Setter
//@Getter
@Data
public class ExchangeRequest {
    private String sourceCountry;
    private String destinationCountry;
    private double amount;

}
