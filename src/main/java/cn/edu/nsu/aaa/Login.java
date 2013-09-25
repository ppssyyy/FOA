
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
 *         &lt;element name="UserID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UserPW" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UserIP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OpenAPIVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Token" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "userID",
    "userPW",
    "userIP",
    "openAPIVersion",
    "token"
})
@XmlRootElement(name = "Login")
public class Login {

    @XmlElement(name = "UserID")
    protected String userID;
    @XmlElement(name = "UserPW")
    protected String userPW;
    @XmlElement(name = "UserIP")
    protected String userIP;
    @XmlElement(name = "OpenAPIVersion")
    protected String openAPIVersion;
    @XmlElement(name = "Token")
    protected String token;

    /**
     * Gets the value of the userID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserID() {
        return userID;
    }

    /**
     * Sets the value of the userID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserID(String value) {
        this.userID = value;
    }

    /**
     * Gets the value of the userPW property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserPW() {
        return userPW;
    }

    /**
     * Sets the value of the userPW property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserPW(String value) {
        this.userPW = value;
    }

    /**
     * Gets the value of the userIP property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserIP() {
        return userIP;
    }

    /**
     * Sets the value of the userIP property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserIP(String value) {
        this.userIP = value;
    }

    /**
     * Gets the value of the openAPIVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOpenAPIVersion() {
        return openAPIVersion;
    }

    /**
     * Sets the value of the openAPIVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOpenAPIVersion(String value) {
        this.openAPIVersion = value;
    }

    /**
     * Gets the value of the token property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToken() {
        return token;
    }

    /**
     * Sets the value of the token property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToken(String value) {
        this.token = value;
    }

}
