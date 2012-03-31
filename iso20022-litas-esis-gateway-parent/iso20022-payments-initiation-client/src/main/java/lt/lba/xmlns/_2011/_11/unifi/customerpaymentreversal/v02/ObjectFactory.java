
package lt.lba.xmlns._2011._11.unifi.customerpaymentreversal.v02;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the lt.lba.xmlns._2011._11.unifi.customerpaymentreversal.v02 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SignableDocument_QNAME = new QName("http://www.lba.lt/xmlns/2011/11/unifi/CustomerPaymentReversal/V02", "SignableDocument");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: lt.lba.xmlns._2011._11.unifi.customerpaymentreversal.v02
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SignableDocumentType }
     * 
     */
    public SignableDocumentType createSignableDocumentType() {
        return new SignableDocumentType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SignableDocumentType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.lba.lt/xmlns/2011/11/unifi/CustomerPaymentReversal/V02", name = "SignableDocument")
    public JAXBElement<SignableDocumentType> createSignableDocument(SignableDocumentType value) {
        return new JAXBElement<SignableDocumentType>(_SignableDocument_QNAME, SignableDocumentType.class, null, value);
    }

}
