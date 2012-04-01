package lt.itdbaltics.unifi.gateway.pain;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.custommonkey.xmlunit.*;

public class CustomerCreditTransferDataFormatTest extends XMLTestCase {
	private Map<String, String> row;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		
		HashMap<String, String> ns = new HashMap<String, String>();
		ns.put("ns", "http://www.lba.lt/xmlns/2011/11/unifi/CustomerCreditTransferInitiation/V03");
		ns.put("ns1", "urn:iso:std:iso:20022:tech:xsd:pain.001.001.03");
		
		NamespaceContext ctx = new SimpleNamespaceContext(ns);
		XMLUnit.setXpathNamespaceContext(ctx);
		
		row = new HashMap<String, String>();

		row.put(Columns.CdtTrfTxInfPmtId, "180");
		row.put(Columns.ReqdExctnDt, "20090602");
		row.put(Columns.PmtTpInfInstrPrty, "2");
		row.put(Columns.DbtrAcctIdIBAN, "LT137044060005294027");
		row.put(Columns.DbtrNm, "UAB \"BALTIJOS PAáARAI\"");
		row.put(Columns.DbtrIdOtherId, "300530635");
		row.put(Columns.DbtrAgtFinInstnIdBIC, "70440");
		row.put(Columns.DbtrIdOtherIdCUST, "CUST_CODE");
		row.put(Columns.UltmtDbtrIdOtherIdIBAN, "LT827044060004726595");
		row.put(Columns.UltmtDbtrNm, "My Ultimate Debtor");
		row.put(Columns.UltmtDbtrIdOtherId, "1234567");
		row.put(Columns.CdtrAcctIdIBAN, "LT827044060004726596");
		row.put(Columns.CdtrNm, "BALDö SIMFONIJA UAB");
		row.put(Columns.CdtrIdOtherId, "300092959");
		row.put(Columns.CdtrAgtFinInstnIdBIC, "70440");
		row.put(Columns.CdtrIdOtherIdCUST, "CUST_CODE");
		row.put(Columns.UltmtCdtrIdOtherIdIBAN, "LT827044060004726594");
		row.put(Columns.UltmtCdtrNm, "My Ultimate Creditor");
		row.put(Columns.UltmtCdtrIdOtherId, "1234567");
		row.put(Columns.AmtInstdAmt, "16650");
		row.put(Columns.AmtInstdAmtCcy, "LTL");
		row.put(Columns.PurpPrtry, "1001");
		row.put(Columns.RmtInfUstrd, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut ut tortor a lorem faucibus auctor pharetra sed sem. Praesent et arcu non quam suscipit lobortis. Nullam congue neque a enim ornare ultrices. Pellentesque nisi felis, molestie a suscipit ac, pellentesque porta elit. Nulla pulvinar cras amet.");
	}
	
