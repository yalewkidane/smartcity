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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>BusIntervalType complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="BusIntervalType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Interval" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="IntervalNrom" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="IntervalPeak" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="IntervalHoli" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="IntervalSat" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="IntervalSun" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BusIntervalType", propOrder = {
    "interval",
    "intervalNorm",
    "intervalPeak",
    "intervalHoli",
    "intervalSat",
    "intervalSun"
})
@XmlRootElement
public class BusIntervalType {

    @XmlElement(name = "Interval")
    protected String interval;
    @XmlElement(name = "IntervalNorm")
    protected String intervalNorm;
    @XmlElement(name = "IntervalPeak")
    protected String intervalPeak;
    @XmlElement(name = "IntervalHoli")
    protected String intervalHoli;
    @XmlElement(name = "IntervalSat")
    protected String intervalSat;
    @XmlElement(name = "IntervalSun")
    protected String intervalSun;

    /**
     * interval 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInterval() {
        return interval;
    }

    /**
     * interval 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInterval(String value) {
        this.interval = value;
    }

    /**
     * intervalNrom 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIntervalNorm() {
        return intervalNorm;
    }

    /**
     * intervalNrom 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIntervalNorm(String value) {
        this.intervalNorm = value;
    }

    /**
     * intervalPeak 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIntervalPeak() {
        return intervalPeak;
    }

    /**
     * intervalPeak 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIntervalPeak(String value) {
        this.intervalPeak = value;
    }
    
    /**
     * intervalHoli 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIntervalHoli() {
        return intervalHoli;
    }

    /**
     * intervalHoli 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIntervalHoli(String value) {
        this.intervalHoli = value;
    }

    /**
     * intervalSat 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIntervalSat() {
        return intervalSat;
    }

    /**
     * intervalSat 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIntervalSat(String value) {
        this.intervalSat = value;
    }

    /**
     * intervalSun 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIntervalSun() {
        return intervalSun;
    }

    /**
     * intervalSun 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIntervalSun(String value) {
        this.intervalSun = value;
    }

}
