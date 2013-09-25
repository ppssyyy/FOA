
package cn.edu.nsu.aaa;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "OpenAAASoap", targetNamespace = "http://aaa.nsu.edu.cn/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface OpenAAASoap {


    /**
     * 
     * @param userID
     * @param userIP
     * @param userPW
     * @param token
     * @param openAPIVersion
     * @return
     *     returns cn.edu.nsu.aaa.LoginResultInfo
     */
    @WebMethod(operationName = "Login", action = "http://aaa.nsu.edu.cn/Login")
    @WebResult(name = "LoginResult", targetNamespace = "http://aaa.nsu.edu.cn/")
    @RequestWrapper(localName = "Login", targetNamespace = "http://aaa.nsu.edu.cn/", className = "cn.edu.nsu.aaa.Login")
    @ResponseWrapper(localName = "LoginResponse", targetNamespace = "http://aaa.nsu.edu.cn/", className = "cn.edu.nsu.aaa.LoginResponse")
    public LoginResultInfo login(
        @WebParam(name = "UserID", targetNamespace = "http://aaa.nsu.edu.cn/")
        String userID,
        @WebParam(name = "UserPW", targetNamespace = "http://aaa.nsu.edu.cn/")
        String userPW,
        @WebParam(name = "UserIP", targetNamespace = "http://aaa.nsu.edu.cn/")
        String userIP,
        @WebParam(name = "OpenAPIVersion", targetNamespace = "http://aaa.nsu.edu.cn/")
        String openAPIVersion,
        @WebParam(name = "Token", targetNamespace = "http://aaa.nsu.edu.cn/")
        String token);

    /**
     * 
     * @param userID
     * @param userIP
     * @param userPW
     * @param token
     * @param openAPIVersion
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "LoginJson", action = "http://aaa.nsu.edu.cn/LoginJson")
    @WebResult(name = "LoginJsonResult", targetNamespace = "http://aaa.nsu.edu.cn/")
    @RequestWrapper(localName = "LoginJson", targetNamespace = "http://aaa.nsu.edu.cn/", className = "cn.edu.nsu.aaa.LoginJson")
    @ResponseWrapper(localName = "LoginJsonResponse", targetNamespace = "http://aaa.nsu.edu.cn/", className = "cn.edu.nsu.aaa.LoginJsonResponse")
    public String loginJson(
        @WebParam(name = "UserID", targetNamespace = "http://aaa.nsu.edu.cn/")
        String userID,
        @WebParam(name = "UserPW", targetNamespace = "http://aaa.nsu.edu.cn/")
        String userPW,
        @WebParam(name = "UserIP", targetNamespace = "http://aaa.nsu.edu.cn/")
        String userIP,
        @WebParam(name = "OpenAPIVersion", targetNamespace = "http://aaa.nsu.edu.cn/")
        String openAPIVersion,
        @WebParam(name = "Token", targetNamespace = "http://aaa.nsu.edu.cn/")
        String token);

    /**
     * 
     * @param userID
     * @param token
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "KeepSession", action = "http://aaa.nsu.edu.cn/KeepSession")
    @WebResult(name = "KeepSessionResult", targetNamespace = "http://aaa.nsu.edu.cn/")
    @RequestWrapper(localName = "KeepSession", targetNamespace = "http://aaa.nsu.edu.cn/", className = "cn.edu.nsu.aaa.KeepSession")
    @ResponseWrapper(localName = "KeepSessionResponse", targetNamespace = "http://aaa.nsu.edu.cn/", className = "cn.edu.nsu.aaa.KeepSessionResponse")
    public String keepSession(
        @WebParam(name = "UserID", targetNamespace = "http://aaa.nsu.edu.cn/")
        String userID,
        @WebParam(name = "Token", targetNamespace = "http://aaa.nsu.edu.cn/")
        String token);

    /**
     * 
     * @param userID
     * @param token
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "Logout", action = "http://aaa.nsu.edu.cn/Logout")
    @WebResult(name = "LogoutResult", targetNamespace = "http://aaa.nsu.edu.cn/")
    @RequestWrapper(localName = "Logout", targetNamespace = "http://aaa.nsu.edu.cn/", className = "cn.edu.nsu.aaa.Logout")
    @ResponseWrapper(localName = "LogoutResponse", targetNamespace = "http://aaa.nsu.edu.cn/", className = "cn.edu.nsu.aaa.LogoutResponse")
    public String logout(
        @WebParam(name = "UserID", targetNamespace = "http://aaa.nsu.edu.cn/")
        String userID,
        @WebParam(name = "Token", targetNamespace = "http://aaa.nsu.edu.cn/")
        String token);

    /**
     * 
     * @return
     *     returns byte[]
     */
    @WebMethod(operationName = "GetTokenPictureBytes", action = "http://aaa.nsu.edu.cn/GetTokenPictureBytes")
    @WebResult(name = "GetTokenPictureBytesResult", targetNamespace = "http://aaa.nsu.edu.cn/")
    @RequestWrapper(localName = "GetTokenPictureBytes", targetNamespace = "http://aaa.nsu.edu.cn/", className = "cn.edu.nsu.aaa.GetTokenPictureBytes")
    @ResponseWrapper(localName = "GetTokenPictureBytesResponse", targetNamespace = "http://aaa.nsu.edu.cn/", className = "cn.edu.nsu.aaa.GetTokenPictureBytesResponse")
    public byte[] getTokenPictureBytes();

}
