
package adnan.messaging.generated;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="chatlog" type="{http://service.messaing}Chats"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "chatlog"
})
@XmlRootElement(name = "GetChatLogResponse", namespace = "http://service.messaing")
public class GetChatLogResponse {

    @XmlElement(namespace = "http://service.messaing", required = true)
    protected Chats chatlog;

    /**
     * Gets the value of the chatlog property.
     * 
     * @return
     *     possible object is
     *     {@link Chats }
     *     
     */
    public Chats getChatlog() {
        return chatlog;
    }

    /**
     * Sets the value of the chatlog property.
     * 
     * @param value
     *     allowed object is
     *     {@link Chats }
     *     
     */
    public void setChatlog(Chats value) {
        this.chatlog = value;
    }

}
