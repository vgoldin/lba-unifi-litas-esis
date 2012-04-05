
package iso.std.iso._20022.tech.xsd.pain_002_001;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TransactionIndividualStatus3Code.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TransactionIndividualStatus3Code">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ACTC"/>
 *     &lt;enumeration value="RJCT"/>
 *     &lt;enumeration value="PDNG"/>
 *     &lt;enumeration value="ACCP"/>
 *     &lt;enumeration value="ACSP"/>
 *     &lt;enumeration value="ACSC"/>
 *     &lt;enumeration value="ACWC"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TransactionIndividualStatus3Code")
@XmlEnum
public enum TransactionIndividualStatus3Code {

    ACTC,
    RJCT,
    PDNG,
    ACCP,
    ACSP,
    ACSC,
    ACWC;

    public String value() {
        return name();
    }

    public static TransactionIndividualStatus3Code fromValue(String v) {
        return valueOf(v);
    }

}
