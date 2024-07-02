
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
 *         &lt;element name="participant1" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="participant2" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
    "participant1",
    "participant2"
})
@XmlRootElement(name = "GetMessagesRequest", namespace = "http://service.messaing")
public class GetMessagesRequest {

    @XmlElement(namespace = "http://service.messaing", required = true)
    protected String participant1;
    @XmlElement(namespace = "http://service.messaing", required = true)
    protected String participant2;

    /**
     * Gets the value of the participant1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParticipant1() {
        return participant1;
    }

    /**
     * Sets the value of the participant1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParticipant1(String value) {
        this.participant1 = value;
    }

    /**
     * Gets the value of the participant2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParticipant2() {
        return participant2;
    }

    /**
     * Sets the value of the participant2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParticipant2(String value) {
        this.participant2 = value;
    }

}
