//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.11 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2016.10.31 시간 09:59:13 PM KST 
//


package org.gs1.smartcity.datatype.bus.master;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>BusStopInfoType complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="BusStopInfoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Gln" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="StopID" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Number" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="NameKR" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="NameEN" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="GpsX" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="GpsY" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Road" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Addr" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Lines" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BusStopInfoType", propOrder = {
    "gln",
    "stopID",
    "number",
    "nameKR",
    "nameEN",
    "gpsX",
    "gpsY",
    "road",
    "addr",
    "lines"
})
@XmlSeeAlso({
    BusRouteStopInfoType.class
})
public class BusStopInfoType {

    @XmlElement(name = "Gln", required = true)
    protected String gln;
    @XmlElement(name = "StopID", required = true)
    protected String stopID;
    @XmlElement(name = "Number", required = true)
    protected String number;
    @XmlElement(name = "NameKR", required = true)
    protected String nameKR;
    @XmlElement(name = "NameEN", required = true)
    protected String nameEN;
    @XmlElement(name = "GpsX", required = true)
    protected String gpsX;
    @XmlElement(name = "GpsY", required = true)
    protected String gpsY;
    @XmlElement(name = "Road", required = true)
    protected String road;
    @XmlElement(name = "Addr", required = true)
    protected String addr;
    @XmlElement(name = "Lines", required = true)
    protected String lines;

    /**
     * gln 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGln() {
        return gln;
    }

    /**
     * gln 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGln(String value) {
        this.gln = value;
    }

    /**
     * stopID 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStopID() {
        return stopID;
    }

    /**
     * stopID 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStopID(String value) {
        this.stopID = value;
    }

    /**
     * number 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumber() {
        return number;
    }

    /**
     * number 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumber(String value) {
        this.number = value;
    }

    /**
     * nameKR 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameKR() {
        return nameKR;
    }

    /**
     * nameKR 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameKR(String value) {
        this.nameKR = value;
    }

    /**
     * nameEN 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameEN() {
        return nameEN;
    }

    /**
     * nameEN 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameEN(String value) {
        this.nameEN = value;
    }

    /**
     * gpsX 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGpsX() {
        return gpsX;
    }

    /**
     * gpsX 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGpsX(String value) {
        this.gpsX = value;
    }

    /**
     * gpsY 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGpsY() {
        return gpsY;
    }

    /**
     * gpsY 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGpsY(String value) {
        this.gpsY = value;
    }

    /**
     * road 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoad() {
        return road;
    }

    /**
     * road 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoad(String value) {
        this.road = value;
    }

    /**
     * addr 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddr() {
        return addr;
    }

    /**
     * addr 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddr(String value) {
        this.addr = value;
    }

    /**
     * lines 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLines() {
        return lines;
    }

    /**
     * lines 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLines(String value) {
        this.lines = value;
    }

}
