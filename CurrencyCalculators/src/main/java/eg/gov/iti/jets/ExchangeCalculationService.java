package eg.gov.iti.jets;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import jakarta.xml.ws.BindingType;


@WebService(name = "CalculatorWebService",
        portName = "CalculatorWebServicePort",
        serviceName = "CalculatorServiceName",
        targetNamespace = "http://server.services.web.jets.iti.gov.eg/"
)
@BindingType(value = jakarta.xml.ws.soap.SOAPBinding.SOAP12HTTP_BINDING)
public interface ExchangeCalculationService {
    @WebMethod
    public ExchangeResponse calculateExchange(ExchangeRequest request, @WebParam(header = true)String declaimer);
}
