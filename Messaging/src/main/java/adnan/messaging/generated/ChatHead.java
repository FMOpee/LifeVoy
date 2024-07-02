
package adnan.messaging.generated;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ChatHead complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ChatHead"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="chatID" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="lastMessage" type="{http://service.messaing}Message"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ChatHead", namespace = "http://service.messaing", propOrder = {
    "chatID",
    "lastMessage"
})
public class ChatHead {

    @XmlElement(namespace = "http://service.messaing")
    protected long chatID;
    @XmlElement(namespace = "http://service.messaing", required = true)
    protected Message lastMessage;

    /**
     * Gets the value of the chatID property.
     * 
     */
    public long getChatID() {
        return chatID;
    }

    /**
     * Sets the value of the chatID property.
     * 
     */
    public void setChatID(long value) {
        this.chatID = value;
    }

    /**
     * Gets the value of the lastMessage property.
     * 
     * @return
     *     possible object is
     *     {@link Message }
     *     
     */
    public Message getLastMessage() {
        return lastMessage;
    }

    /**
     * Sets the value of the lastMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link Message }
     *     
     */
    public void setLastMessage(Message value) {
        this.lastMessage = value;
    }

}
