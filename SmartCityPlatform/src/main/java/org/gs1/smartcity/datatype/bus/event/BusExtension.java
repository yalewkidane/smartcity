//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.11 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2016.10.31 시간 09:05:04 PM KST 
//


package org.gs1.smartcity.datatype.bus.event;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>BusExtension complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="BusExtension"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Registration" type="{http://ns.example.com/epcisapp/bus}BusRegistration" minOccurs="0"/&gt;
 *         &lt;element name="DriverID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="VehicleNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="BusLine" type="{http://ns.example.com/epcisapp/bus}BusLine" minOccurs="0"/&gt;
 *         &lt;element name="Accident" type="{http://ns.example.com/epcisapp/bus}Accident" minOccurs="0"/&gt;
 *         &lt;element name="Maintenance" type="{http://ns.example.com/epcisapp/bus}Maintenance" minOccurs="0"/&gt;
 *         &lt;element name="Mileage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="GPS" type="{http://ns.example.com/epcisapp/bus}GPS" minOccurs="0"/&gt;
 *         &lt;element name="Direction" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BusExtension", propOrder = {
    "registration",
    "driverID",
    "vehicleNumber",
    "busLine",
    "accident",
    "maintenance",
    "mileage",
    "gps",
    "direction"
})
public class BusExtension {

    @XmlElement(name = "Registration")
    protected BusRegistration registration;
    @XmlElement(name = "DriverID")
    protected String driverID;
    @XmlElement(name = "VehicleNumber")
    protected String vehicleNumber;
    @XmlElement(name = "BusLine")
    protected BusLine busLine;
    @XmlElement(name = "Accident")
    protected Accident accident;
    @XmlElement(name = "Maintenance")
    protected Maintenance maintenance;
    @XmlElement(name = "Mileage")
    protected String mileage;
    @XmlElement(name = "GPS")
    protected GPS gps;
    @XmlElement(name = "Direction")
    protected Integer direction;

    /**
     * registration 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BusRegistration }
     *     
     */
    public BusRegistration getRegistration() {
        return registration;
    }

    /**
     * registration 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BusRegistration }
     *     
     */
    public void setRegistration(BusRegistration value) {
        this.registration = value;
    }

    /**
     * driverID 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDriverID() {
        return driverID;
    }

    /**
     * driverID 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDriverID(String value) {
        this.driverID = value;
    }

    /**
     * vehicleNumber 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVehicleNumber() {
        return vehicleNumber;
    }

    /**
     * vehicleNumber 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVehicleNumber(String value) {
        this.vehicleNumber = value;
    }

    /**
     * busLine 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BusLine }
     *     
     */
    public BusLine getBusLine() {
        return busLine;
    }

    /**
     * busLine 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BusLine }
     *     
     */
    public void setBusLine(BusLine value) {
        this.busLine = value;
    }

    /**
     * accident 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Accident }
     *     
     */
    public Accident getAccident() {
        return accident;
    }

    /**
     * accident 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Accident }
     *     
     */
    public void setAccident(Accident value) {
        this.accident = value;
    }

    /**
     * maintenance 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Maintenance }
     *     
     */
    public Maintenance getMaintenance() {
        return maintenance;
    }

    /**
     * maintenance 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Maintenance }
     *     
     */
    public void setMaintenance(Maintenance value) {
        this.maintenance = value;
    }

    /**
     * mileage 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMileage() {
        return mileage;
    }

    /**
     * mileage 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMileage(String value) {
        this.mileage = value;
    }

    /**
     * gps 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link GPS }
     *     
     */
    public GPS getGPS() {
        return gps;
    }

    /**
     * gps 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link GPS }
     *     
     */
    public void setGPS(GPS value) {
        this.gps = value;
    }

    /**
     * direction 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDirection() {
        return direction;
    }

    /**
     * direction 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDirection(Integer value) {
        this.direction = value;
    }

}
