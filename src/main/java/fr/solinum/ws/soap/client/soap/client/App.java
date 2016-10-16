package fr.solinum.ws.soap.client.soap.client;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPException;

import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;
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
		marshaller.setContextPath("fr.solinum.ws.soap.client.soap.client.in");
		marshaller.afterPropertiesSet();

		webServiceTemplate.setMarshaller(marshaller);
		webServiceTemplate.afterPropertiesSet();
		
		System.out.println(webServiceTemplate);
	}
}
