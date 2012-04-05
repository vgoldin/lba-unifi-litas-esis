
package iso.std.iso._20022.tech.xsd.pain_002_001;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SettlementInformation13 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SettlementInformation13">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SttlmMtd" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.03}SettlementMethod1Code"/>
 *         &lt;element name="SttlmAcct" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.03}CashAccount16" minOccurs="0"/>
 *         &lt;element name="ClrSys" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.03}ClearingSystemIdentification3Choice" minOccurs="0"/>
 *         &lt;element name="InstgRmbrsmntAgt" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.03}BranchAndFinancialInstitutionIdentification4" minOccurs="0"/>
 *         &lt;element name="InstgRmbrsmntAgtAcct" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.03}CashAccount16" minOccurs="0"/>
 *         &lt;element name="InstdRmbrsmntAgt" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.03}BranchAndFinancialInstitutionIdentification4" minOccurs="0"/>
 *         &lt;element name="InstdRmbrsmntAgtAcct" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.03}CashAccount16" minOccurs="0"/>
 *         &lt;element name="ThrdRmbrsmntAgt" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.03}BranchAndFinancialInstitutionIdentification4" minOccurs="0"/>
 *         &lt;element name="ThrdRmbrsmntAgtAcct" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.03}CashAccount16" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SettlementInformation13", propOrder = {
    "sttlmMtd",
    "sttlmAcct",
    "clrSys",
    "instgRmbrsmntAgt",
    "instgRmbrsmntAgtAcct",
    "instdRmbrsmntAgt",
    "instdRmbrsmntAgtAcct",
    "thrdRmbrsmntAgt",
    "thrdRmbrsmntAgtAcct"
})
public class SettlementInformation13 {

    @XmlElement(name = "SttlmMtd", required = true)
    protected SettlementMethod1Code sttlmMtd;
    @XmlElement(name = "SttlmAcct")
    protected CashAccount16 sttlmAcct;
    @XmlElement(name = "ClrSys")
    protected ClearingSystemIdentification3Choice clrSys;
    @XmlElement(name = "InstgRmbrsmntAgt")
    protected BranchAndFinancialInstitutionIdentification4 instgRmbrsmntAgt;
    @XmlElement(name = "InstgRmbrsmntAgtAcct")
    protected CashAccount16 instgRmbrsmntAgtAcct;
    @XmlElement(name = "InstdRmbrsmntAgt")
    protected BranchAndFinancialInstitutionIdentification4 instdRmbrsmntAgt;
    @XmlElement(name = "InstdRmbrsmntAgtAcct")
    protected CashAccount16 instdRmbrsmntAgtAcct;
    @XmlElement(name = "ThrdRmbrsmntAgt")
    protected BranchAndFinancialInstitutionIdentification4 thrdRmbrsmntAgt;
    @XmlElement(name = "ThrdRmbrsmntAgtAcct")
    protected CashAccount16 thrdRmbrsmntAgtAcct;

    /**
     * Gets the value of the sttlmMtd property.
     * 
     * @return
     *     possible object is
     *     {@link SettlementMethod1Code }
     *     
     */
    public SettlementMethod1Code getSttlmMtd() {
        return sttlmMtd;
    }

    /**
     * Sets the value of the sttlmMtd property.
     * 
     * @param value
     *     allowed object is
     *     {@link SettlementMethod1Code }
     *     
     */
    public void setSttlmMtd(SettlementMethod1Code value) {
        this.sttlmMtd = value;
    }

    /**
     * Gets the value of the sttlmAcct property.
     * 
     * @return
     *     possible object is
     *     {@link CashAccount16 }
     *     
     */
    public CashAccount16 getSttlmAcct() {
        return sttlmAcct;
    }

    /**
     * Sets the value of the sttlmAcct property.
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount16 }
     *     
     */
    public void setSttlmAcct(CashAccount16 value) {
        this.sttlmAcct = value;
    }

    /**
     * Gets the value of the clrSys property.
     * 
     * @return
     *     possible object is
     *     {@link ClearingSystemIdentification3Choice }
     *     
     */
    public ClearingSystemIdentification3Choice getClrSys() {
        return clrSys;
    }

    /**
     * Sets the value of the clrSys property.
     * 
     * @param value
     *     allowed object is
     *     {@link ClearingSystemIdentification3Choice }
     *     
     */
    public void setClrSys(ClearingSystemIdentification3Choice value) {
        this.clrSys = value;
    }

    /**
     * Gets the value of the instgRmbrsmntAgt property.
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification4 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification4 getInstgRmbrsmntAgt() {
        return instgRmbrsmntAgt;
    }

    /**
     * Sets the value of the instgRmbrsmntAgt property.
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification4 }
     *     
     */
    public void setInstgRmbrsmntAgt(BranchAndFinancialInstitutionIdentification4 value) {
        this.instgRmbrsmntAgt = value;
    }

    /**
     * Gets the value of the instgRmbrsmntAgtAcct property.
     * 
     * @return
     *     possible object is
     *     {@link CashAccount16 }
     *     
     */
    public CashAccount16 getInstgRmbrsmntAgtAcct() {
        return instgRmbrsmntAgtAcct;
    }

    /**
     * Sets the value of the instgRmbrsmntAgtAcct property.
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount16 }
     *     
     */
    public void setInstgRmbrsmntAgtAcct(CashAccount16 value) {
        this.instgRmbrsmntAgtAcct = value;
    }

    /**
     * Gets the value of the instdRmbrsmntAgt property.
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification4 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification4 getInstdRmbrsmntAgt() {
        return instdRmbrsmntAgt;
    }

    /**
     * Sets the value of the instdRmbrsmntAgt property.
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification4 }
     *     
     */
    public void setInstdRmbrsmntAgt(BranchAndFinancialInstitutionIdentification4 value) {
        this.instdRmbrsmntAgt = value;
    }

    /**
     * Gets the value of the instdRmbrsmntAgtAcct property.
     * 
     * @return
     *     possible object is
     *     {@link CashAccount16 }
     *     
     */
    public CashAccount16 getInstdRmbrsmntAgtAcct() {
        return instdRmbrsmntAgtAcct;
    }

    /**
     * Sets the value of the instdRmbrsmntAgtAcct property.
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount16 }
     *     
     */
    public void setInstdRmbrsmntAgtAcct(CashAccount16 value) {
        this.instdRmbrsmntAgtAcct = value;
    }

    /**
     * Gets the value of the thrdRmbrsmntAgt property.
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification4 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification4 getThrdRmbrsmntAgt() {
        return thrdRmbrsmntAgt;
    }

    /**
     * Sets the value of the thrdRmbrsmntAgt property.
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification4 }
     *     
     */
    public void setThrdRmbrsmntAgt(BranchAndFinancialInstitutionIdentification4 value) {
        this.thrdRmbrsmntAgt = value;
    }

    /**
     * Gets the value of the thrdRmbrsmntAgtAcct property.
     * 
     * @return
     *     possible object is
     *     {@link CashAccount16 }
     *     
     */
    public CashAccount16 getThrdRmbrsmntAgtAcct() {
        return thrdRmbrsmntAgtAcct;
    }

    /**
     * Sets the value of the thrdRmbrsmntAgtAcct property.
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount16 }
     *     
     */
    public void setThrdRmbrsmntAgtAcct(CashAccount16 value) {
        this.thrdRmbrsmntAgtAcct = value;
    }

}
