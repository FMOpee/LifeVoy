
package adnan.messaging.generated;

import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element name="chatheads" type="{http://service.messaing}ChatHead" maxOccurs="unbounded"/&gt;
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
    "chatheads"
})
@XmlRootElement(name = "GetListOfChatsResponse", namespace = "http://service.messaing")
public class GetListOfChatsResponse {

    @XmlElement(namespace = "http://service.messaing", required = true)
    protected List<ChatHead> chatheads;

    /**
     * Gets the value of the chatheads property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the chatheads property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getChatheads().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ChatHead }
     * 
     * 
     */
    public List<ChatHead> getChatheads() {
        if (chatheads == null) {
            chatheads = new ArrayList<ChatHead>();
        }
        return this.chatheads;
    }

}
