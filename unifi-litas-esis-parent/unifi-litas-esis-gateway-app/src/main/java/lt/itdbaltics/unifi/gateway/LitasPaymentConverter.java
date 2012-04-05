package lt.itdbaltics.unifi.gateway;

import java.util.Iterator;
import java.util.Map;

import lt.itdbaltics.unifi.LitasPayment;
import lt.itdbaltics.unifi.LitasPayments;

import org.apache.camel.Converter;
import org.apache.camel.component.flatpack.DataSetList;

@Converter
public class LitasPaymentConverter {
	@Converter
	public static LitasPayments toLitasPayments(DataSetList list) {
		LitasPayments dtoList = new LitasPayments();
		Iterator<Map<String, Object>> it = list.iterator();

		while (it.hasNext()) {
			Map<String, Object> row = it.next();
			LitasPayment dto = convertMapToDto(row);

			dtoList.add(dto);
		}
		
		return dtoList;
	}
	
	private static LitasPayment convertMapToDto(Map<String, Object> row) {
		LitasPayment dto = new LitasPayment();
		dto.setPriority((String) row.get(Columns.Priority));
		dto.setValueDate((String) row.get(Columns.ValueDate));

		dto.setPayerAccount((String) row.get(Columns.PayerAccount));
		dto.setPayerName((String) row.get(Columns.PayerName));
		dto.setPayerId((String) row.get(Columns.PayerId));
		dto.setCustomerCodeInBeneficiaryIs((String) row.get(Columns.CustomerCodeInBeneficiaryIs));
		dto.setPayerCreditInstitution((String) row.get(Columns.PayerCreditInstitution));

		dto.setOriginatorName((String) row.get(Columns.OriginatorName));
		dto.setOriginatorId((String) row.get(Columns.OriginatorId));
		dto.setOriginatorAccount((String) row.get(Columns.OriginatorAccount));

		dto.setDocumentNumber((String) row.get(Columns.DocumentNumber));

		dto.setBeneficiaryAccount((String) row.get(Columns.BeneficiaryAccount));
		dto.setBenificiaryName((String) row.get(Columns.BenificiaryName));
		dto.setBenificiaryId((String) row.get(Columns.BenificiaryId));
		dto.setCustomerCodeInPayerIs((String) row.get(Columns.CustomerCodeInPayerIs));
		dto.setBenificiaryCreditInsitution((String) row.get(Columns.BenificiaryCreditInsitution));

		dto.setBeneficiaryPartyAccount((String) row.get(Columns.BeneficiaryPartyAccount));
		dto.setBenificiaryPartyName((String) row.get(Columns.BenificiaryPartyName));
		dto.setBenificiaryPartyId((String) row.get(Columns.BenificiaryPartyId));

		dto.setAmount((String) row.get(Columns.Amount));
		dto.setCurrencyCode((String) row.get(Columns.CurrencyCode));

		dto.setReferenceNo((String) row.get(Columns.ReferenceNo));
		dto.setPaymentDetails((String) row.get(Columns.PaymentDetails));

		return dto;
	}

}
