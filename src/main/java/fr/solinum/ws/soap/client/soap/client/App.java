package fr.solinum.ws.soap.client.soap.client;

import javax.xml.soap.MessageFactory;

import net.webservicex.GetCitiesByCountry;

import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.SoapMessage;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws Exception {
		// System.out.println( "Hello World!" );

		SaajSoapMessageFactory messageFactory = new SaajSoapMessageFactory(
				MessageFactory.newInstance());
		messageFactory.afterPropertiesSet();

		WebServiceTemplate webServiceTemplate = new WebServiceTemplate(
				messageFactory);
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("net.webservicex");
		marshaller.afterPropertiesSet();

		webServiceTemplate.setMarshaller(marshaller);
		webServiceTemplate.afterPropertiesSet();

		System.out.println(webServiceTemplate);
		
		GetCitiesByCountry byCountry = new GetCitiesByCountry();
		byCountry.setCountryName("France");

		Object response = webServiceTemplate.marshalSendAndReceive("http://www.webservicex.com/globalweather.asmx", byCountry
				,
                new WebServiceMessageCallback() {
                    public void doWithMessage(WebServiceMessage message) 
                    {
                        ((SoapMessage)message).setSoapAction("http://www.webservicex.com/globalweather.asmx/GetCitiesByCountry");
                    }
               });
		
		System.out.println(response);

	}
}
