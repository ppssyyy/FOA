
package cn.edu.nsu.aaa;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the cn.edu.nsu.aaa package. 
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


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: cn.edu.nsu.aaa
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link KeepSession }
     * 
     */
    public KeepSession createKeepSession() {
        return new KeepSession();
    }

    /**
     * Create an instance of {@link Login }
     * 
     */
    public Login createLogin() {
        return new Login();
    }

    /**
     * Create an instance of {@link LoginJson }
     * 
     */
    public LoginJson createLoginJson() {
        return new LoginJson();
    }

    /**
     * Create an instance of {@link LogoutResponse }
     * 
     */
    public LogoutResponse createLogoutResponse() {
        return new LogoutResponse();
    }

    /**
     * Create an instance of {@link GetTokenPictureBytesResponse }
     * 
     */
    public GetTokenPictureBytesResponse createGetTokenPictureBytesResponse() {
        return new GetTokenPictureBytesResponse();
    }

    /**
     * Create an instance of {@link GetTokenPictureBytes }
     * 
     */
    public GetTokenPictureBytes createGetTokenPictureBytes() {
        return new GetTokenPictureBytes();
    }

    /**
     * Create an instance of {@link LoginJsonResponse }
     * 
     */
    public LoginJsonResponse createLoginJsonResponse() {
        return new LoginJsonResponse();
    }

    /**
     * Create an instance of {@link Logout }
     * 
     */
    public Logout createLogout() {
        return new Logout();
    }

    /**
     * Create an instance of {@link LoginResponse }
     * 
     */
    public LoginResponse createLoginResponse() {
        return new LoginResponse();
    }

    /**
     * Create an instance of {@link LoginResultInfo }
     * 
     */
    public LoginResultInfo createLoginResultInfo() {
        return new LoginResultInfo();
    }

    /**
     * Create an instance of {@link KeepSessionResponse }
     * 
     */
    public KeepSessionResponse createKeepSessionResponse() {
        return new KeepSessionResponse();
    }

}
