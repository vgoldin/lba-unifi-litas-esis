
package lt.lba.xmlns.unifi.services.foundation.faults.v01;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the lt.lba.xmlns.unifi.services.foundation.faults.v01 package. 
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

    private final static QName _SecurityAssertionFailedFault_QNAME = new QName("urn:lt:lba:xmlns:unifi:services:foundation:faults:V01", "SecurityAssertionFailedFault");
    private final static QName _ServiceTemporarilyUnavailableFault_QNAME = new QName("urn:lt:lba:xmlns:unifi:services:foundation:faults:V01", "ServiceTemporarilyUnavailableFault");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: lt.lba.xmlns.unifi.services.foundation.faults.v01
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TransportFaultType }
     * 
     */
    public TransportFaultType createTransportFaultType() {
        return new TransportFaultType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TransportFaultType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:lt:lba:xmlns:unifi:services:foundation:faults:V01", name = "SecurityAssertionFailedFault")
    public JAXBElement<TransportFaultType> createSecurityAssertionFailedFault(TransportFaultType value) {
        return new JAXBElement<TransportFaultType>(_SecurityAssertionFailedFault_QNAME, TransportFaultType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TransportFaultType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:lt:lba:xmlns:unifi:services:foundation:faults:V01", name = "ServiceTemporarilyUnavailableFault")
    public JAXBElement<TransportFaultType> createServiceTemporarilyUnavailableFault(TransportFaultType value) {
        return new JAXBElement<TransportFaultType>(_ServiceTemporarilyUnavailableFault_QNAME, TransportFaultType.class, null, value);
    }

}
