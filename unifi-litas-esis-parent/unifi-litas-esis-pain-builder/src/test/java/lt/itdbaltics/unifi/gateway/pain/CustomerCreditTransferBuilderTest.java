package lt.itdbaltics.unifi.gateway.pain;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import lt.itdbaltics.unifi.LitasPayment;
import lt.itdbaltics.unifi.pain.CustomerCreditTransferBuilder;

import org.junit.Test;
import org.custommonkey.xmlunit.*;

public class CustomerCreditTransferBuilderTest extends XMLTestCase {
	private LitasPayment row = new LitasPayment();
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		
		HashMap<String, String> ns = new HashMap<String, String>();
		ns.put("ns", "http://www.lba.lt/xmlns/2011/11/unifi/CustomerCreditTransferInitiation/V03");
		ns.put("ns1", "urn:iso:std:iso:20022:tech:xsd:pain.001.001.03");
		
		NamespaceContext ctx = new SimpleNamespaceContext(ns);
		XMLUnit.setXpathNamespaceContext(ctx);
		
		row.setDocumentNumber("180");
		row.setValueDate("20090602");
		row.setPriority("2");
		row.setPayerAccount("LT137044060005294027");
		row.setPayerName("UAB \"BALTIJOS PAáARAI\"");
		row.setPayerId("300530635");
		row.setPayerCreditInstitution("70440");
		row.setCustomerCodeInBeneficiaryIs("CUST_CODE");
		row.setOriginatorAccount("LT827044060004726595");
		row.setOriginatorName("My Ultimate Debtor");
		row.setOriginatorId("1234567");
		row.setBeneficiaryAccount("LT827044060004726596");
		row.setBenificiaryName("BALDö SIMFONIJA UAB");
		row.setBenificiaryId("300092959");
		row.setBenificiaryCreditInsitution("70440");
		row.setCustomerCodeInPayerIs("CUST_CODE");
		row.setBeneficiaryPartyAccount("LT827044060004726594");
		row.setBenificiaryPartyName("My Ultimate Creditor");
		row.setBenificiaryPartyId("1234567");
		row.setAmount("16650");
		row.setCurrencyCode("LTL");
		row.setReferenceNo("1001");
		row.setPaymentDetails("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut ut tortor a lorem faucibus auctor pharetra sed sem. Praesent et arcu non quam suscipit lobortis. Nullam congue neque a enim ornare ultrices. Pellentesque nisi felis, molestie a suscipit ac, pellentesque porta elit. Nulla pulvinar cras amet.");
	}
	
	@Test
	public void testSerializeToSignableDocumentTypeXML() throws Exception {
		List<LitasPayment> rows = new ArrayList<LitasPayment>();
		rows.add(row);
		
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		marshalLitasEsisToXML(rows, stream);
		
		String xml = stream.toString("UTF-8");
		
		assertXpathEvaluatesTo(Integer.toString(rows.size()), "/ns:SignableDocument/ns1:Document/ns1:CstmrCdtTrfInitn/ns1:GrpHdr/ns1:NbOfTxs", xml);
		assertXpathEvaluatesTo("TRF", "/ns:SignableDocument/ns1:Document/ns1:CstmrCdtTrfInitn/ns1:PmtInf/ns1:PmtMtd", xml);
		assertXpathEvaluatesTo("URGP", "/ns:SignableDocument/ns1:Document/ns1:CstmrCdtTrfInitn/ns1:PmtInf/ns1:PmtTpInf/ns1:SvcLvl/ns1:Cd", xml);
		assertXpathEvaluatesTo("2009-06-02T00:00:00.000+03:00", "/ns:SignableDocument/ns1:Document/ns1:CstmrCdtTrfInitn/ns1:PmtInf/ns1:ReqdExctnDt", xml);
		assertXpathEvaluatesTo(row.getPayerName(), "/ns:SignableDocument/ns1:Document/ns1:CstmrCdtTrfInitn/ns1:PmtInf/ns1:Dbtr/ns1:Nm", xml);
		assertXpathEvaluatesTo(row.getPayerId(), "/ns:SignableDocument/ns1:Document/ns1:CstmrCdtTrfInitn/ns1:PmtInf/ns1:Dbtr/ns1:Id/ns1:OrgId/ns1:Othr[1]/ns1:Id", xml);
		assertXpathEvaluatesTo(row.getCustomerCodeInBeneficiaryIs(), "/ns:SignableDocument/ns1:Document/ns1:CstmrCdtTrfInitn/ns1:PmtInf/ns1:Dbtr/ns1:Id/ns1:OrgId/ns1:Othr[2]/ns1:Id", xml);
		assertXpathEvaluatesTo("CUST", "/ns:SignableDocument/ns1:Document/ns1:CstmrCdtTrfInitn/ns1:PmtInf/ns1:Dbtr/ns1:Id/ns1:OrgId/ns1:Othr[2]/ns1:SchmeNm/ns1:Cd", xml);
		assertXpathEvaluatesTo(row.getPayerAccount(), "/ns:SignableDocument/ns1:Document/ns1:CstmrCdtTrfInitn/ns1:PmtInf/ns1:DbtrAcct/ns1:Id/ns1:IBAN", xml);
		assertXpathEvaluatesTo(row.getPayerCreditInstitution(), "/ns:SignableDocument/ns1:Document/ns1:CstmrCdtTrfInitn/ns1:PmtInf/ns1:DbtrAgt/ns1:FinInstnId/ns1:BIC", xml);
		assertXpathEvaluatesTo(row.getOriginatorName(), "/ns:SignableDocument/ns1:Document/ns1:CstmrCdtTrfInitn/ns1:PmtInf/ns1:UltmtDbtr/ns1:Nm", xml);
		assertXpathEvaluatesTo(row.getOriginatorId(), "/ns:SignableDocument/ns1:Document/ns1:CstmrCdtTrfInitn/ns1:PmtInf/ns1:UltmtDbtr/ns1:Id/ns1:OrgId/ns1:Othr[1]/ns1:Id", xml);
		assertXpathEvaluatesTo(row.getOriginatorAccount(), "/ns:SignableDocument/ns1:Document/ns1:CstmrCdtTrfInitn/ns1:PmtInf/ns1:UltmtDbtr/ns1:Id/ns1:OrgId/ns1:Othr[2]/ns1:Id", xml);
		assertXpathEvaluatesTo("IBAN", "/ns:SignableDocument/ns1:Document/ns1:CstmrCdtTrfInitn/ns1:PmtInf/ns1:UltmtDbtr/ns1:Id/ns1:OrgId/ns1:Othr[2]/ns1:SchmeNm/ns1:Prtry", xml);
		
		assertXpathEvaluatesTo(row.getDocumentNumber(), "/ns:SignableDocument/ns1:Document/ns1:CstmrCdtTrfInitn/ns1:PmtInf/ns1:CdtTrfTxInf/ns1:PmtId/ns1:InstrId", xml);
		assertXpathEvaluatesTo(row.getDocumentNumber(), "/ns:SignableDocument/ns1:Document/ns1:CstmrCdtTrfInitn/ns1:PmtInf/ns1:CdtTrfTxInf/ns1:PmtId/ns1:EndToEndId", xml);
		assertXpathEvaluatesTo("166.5", "/ns:SignableDocument/ns1:Document/ns1:CstmrCdtTrfInitn/ns1:PmtInf/ns1:CdtTrfTxInf/ns1:Amt/ns1:InstdAmt", xml);
		assertXpathEvaluatesTo(row.getCurrencyCode(), "/ns:SignableDocument/ns1:Document/ns1:CstmrCdtTrfInitn/ns1:PmtInf/ns1:CdtTrfTxInf/ns1:Amt/ns1:InstdAmt/@Ccy", xml);
		
		assertXpathEvaluatesTo(row.getBenificiaryCreditInsitution(), "/ns:SignableDocument/ns1:Document/ns1:CstmrCdtTrfInitn/ns1:PmtInf/ns1:CdtTrfTxInf/ns1:CdtrAgt/ns1:FinInstnId/ns1:BIC", xml);
		
		assertXpathEvaluatesTo(row.getBenificiaryName(), "/ns:SignableDocument/ns1:Document/ns1:CstmrCdtTrfInitn/ns1:PmtInf/ns1:CdtTrfTxInf/ns1:Cdtr/ns1:Nm", xml);
		assertXpathEvaluatesTo(row.getBenificiaryId(), "/ns:SignableDocument/ns1:Document/ns1:CstmrCdtTrfInitn/ns1:PmtInf/ns1:CdtTrfTxInf/ns1:Cdtr/ns1:Id/ns1:OrgId/ns1:Othr[1]/ns1:Id", xml);
		assertXpathEvaluatesTo(row.getCustomerCodeInPayerIs(), "/ns:SignableDocument/ns1:Document/ns1:CstmrCdtTrfInitn/ns1:PmtInf/ns1:CdtTrfTxInf/ns1:Cdtr/ns1:Id/ns1:OrgId/ns1:Othr[2]/ns1:Id", xml);
		assertXpathEvaluatesTo("CUST", "/ns:SignableDocument/ns1:Document/ns1:CstmrCdtTrfInitn/ns1:PmtInf/ns1:CdtTrfTxInf/ns1:Cdtr/ns1:Id/ns1:OrgId/ns1:Othr[2]/ns1:SchmeNm/ns1:Cd", xml);
		
		assertXpathEvaluatesTo(row.getBenificiaryPartyName(), "/ns:SignableDocument/ns1:Document/ns1:CstmrCdtTrfInitn/ns1:PmtInf/ns1:CdtTrfTxInf/ns1:UltmtCdtr/ns1:Nm", xml);
		assertXpathEvaluatesTo(row.getBenificiaryPartyId(), "/ns:SignableDocument/ns1:Document/ns1:CstmrCdtTrfInitn/ns1:PmtInf/ns1:CdtTrfTxInf/ns1:UltmtCdtr/ns1:Id/ns1:OrgId/ns1:Othr[1]/ns1:Id", xml);
		assertXpathEvaluatesTo(row.getBeneficiaryPartyAccount(), "/ns:SignableDocument/ns1:Document/ns1:CstmrCdtTrfInitn/ns1:PmtInf/ns1:CdtTrfTxInf/ns1:UltmtCdtr/ns1:Id/ns1:OrgId/ns1:Othr[2]/ns1:Id", xml);
		assertXpathEvaluatesTo("IBAN", "/ns:SignableDocument/ns1:Document/ns1:CstmrCdtTrfInitn/ns1:PmtInf/ns1:CdtTrfTxInf/ns1:UltmtCdtr/ns1:Id/ns1:OrgId/ns1:Othr[2]/ns1:SchmeNm/ns1:Prtry", xml);
		
		assertXpathEvaluatesTo(row.getReferenceNo(), "/ns:SignableDocument/ns1:Document/ns1:CstmrCdtTrfInitn/ns1:PmtInf/ns1:CdtTrfTxInf/ns1:Purp", xml);
		assertXpathEvaluatesTo("3", "count(/ns:SignableDocument/ns1:Document/ns1:CstmrCdtTrfInitn/ns1:PmtInf/ns1:CdtTrfTxInf/ns1:RmtInf/ns1:Ustrd)", xml);
	}

	private void marshalLitasEsisToXML(List<LitasPayment> rows, OutputStream stream) {
		CustomerCreditTransferBuilder.serializeToSignableDocumentTypeXML(rows, stream);
	}
}
