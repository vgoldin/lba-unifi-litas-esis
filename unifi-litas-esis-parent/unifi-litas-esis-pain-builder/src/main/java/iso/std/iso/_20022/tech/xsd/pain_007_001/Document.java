
package iso.std.iso._20022.tech.xsd.pain_007_001;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Document complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Document">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CstmrPmtRvsl" type="{urn:iso:std:iso:20022:tech:xsd:pain.007.001.02}CustomerPaymentReversalV02"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Document", propOrder = {
    "cstmrPmtRvsl"
})
public class Document {

    @XmlElement(name = "CstmrPmtRvsl", required = true)
    protected CustomerPaymentReversalV02 cstmrPmtRvsl;

    /**
     * Gets the value of the cstmrPmtRvsl property.
     * 
     * @return
     *     possible object is
     *     {@link CustomerPaymentReversalV02 }
     *     
     */
    public CustomerPaymentReversalV02 getCstmrPmtRvsl() {
        return cstmrPmtRvsl;
    }

    /**
     * Sets the value of the cstmrPmtRvsl property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerPaymentReversalV02 }
     *     
     */
    public void setCstmrPmtRvsl(CustomerPaymentReversalV02 value) {
        this.cstmrPmtRvsl = value;
    }

}
