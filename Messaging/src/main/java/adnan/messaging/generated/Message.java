
package adnan.messaging.generated;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Message complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Message"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="senderUsername" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="chatID" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="text" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="timestamp" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Message", namespace = "http://service.messaing", propOrder = {
    "senderUsername",
    "chatID",
    "text",
    "timestamp"
})
public class Message {

    @XmlElement(namespace = "http://service.messaing", required = true)
    protected String senderUsername;
    @XmlElement(namespace = "http://service.messaing")
    protected long chatID;
    @XmlElement(namespace = "http://service.messaing", required = true)
    protected String text;
    @XmlElement(namespace = "http://service.messaing")
    protected long timestamp;

    /**
     * Gets the value of the senderUsername property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSenderUsername() {
        return senderUsername;
    }

    /**
     * Sets the value of the senderUsername property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSenderUsername(String value) {
        this.senderUsername = value;
    }

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
     * Gets the value of the text property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getText() {
        return text;
    }

    /**
     * Sets the value of the text property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setText(String value) {
        this.text = value;
    }

    /**
     * Gets the value of the timestamp property.
     * 
     */
    public long getTimestamp() {
        return timestamp;
    }

    /**
     * Sets the value of the timestamp property.
     * 
     */
    public void setTimestamp(long value) {
        this.timestamp = value;
    }

}
