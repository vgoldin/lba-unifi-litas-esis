package lt.itdbaltics.unifi.gateway.pain;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.spi.DataFormat;

public class CustomerCreditTransferDataFormat implements DataFormat {
	@Override
	public void marshal(Exchange exchange, Object graph, OutputStream stream) throws Exception {
		@SuppressWarnings({ "unchecked"})
		List<Map<String, Object>> list = (List<Map<String, Object>>) graph;
		
		List<LitasPaymentDto> dtoList = new ArrayList<LitasPaymentDto>();
		Iterator<Map<String, Object>> it = list.iterator();
		
		while (it.hasNext()) {
			Map<String, Object> row = it.next();
			LitasPaymentDto dto = convertMapToDto(row);
			
			dtoList.add(dto);
		}
		
		CustomerCreditTransferConverter.convertToCustomerCreditTransferAndSerialize(dtoList, stream);
	}

	private LitasPaymentDto convertMapToDto(Map<String, Object> row) {
		LitasPaymentDto dto = new LitasPaymentDto();
		dto.setPriority((String) row.get(Columns.PmtTpInfInstrPrty));
		dto.setValueDate((String) row.get(Columns.ReqdExctnDt));
		
		dto.setPayerAccount((String) row.get(Columns.DbtrAcctIdIBAN));
		dto.setPayerName((String) row.get(Columns.DbtrNm));
		dto.setPayerId((String) row.get(Columns.DbtrIdOtherId));
		dto.setCustomerCodeInBeneficiaryIs((String) row.get(Columns.DbtrIdOtherIdCUST));
		dto.setPayerCreditInstitution((String) row.get(Columns.DbtrAgtFinInstnIdBIC));
		
		dto.setOriginatorName((String) row.get(Columns.UltmtDbtrNm));
		dto.setOriginatorId((String) row.get(Columns.UltmtDbtrIdOtherId));
		dto.setOriginatorAccount((String) row.get(Columns.UltmtDbtrIdOtherIdIBAN));

		dto.setDocumentNumber((String) row.get(Columns.CdtTrfTxInfPmtId));

		dto.setBeneficiaryAccount((String) row.get(Columns.CdtrAcctIdIBAN));
		dto.setBenificiaryName((String) row.get(Columns.CdtrNm));
		dto.setBenificiaryId((String) row.get(Columns.CdtrIdOtherId));
		dto.setCustomerCodeInPayerIs((String) row.get(Columns.CdtrIdOtherIdCUST));
		dto.setBenificiaryCreditInsitution((String) row.get(Columns.CdtrAgtFinInstnIdBIC));
		
		dto.setBeneficiaryPartyAccount((String) row.get(Columns.UltmtCdtrIdOtherIdIBAN));
		dto.setBenificiaryPartyName((String) row.get(Columns.UltmtCdtrNm));
		dto.setBenificiaryPartyId((String) row.get(Columns.UltmtCdtrIdOtherId));
		
		dto.setAmount((String) row.get(Columns.AmtInstdAmt));
		dto.setCurrencyCode((String) row.get(Columns.AmtInstdAmtCcy));
		
		dto.setReferenceNo((String) row.get(Columns.PurpPrtry));
		dto.setPaymentDetails((String) row.get(Columns.RmtInfUstrd));
		
		return dto;
	}

	@Override
	public Object unmarshal(Exchange exchange, InputStream stream) throws Exception {
		throw new UnsupportedOperationException("Not implemented");
	}
}