	@Test
	public void testMarshal() throws Exception {
		List<Map<String, String>> rows = new ArrayList<Map<String, String>>();
		rows.add(row);

		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		marshalLitasEsisToXML(rows, stream);
		
		String xml = stream.toString("UTF-8");
		
		assertXpathEvaluatesTo(Integer.toString(rows.size()), "/ns:SignableDocument/ns1:Document/ns1:CstmrCdtTrfInitn/ns1:GrpHdr/ns1:NbOfTxs", xml);
		assertXpathEvaluatesTo("TRF", "/ns:SignableDocument/ns1:Document/ns1:CstmrCdtTrfInitn/ns1:PmtInf/ns1:PmtMtd", xml);
		assertXpathEvaluatesTo("URGP", "/ns:SignableDocument/ns1:Document/ns1:CstmrCdtTrfInitn/ns1:PmtInf/ns1:PmtTpInf/ns1:SvcLvl/ns1:Cd", xml);
		assertXpathEvaluatesTo("2009-06-02T00:00:00.000+03:00", "/ns:SignableDocument/ns1:Document/ns1:CstmrCdtTrfInitn/ns1:PmtInf/ns1:ReqdExctnDt", xml);
		assertXpathEvaluatesTo(row.get(Columns.DbtrNm), "/ns:SignableDocument/ns1:Document/ns1:CstmrCdtTrfInitn/ns1:PmtInf/ns1:Dbtr/ns1:Nm", xml);
		assertXpathEvaluatesTo(row.get(Columns.DbtrIdOtherId), "/ns:SignableDocument/ns1:Document/ns1:CstmrCdtTrfInitn/ns1:PmtInf/ns1:Dbtr/ns1:Id/ns1:OrgId/ns1:Othr[1]/ns1:Id", xml);
		assertXpathEvaluatesTo(row.get(Columns.DbtrIdOtherIdCUST), "/ns:SignableDocument/ns1:Document/ns1:CstmrCdtTrfInitn/ns1:PmtInf/ns1:Dbtr/ns1:Id/ns1:OrgId/ns1:Othr[2]/ns1:Id", xml);
		assertXpathEvaluatesTo("CUST", "/ns:SignableDocument/ns1:Document/ns1:CstmrCdtTrfInitn/ns1:PmtInf/ns1:Dbtr/ns1:Id/ns1:OrgId/ns1:Othr[2]/ns1:SchmeNm/ns1:Cd", xml);
		assertXpathEvaluatesTo(row.get(Columns.DbtrAcctIdIBAN), "/ns:SignableDocument/ns1:Document/ns1:CstmrCdtTrfInitn/ns1:PmtInf/ns1:DbtrAcct/ns1:Id/ns1:IBAN", xml);
		assertXpathEvaluatesTo(row.get(Columns.DbtrAgtFinInstnIdBIC), "/ns:SignableDocument/ns1:Document/ns1:CstmrCdtTrfInitn/ns1:PmtInf/ns1:DbtrAgt/ns1:FinInstnId/ns1:BIC", xml);
		assertXpathEvaluatesTo(row.get(Columns.UltmtDbtrNm), "/ns:SignableDocument/ns1:Document/ns1:CstmrCdtTrfInitn/ns1:PmtInf/ns1:UltmtDbtr/ns1:Nm", xml);
		assertXpathEvaluatesTo(row.get(Columns.UltmtDbtrIdOtherId), "/ns:SignableDocument/ns1:Document/ns1:CstmrCdtTrfInitn/ns1:PmtInf/ns1:UltmtDbtr/ns1:Id/ns1:OrgId/ns1:Othr[1]/ns1:Id", xml);
		assertXpathEvaluatesTo(row.get(Columns.UltmtDbtrIdOtherIdIBAN), "/ns:SignableDocument/ns1:Document/ns1:CstmrCdtTrfInitn/ns1:PmtInf/ns1:UltmtDbtr/ns1:Id/ns1:OrgId/ns1:Othr[2]/ns1:Id", xml);
		assertXpathEvaluatesTo("IBAN", "/ns:SignableDocument/ns1:Document/ns1:CstmrCdtTrfInitn/ns1:PmtInf/ns1:UltmtDbtr/ns1:Id/ns1:OrgId/ns1:Othr[2]/ns1:SchmeNm/ns1:Prtry", xml);
		
		assertXpathEvaluatesTo(row.get(Columns.CdtTrfTxInfPmtId), "/ns:SignableDocument/ns1:Document/ns1:CstmrCdtTrfInitn/ns1:PmtInf/ns1:CdtTrfTxInf/ns1:PmtId/ns1:InstrId", xml);
		assertXpathEvaluatesTo(row.get(Columns.CdtTrfTxInfPmtId), "/ns:SignableDocument/ns1:Document/ns1:CstmrCdtTrfInitn/ns1:PmtInf/ns1:CdtTrfTxInf/ns1:PmtId/ns1:EndToEndId", xml);
		assertXpathEvaluatesTo(row.get(Columns.CdtTrfTxInfPmtId), "/ns:SignableDocument/ns1:Document/ns1:CstmrCdtTrfInitn/ns1:PmtInf/ns1:CdtTrfTxInf/ns1:PmtId/ns1:EndToEndId", xml);
		assertXpathEvaluatesTo("166.5", "/ns:SignableDocument/ns1:Document/ns1:CstmrCdtTrfInitn/ns1:PmtInf/ns1:CdtTrfTxInf/ns1:Amt/ns1:InstdAmt", xml);
		assertXpathEvaluatesTo(row.get(Columns.AmtInstdAmtCcy), "/ns:SignableDocument/ns1:Document/ns1:CstmrCdtTrfInitn/ns1:PmtInf/ns1:CdtTrfTxInf/ns1:Amt/ns1:InstdAmt/@Ccy", xml);
		
		assertXpathEvaluatesTo(row.get(Columns.CdtrAgtFinInstnIdBIC), "/ns:SignableDocument/ns1:Document/ns1:CstmrCdtTrfInitn/ns1:PmtInf/ns1:CdtTrfTxInf/ns1:CdtrAgt/ns1:FinInstnId/ns1:BIC", xml);
		
		assertXpathEvaluatesTo(row.get(Columns.CdtrNm), "/ns:SignableDocument/ns1:Document/ns1:CstmrCdtTrfInitn/ns1:PmtInf/ns1:CdtTrfTxInf/ns1:Cdtr/ns1:Nm", xml);
		assertXpathEvaluatesTo(row.get(Columns.CdtrIdOtherId), "/ns:SignableDocument/ns1:Document/ns1:CstmrCdtTrfInitn/ns1:PmtInf/ns1:CdtTrfTxInf/ns1:Cdtr/ns1:Id/ns1:OrgId/ns1:Othr[1]/ns1:Id", xml);
		assertXpathEvaluatesTo(row.get(Columns.CdtrIdOtherIdCUST), "/ns:SignableDocument/ns1:Document/ns1:CstmrCdtTrfInitn/ns1:PmtInf/ns1:CdtTrfTxInf/ns1:Cdtr/ns1:Id/ns1:OrgId/ns1:Othr[2]/ns1:Id", xml);
		assertXpathEvaluatesTo("CUST", "/ns:SignableDocument/ns1:Document/ns1:CstmrCdtTrfInitn/ns1:PmtInf/ns1:CdtTrfTxInf/ns1:Cdtr/ns1:Id/ns1:OrgId/ns1:Othr[2]/ns1:SchmeNm/ns1:Cd", xml);
		
		assertXpathEvaluatesTo(row.get(Columns.UltmtCdtrNm), "/ns:SignableDocument/ns1:Document/ns1:CstmrCdtTrfInitn/ns1:PmtInf/ns1:CdtTrfTxInf/ns1:UltmtCdtr/ns1:Nm", xml);
		assertXpathEvaluatesTo(row.get(Columns.UltmtCdtrIdOtherId), "/ns:SignableDocument/ns1:Document/ns1:CstmrCdtTrfInitn/ns1:PmtInf/ns1:CdtTrfTxInf/ns1:UltmtCdtr/ns1:Id/ns1:OrgId/ns1:Othr[1]/ns1:Id", xml);
		assertXpathEvaluatesTo(row.get(Columns.UltmtCdtrIdOtherIdIBAN), "/ns:SignableDocument/ns1:Document/ns1:CstmrCdtTrfInitn/ns1:PmtInf/ns1:CdtTrfTxInf/ns1:UltmtCdtr/ns1:Id/ns1:OrgId/ns1:Othr[2]/ns1:Id", xml);
		assertXpathEvaluatesTo("IBAN", "/ns:SignableDocument/ns1:Document/ns1:CstmrCdtTrfInitn/ns1:PmtInf/ns1:CdtTrfTxInf/ns1:UltmtCdtr/ns1:Id/ns1:OrgId/ns1:Othr[2]/ns1:SchmeNm/ns1:Prtry", xml);
		
		assertXpathEvaluatesTo(row.get(Columns.PurpPrtry), "/ns:SignableDocument/ns1:Document/ns1:CstmrCdtTrfInitn/ns1:PmtInf/ns1:CdtTrfTxInf/ns1:Purp", xml);
		assertXpathEvaluatesTo("3", "count(/ns:SignableDocument/ns1:Document/ns1:CstmrCdtTrfInitn/ns1:PmtInf/ns1:CdtTrfTxInf/ns1:RmtInf/ns1:Ustrd)", xml);
	}

	private void marshalLitasEsisToXML(List<Map<String, String>> rows, OutputStream stream) {
		CustomerCreditTransferDataFormat format = new CustomerCreditTransferDataFormat();
		try {
			format.marshal(null, rows, stream);
		} catch (Exception e) {
			e.printStackTrace();
			
			fail(e.getMessage());
		}
	}
}
