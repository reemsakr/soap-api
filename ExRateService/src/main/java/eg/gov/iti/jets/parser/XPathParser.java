package eg.gov.iti.jets.parser;

import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import java.io.InputStream;

public class XPathParser {
    public static double getExchangeRate(InputStream xmlStream, String sourceCountry , String destinationCountry){
        try{
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlStream);

            XPathFactory xPathFactory = XPathFactory.newInstance();
            XPath xPath = xPathFactory.newXPath();
            XPathExpression expr = xPath.compile("//currency[code='"+sourceCountry+"']/rate/text()");
            double sourceRate = Double.parseDouble((String) expr.evaluate(doc, XPathConstants.STRING));

            expr = xPath.compile("//currency[code='"+destinationCountry+"']/rate/text()");
            double destinationRate = Double.parseDouble((String) expr.evaluate(doc, XPathConstants.STRING));

            return destinationRate/sourceRate;
        }catch (Exception e){
            e.printStackTrace();
        }
        return -1; // indicate that exchange rate is not found
    }
}
