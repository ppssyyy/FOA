
package cn.edu.nsu.aaa;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GetTokenPictureBytesResult" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getTokenPictureBytesResult"
})
@XmlRootElement(name = "GetTokenPictureBytesResponse")
public class GetTokenPictureBytesResponse {

    @XmlElement(name = "GetTokenPictureBytesResult")
    protected byte[] getTokenPictureBytesResult;

    /**
     * Gets the value of the getTokenPictureBytesResult property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getGetTokenPictureBytesResult() {
        return getTokenPictureBytesResult;
    }

    /**
     * Sets the value of the getTokenPictureBytesResult property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setGetTokenPictureBytesResult(byte[] value) {
        this.getTokenPictureBytesResult = value;
    }

}
