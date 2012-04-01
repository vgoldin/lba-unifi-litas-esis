package lt.itdbaltics.unifi.services.pain;
import java.io.StringWriter;
import java.net.URL;
import java.util.List;
import java.util.Map;

import javax.jws.WebMethod;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.ws.Action;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.handler.MessageContext;

import lt.itdbaltics.unifi.gateway.pain.CustomerCreditTransferBuilder;
import lt.itdbaltics.unifi.gateway.pain.LitasPaymentDto;
import lt.lba.xmlns._2011._11.unifi.customercredittransferinitiation.v03.ObjectFactory;
import lt.lba.xmlns._2011._11.unifi.customercredittransferinitiation.v03.SignableDocumentType;

import org.w3c.dom.Document;

public class Client {
	@Action(input = "urn:lt:lba:xmlns:unifi:services:PaymentsInitiation:V01/PaymentsInitiationV01/CustomerCreditTransferInitiationV03/CustomerCreditTransferInitiationV03Request", fault = {})
	@WebMethod(operationName = "CustomerCreditTransferInitiationV03", action = "urn:lt:lba:xmlns:unifi:services:PaymentsInitiation:V01/CustomerCreditTransferInitiationV03")
	public Source customerCreditTransferInitiationV03(Source request) {
		QName serviceName = new QName(
				"urn:lt:lba:xmlns:unifi:services:PaymentsInitiation:V01",
				"PaymentsInitiationV01");
		QName port = new QName(
				"urn:lt:lba:xmlns:unifi:services:PaymentsInitiation:V01",
				"PaymentsInitiationV01SOAP");
		URL wsdlURL = Client.class.getClassLoader().getResource("wsdl/lba-unifi-PaymentsInitiation-Bank-V01-Port.wsdl");
		Service service = Service.create(wsdlURL, serviceName);
		Dispatch<Source> dispatch = service.createDispatch(port, Source.class,
				Service.Mode.PAYLOAD);
		Map<String, Object> ctx = dispatch.getRequestContext();
		ctx.put("ws-security.callback-handler",
				"lt.lba.xmlns.unifi.services.paymentsinitiation.v01.wsse.ClientCallback");
		ctx.put("ws-security.encryption.properties", "client-crypto.properties");
		ctx.put("ws-security.encryption.username", "serverkey");
		ctx.put("ws-security.signature.properties", "client-crypto.properties");
		ctx.put("ws-security.signature.username", "clientkey");
		dispatch.getRequestContext()
				.put(MessageContext.WSDL_OPERATION,
						new QName(
								"urn:lt:lba:xmlns:unifi:services:PaymentsInitiation:V01",
								"CustomerCreditTransferInitiationV03"));

		Source response = dispatch.invoke(request);

		return response;
	}
	
	public static void sendLITASPayment(List<LitasPaymentDto> rows) {
		Client client = new Client();
		Document input = null;
		try {
			input = buildInputDocument(rows);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		DOMSource request = new DOMSource(input);
		DOMSource response = (DOMSource) client
				.customerCreditTransferInitiationV03(request);
		
		if (response != null) {
			try {
				Transformer transformer = TransformerFactory.newInstance()
						.newTransformer();
				StreamResult result = new StreamResult(new StringWriter());
				transformer.transform(response, result);
				
				System.out.println(result.getWriter().toString());
			} catch (TransformerException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	private static Document buildInputDocument(List<LitasPaymentDto> rows) throws Exception {
		SignableDocumentType signableType = CustomerCreditTransferBuilder.convertToSignableDocumentType(rows);
		
		DocumentBuilderFactory dbfac = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = dbfac.newDocumentBuilder();
		Document doc = docBuilder.newDocument();

		ObjectFactory of = new ObjectFactory();
		JAXBElement<SignableDocumentType> signable = of
				.createSignableDocument(signableType);
		signable.setValue(signableType);
		
		JAXBContext context = JAXBContext
				.newInstance(SignableDocumentType.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.marshal(signable, doc);

		return doc;
	}
}
