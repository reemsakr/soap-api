package eg.gov.iti.jets.exception;

import jakarta.xml.ws.WebFault;

@WebFault
public class ParserException extends Exception{

    private String faultCode;
    public ParserException(String message,String faultCode){
        super(message);
        this.faultCode = faultCode;
    }
    public String getFaultCode(){
        return faultCode;
    }
}
