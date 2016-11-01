//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.11 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2016.10.31 시간 09:05:04 PM KST 
//


package org.gs1.smartcity.datatype.bus.event;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.gs1.smartcity.datatype.event package. 
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

    private final static QName _BusExtension_QNAME = new QName("http://ns.example.com/epcisapp/bus", "BusExtension");
    private final static QName _DriverExtension_QNAME = new QName("http://ns.example.com/epcisapp/bus", "DriverExtension");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.gs1.smartcity.datatype.event
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link BusExtension }
     * 
     */
    public BusExtension createBusExtension() {
        return new BusExtension();
    }

    /**
     * Create an instance of {@link DriverExtension }
     * 
     */
    public DriverExtension createDriverExtension() {
        return new DriverExtension();
    }

    /**
     * Create an instance of {@link BusRegistration }
     * 
     */
    public BusRegistration createBusRegistration() {
        return new BusRegistration();
    }

    /**
     * Create an instance of {@link BusLine }
     * 
     */
    public BusLine createBusLine() {
        return new BusLine();
    }

    /**
     * Create an instance of {@link Accident }
     * 
     */
    public Accident createAccident() {
        return new Accident();
    }

    /**
     * Create an instance of {@link Maintenance }
     * 
     */
    public Maintenance createMaintenance() {
        return new Maintenance();
    }

    /**
     * Create an instance of {@link GPS }
     * 
     */
    public GPS createGPS() {
        return new GPS();
    }

    /**
     * Create an instance of {@link Bus }
     * 
     */
    public Bus createBus() {
        return new Bus();
    }

    /**
     * Create an instance of {@link Rating }
     * 
     */
    public Rating createRating() {
        return new Rating();
    }

    /**
     * Create an instance of {@link Check }
     * 
     */
    public Check createCheck() {
        return new Check();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BusExtension }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ns.example.com/epcisapp/bus", name = "BusExtension")
    public JAXBElement<BusExtension> createBusExtension(BusExtension value) {
        return new JAXBElement<BusExtension>(_BusExtension_QNAME, BusExtension.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DriverExtension }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ns.example.com/epcisapp/bus", name = "DriverExtension")
    public JAXBElement<DriverExtension> createDriverExtension(DriverExtension value) {
        return new JAXBElement<DriverExtension>(_DriverExtension_QNAME, DriverExtension.class, null, value);
    }

}
