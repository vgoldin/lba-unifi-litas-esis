package lt.itdbaltics.unifi.gateway.pain;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.spi.DataFormat;

public class CustomerCreditTransferDataFormat implements DataFormat {
	@Override
	public void marshal(Exchange exchange, Object graph, OutputStream stream) throws Exception {
		@SuppressWarnings({ "unchecked"})
		List<Map<String, Object>> list = (List<Map<String, Object>>) graph;
		
		CustomerCreditTransferConverter.convertMokesisToCustomerCreditTransfer(list, stream);
	}

	@Override
	public Object unmarshal(Exchange exchange, InputStream stream) throws Exception {
		return null;
	}
}
