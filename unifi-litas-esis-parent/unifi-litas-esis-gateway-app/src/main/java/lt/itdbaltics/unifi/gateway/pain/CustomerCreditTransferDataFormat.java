package lt.itdbaltics.unifi.gateway.pain;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import lt.itdbaltics.unifi.LitasPayment;
import lt.itdbaltics.unifi.LitasPayments;
import lt.itdbaltics.unifi.pain.CustomerCreditTransferBuilder;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.spi.DataFormat;

/**
 * <code>List</code> to ISO20022 pain.001 XML marshaler
 * 
 * The purpose of this DataFormat is to marshal <code>List</code> to pain.001 (CustomerCreditTransferInitiationV03)
 * XML
 * 
 * @author vgoldin
 * 
 */
public class CustomerCreditTransferDataFormat implements DataFormat {
	@Override
	public void marshal(Exchange exchange, Object graph, OutputStream stream) throws Exception {
		Message message = exchange.getIn();
		
		List<LitasPayment> dtoList = message.getBody(LitasPayments.class);
		
		CustomerCreditTransferBuilder.serializeToSignableDocumentTypeXML(dtoList, stream);
	}

	@Override
	public Object unmarshal(Exchange exchange, InputStream stream) throws Exception {
		throw new UnsupportedOperationException("Not implemented");
	}
}
