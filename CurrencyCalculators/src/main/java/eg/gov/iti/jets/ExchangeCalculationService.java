package eg.gov.iti.jets;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;


@WebService(name = "CalculatorWebService",
        portName = "CalculatorWebServicePort",
        serviceName = "CalculatorServiceName",
        targetNamespace = "http://server.services.web.jets.iti.gov.eg/"
)
public interface ExchangeCalculationService {
    @WebMethod
    public ExchangeResponse calculateExchange(ExchangeRequest request, @WebParam(header = true)String declaimer);
}
