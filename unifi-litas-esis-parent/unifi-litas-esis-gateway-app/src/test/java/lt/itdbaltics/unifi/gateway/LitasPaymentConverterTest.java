package lt.itdbaltics.unifi.gateway;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import lt.itdbaltics.unifi.LitasPayment;
import lt.itdbaltics.unifi.LitasPayments;

import org.apache.camel.component.flatpack.DataSetList;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class LitasPaymentConverterTest {
	private DataSetList dataSetlist;
	private Map<String, Object> row;

	@Before
	public void setUp() throws Exception {
		row = new HashMap<String, Object>();

		row.put(Columns.DocumentNumber, "180");
		row.put(Columns.ValueDate, "20090602");
		row.put(Columns.Priority, "2");
		row.put(Columns.PayerAccount, "LT137044060005294027");
		row.put(Columns.PayerName, "UAB \"BALTIJOS PAáARAI\"");
		row.put(Columns.PayerId, "300530635");
		row.put(Columns.PayerCreditInstitution, "70440");
		row.put(Columns.CustomerCodeInBeneficiaryIs, "CUST_CODE");
		row.put(Columns.OriginatorAccount, "LT827044060004726595");
		row.put(Columns.OriginatorName, "My Ultimate Debtor");
		row.put(Columns.OriginatorId, "1234567");
		row.put(Columns.BeneficiaryAccount, "LT827044060004726596");
		row.put(Columns.BenificiaryName, "BALDö SIMFONIJA UAB");
		row.put(Columns.BenificiaryId, "300092959");
		row.put(Columns.BenificiaryCreditInsitution, "70440");
		row.put(Columns.CustomerCodeInPayerIs, "CUST_CODE");
		row.put(Columns.BeneficiaryPartyAccount, "LT827044060004726594");
		row.put(Columns.BenificiaryPartyName, "My Ultimate Creditor");
		row.put(Columns.BenificiaryPartyId, "1234567");
		row.put(Columns.Amount, "16650");
		row.put(Columns.CurrencyCode, "LTL");
		row.put(Columns.ReferenceNo, "1001");
		row.put(Columns.PaymentDetails,
				"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut ut tortor a lorem faucibus auctor pharetra sed sem. Praesent et arcu non quam suscipit lobortis. Nullam congue neque a enim ornare ultrices. Pellentesque nisi felis, molestie a suscipit ac, pellentesque porta elit. Nulla pulvinar cras amet.");

		ArrayList<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		list.add(row);

		dataSetlist = Mockito.mock(DataSetList.class);
		Mockito.when(dataSetlist.get(0)).thenReturn(row);
		Mockito.when(dataSetlist.size()).thenReturn(1);
		Mockito.when(dataSetlist.iterator()).thenReturn(list.iterator());
	}

	@Test
	public void testConvert() {
		LitasPayments payments = LitasPaymentConverter.toLitasPayments(dataSetlist);
		LitasPayment payment = payments.get(0);
		
		assertEquals(payment.getDocumentNumber(),row.get(Columns.DocumentNumber));
		assertEquals(payment.getValueDate(),row.get(Columns.ValueDate));
		assertEquals(payment.getPriority(),row.get(Columns.Priority));
		assertEquals(payment.getPayerAccount(),row.get(Columns.PayerAccount));
		assertEquals(payment.getPayerName(),row.get(Columns.PayerName));
		assertEquals(payment.getPayerId(),row.get(Columns.PayerId));
		assertEquals(payment.getPayerCreditInstitution(),row.get(Columns.PayerCreditInstitution));
		assertEquals(payment.getCustomerCodeInBeneficiaryIs(),row.get(Columns.CustomerCodeInBeneficiaryIs));
		assertEquals(payment.getOriginatorAccount(),row.get(Columns.OriginatorAccount));
		assertEquals(payment.getOriginatorName(),row.get(Columns.OriginatorName));
		assertEquals(payment.getOriginatorId(),row.get(Columns.OriginatorId));
		assertEquals(payment.getBeneficiaryAccount(),row.get(Columns.BeneficiaryAccount));
		assertEquals(payment.getBenificiaryName(),row.get(Columns.BenificiaryName));
		assertEquals(payment.getBenificiaryId(),row.get(Columns.BenificiaryId));
		assertEquals(payment.getBenificiaryCreditInsitution(),row.get(Columns.BenificiaryCreditInsitution));
		assertEquals(payment.getCustomerCodeInPayerIs(),row.get(Columns.CustomerCodeInPayerIs));
		assertEquals(payment.getBeneficiaryPartyAccount(),row.get(Columns.BeneficiaryPartyAccount));
		assertEquals(payment.getBenificiaryPartyName(),row.get(Columns.BenificiaryPartyName));
		assertEquals(payment.getBenificiaryPartyId(),row.get(Columns.BenificiaryPartyId));
		assertEquals(payment.getAmount(),row.get(Columns.Amount));
		assertEquals(payment.getCurrencyCode(),row.get(Columns.CurrencyCode));
		assertEquals(payment.getReferenceNo(),row.get(Columns.ReferenceNo));
		assertEquals(payment.getPaymentDetails(),row.get(Columns.PaymentDetails));
	}
}
