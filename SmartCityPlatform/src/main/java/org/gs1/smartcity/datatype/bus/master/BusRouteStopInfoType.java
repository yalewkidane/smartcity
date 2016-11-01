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
 * <p>BusRouteStopInfoType complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="BusRouteStopInfoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://ns.example.com/epcisapp/bus}BusStopInfoType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Index" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BusRouteStopInfoType", propOrder = {
    "index"
})
@XmlRootElement(name="BusRouteStop")
public class BusRouteStopInfoType
    extends BusStopInfoType
{

    @XmlElement(name = "Index")
    protected int index;

    /**
     * index 속성의 값을 가져옵니다.
     * 
     */
    public int getIndex() {
        return index;
    }

    /**
     * index 속성의 값을 설정합니다.
     * 
     */
    public void setIndex(int value) {
        this.index = value;
    }

}
