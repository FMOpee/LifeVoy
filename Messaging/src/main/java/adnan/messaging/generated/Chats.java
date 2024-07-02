
package adnan.messaging.generated;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Chats complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Chats"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="chatID" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="senders" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/&gt;
 *         &lt;element name="messages" type="{http://service.messaing}Message" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Chats", namespace = "http://service.messaing", propOrder = {
    "chatID",
    "senders",
    "messages"
})
public class Chats {

    @XmlElement(namespace = "http://service.messaing")
    protected long chatID;
    @XmlElement(namespace = "http://service.messaing", required = true)
    protected List<String> senders;
    @XmlElement(namespace = "http://service.messaing", required = true)
    protected List<Message> messages;

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
     * Gets the value of the senders property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the senders property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSenders().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getSenders() {
        if (senders == null) {
            senders = new ArrayList<String>();
        }
        return this.senders;
    }

    /**
     * Gets the value of the messages property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the messages property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMessages().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Message }
     * 
     * 
     */
    public List<Message> getMessages() {
        if (messages == null) {
            messages = new ArrayList<Message>();
        }
        return this.messages;
    }

}
