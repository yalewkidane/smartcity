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
 * <p>DriverExtension complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="DriverExtension"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Employed" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Unemployed" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Bus" type="{http://ns.example.com/epcisapp/bus}Bus" minOccurs="0"/&gt;
 *         &lt;element name="Accident" type="{http://ns.example.com/epcisapp/bus}Accident" minOccurs="0"/&gt;
 *         &lt;element name="Rating" type="{http://ns.example.com/epcisapp/bus}Rating" minOccurs="0"/&gt;
 *         &lt;element name="Check-in" type="{http://ns.example.com/epcisapp/bus}Check" minOccurs="0"/&gt;
 *         &lt;element name="Check-out" type="{http://ns.example.com/epcisapp/bus}Check" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DriverExtension", propOrder = {
    "employed",
    "unemployed",
    "bus",
    "accident",
    "rating",
    "checkIn",
    "checkOut"
})
public class DriverExtension {

    @XmlElement(name = "Employed")
    protected String employed;
    @XmlElement(name = "Unemployed")
    protected String unemployed;
    @XmlElement(name = "Bus")
    protected Bus bus;
    @XmlElement(name = "Accident")
    protected Accident accident;
    @XmlElement(name = "Rating")
    protected Rating rating;
    @XmlElement(name = "Check-in")
    protected Check checkIn;
    @XmlElement(name = "Check-out")
    protected Check checkOut;

    /**
     * employed 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmployed() {
        return employed;
    }

    /**
     * employed 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmployed(String value) {
        this.employed = value;
    }

    /**
     * unemployed 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnemployed() {
        return unemployed;
    }

    /**
     * unemployed 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnemployed(String value) {
        this.unemployed = value;
    }

    /**
     * bus 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Bus }
     *     
     */
    public Bus getBus() {
        return bus;
    }

    /**
     * bus 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Bus }
     *     
     */
    public void setBus(Bus value) {
        this.bus = value;
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
     * rating 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Rating }
     *     
     */
    public Rating getRating() {
        return rating;
    }

    /**
     * rating 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Rating }
     *     
     */
    public void setRating(Rating value) {
        this.rating = value;
    }

    /**
     * checkIn 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Check }
     *     
     */
    public Check getCheckIn() {
        return checkIn;
    }

    /**
     * checkIn 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Check }
     *     
     */
    public void setCheckIn(Check value) {
        this.checkIn = value;
    }

    /**
     * checkOut 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Check }
     *     
     */
    public Check getCheckOut() {
        return checkOut;
    }

    /**
     * checkOut 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Check }
     *     
     */
    public void setCheckOut(Check value) {
        this.checkOut = value;
    }

}
