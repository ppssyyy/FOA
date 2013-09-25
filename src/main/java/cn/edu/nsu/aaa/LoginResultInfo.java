
package cn.edu.nsu.aaa;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for LoginResultInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LoginResultInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="NetGroupName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ExpireTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="UserName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Message" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IsLogin" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="IsExpire" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="IsIDPWWrong" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="IsNeedUpdate" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="IsIPInvalid" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="IsDisable" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="IsWrong" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LoginResultInfo", propOrder = {
    "netGroupName",
    "expireTime",
    "userName",
    "message",
    "isLogin",
    "isExpire",
    "isIDPWWrong",
    "isNeedUpdate",
    "isIPInvalid",
    "isDisable",
    "isWrong"
})
public class LoginResultInfo {

    @XmlElement(name = "NetGroupName")
    protected String netGroupName;
    @XmlElement(name = "ExpireTime", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar expireTime;
    @XmlElement(name = "UserName")
    protected String userName;
    @XmlElement(name = "Message")
    protected String message;
    @XmlElement(name = "IsLogin")
    protected boolean isLogin;
    @XmlElement(name = "IsExpire")
    protected boolean isExpire;
    @XmlElement(name = "IsIDPWWrong")
    protected boolean isIDPWWrong;
    @XmlElement(name = "IsNeedUpdate")
    protected boolean isNeedUpdate;
    @XmlElement(name = "IsIPInvalid")
    protected boolean isIPInvalid;
    @XmlElement(name = "IsDisable")
    protected boolean isDisable;
    @XmlElement(name = "IsWrong")
    protected boolean isWrong;

    /**
     * Gets the value of the netGroupName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNetGroupName() {
        return netGroupName;
    }

    /**
     * Sets the value of the netGroupName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNetGroupName(String value) {
        this.netGroupName = value;
    }

    /**
     * Gets the value of the expireTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getExpireTime() {
        return expireTime;
    }

    /**
     * Sets the value of the expireTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setExpireTime(XMLGregorianCalendar value) {
        this.expireTime = value;
    }

    /**
     * Gets the value of the userName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the value of the userName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserName(String value) {
        this.userName = value;
    }

    /**
     * Gets the value of the message property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the value of the message property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessage(String value) {
        this.message = value;
    }

    /**
     * Gets the value of the isLogin property.
     * 
     */
    public boolean isIsLogin() {
        return isLogin;
    }

    /**
     * Sets the value of the isLogin property.
     * 
     */
    public void setIsLogin(boolean value) {
        this.isLogin = value;
    }

    /**
     * Gets the value of the isExpire property.
     * 
     */
    public boolean isIsExpire() {
        return isExpire;
    }

    /**
     * Sets the value of the isExpire property.
     * 
     */
    public void setIsExpire(boolean value) {
        this.isExpire = value;
    }

    /**
     * Gets the value of the isIDPWWrong property.
     * 
     */
    public boolean isIsIDPWWrong() {
        return isIDPWWrong;
    }

    /**
     * Sets the value of the isIDPWWrong property.
     * 
     */
    public void setIsIDPWWrong(boolean value) {
        this.isIDPWWrong = value;
    }

    /**
     * Gets the value of the isNeedUpdate property.
     * 
     */
    public boolean isIsNeedUpdate() {
        return isNeedUpdate;
    }

    /**
     * Sets the value of the isNeedUpdate property.
     * 
     */
    public void setIsNeedUpdate(boolean value) {
        this.isNeedUpdate = value;
    }

    /**
     * Gets the value of the isIPInvalid property.
     * 
     */
    public boolean isIsIPInvalid() {
        return isIPInvalid;
    }

    /**
     * Sets the value of the isIPInvalid property.
     * 
     */
    public void setIsIPInvalid(boolean value) {
        this.isIPInvalid = value;
    }

    /**
     * Gets the value of the isDisable property.
     * 
     */
    public boolean isIsDisable() {
        return isDisable;
    }

    /**
     * Sets the value of the isDisable property.
     * 
     */
    public void setIsDisable(boolean value) {
        this.isDisable = value;
    }

    /**
     * Gets the value of the isWrong property.
     * 
     */
    public boolean isIsWrong() {
        return isWrong;
    }

    /**
     * Sets the value of the isWrong property.
     * 
     */
    public void setIsWrong(boolean value) {
        this.isWrong = value;
    }

}
