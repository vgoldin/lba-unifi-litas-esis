package lt.itdbaltics.unifi;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class LitasPayment {
	@NotNull
	@Size(max=10)
	private String documentNumber;
	
	@Size(min=8, max=8)
	private String date;
	
	@NotNull
	@Size(min=8, max=8)
	private String valueDate;
	
	@NotNull
	@Pattern(regexp="^[1-2]{1}$")
	private String priority;
	
	@NotNull
	@Size(min=20, max=20)
	private String payerAccount;
	
	@NotNull
	@Size(max=200)
	private String payerName;
	
	@Size(max=11)
	private String payerId;
	
	@Size(max=11)
	private String payerCreditInstitution;
	
	@Size(max=16)
	private String customerCodeInBeneficiaryIs;
	
	@Size(max=35)
	private String originatorAccount;
	
	@Size(max=140)
	private String originatorName;
	
	@Size(max=11)
	private String originatorId;
	
	@NotNull
	@Size(max=35)
	private String beneficiaryAccount;
	
	@NotNull
	@Size(max=200)
	private String benificiaryName;
	
	@Size(max=11)
	private String benificiaryId;
	
	@Size(max=11)
	private String benificiaryCreditInsitution;
	
	@Size(max=16)
	private String customerCodeInPayerIs;
	
	@Size(max=35)
	private String beneficiaryPartyAccount;
	
	@Size(max=140)
	private String benificiaryPartyName;
	
	@Size(max=11)
	private String benificiaryPartyId;
	
	
	@NotNull
	@Size(max=14)
	@Pattern(regexp="^\\d+$")	
	private String amount;
	
	@NotNull
	@Size(max=3)
	private String currencyCode;
	
	@Size(max=28)
	private String referenceNo;
	
	@NotNull
	@Size(max=300)
	private String paymentDetails;

	public String getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getValueDate() {
		return valueDate;
	}

	public void setValueDate(String valueDate) {
		this.valueDate = valueDate;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getPayerAccount() {
		return payerAccount;
	}

	public void setPayerAccount(String payerAccount) {
		this.payerAccount = payerAccount;
	}

	public String getPayerName() {
		return payerName;
	}

	public void setPayerName(String payerName) {
		this.payerName = payerName;
	}

	public String getPayerId() {
		return payerId;
	}

	public void setPayerId(String payerId) {
		this.payerId = payerId;
	}

	public String getPayerCreditInstitution() {
		return payerCreditInstitution;
	}

	public void setPayerCreditInstitution(String payerCreditInstitution) {
		this.payerCreditInstitution = payerCreditInstitution;
	}

	public String getCustomerCodeInBeneficiaryIs() {
		return customerCodeInBeneficiaryIs;
	}

	public void setCustomerCodeInBeneficiaryIs(String customerCodeInBeneficiaryIs) {
		this.customerCodeInBeneficiaryIs = customerCodeInBeneficiaryIs;
	}

	public String getOriginatorAccount() {
		return originatorAccount;
	}

	public void setOriginatorAccount(String originatorAccount) {
		this.originatorAccount = originatorAccount;
	}

	public String getOriginatorName() {
		return originatorName;
	}

	public void setOriginatorName(String originatorName) {
		this.originatorName = originatorName;
	}

	public String getOriginatorId() {
		return originatorId;
	}

	public void setOriginatorId(String originatorId) {
		this.originatorId = originatorId;
	}

	public String getBeneficiaryAccount() {
		return beneficiaryAccount;
	}

	public void setBeneficiaryAccount(String beneficiaryAccount) {
		this.beneficiaryAccount = beneficiaryAccount;
	}

	public String getBenificiaryName() {
		return benificiaryName;
	}

	public void setBenificiaryName(String benificiaryName) {
		this.benificiaryName = benificiaryName;
	}

	public String getBenificiaryId() {
		return benificiaryId;
	}

	public void setBenificiaryId(String benificiaryId) {
		this.benificiaryId = benificiaryId;
	}

	public String getBenificiaryCreditInsitution() {
		return benificiaryCreditInsitution;
	}

	public void setBenificiaryCreditInsitution(String benificiaryCreditInsitution) {
		this.benificiaryCreditInsitution = benificiaryCreditInsitution;
	}

	public String getCustomerCodeInPayerIs() {
		return customerCodeInPayerIs;
	}

	public void setCustomerCodeInPayerIs(String customerCodeInPayerIs) {
		this.customerCodeInPayerIs = customerCodeInPayerIs;
	}

	public String getBeneficiaryPartyAccount() {
		return beneficiaryPartyAccount;
	}

	public void setBeneficiaryPartyAccount(String beneficiaryPartyAccount) {
		this.beneficiaryPartyAccount = beneficiaryPartyAccount;
	}

	public String getBenificiaryPartyName() {
		return benificiaryPartyName;
	}

	public void setBenificiaryPartyName(String benificiaryPartyName) {
		this.benificiaryPartyName = benificiaryPartyName;
	}

	public String getBenificiaryPartyId() {
		return benificiaryPartyId;
	}

	public void setBenificiaryPartyId(String benificiaryPartyId) {
		this.benificiaryPartyId = benificiaryPartyId;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getReferenceNo() {
		return referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	public String getPaymentDetails() {
		return paymentDetails;
	}

	public void setPaymentDetails(String paymentDetails) {
		this.paymentDetails = paymentDetails;
	}
}
