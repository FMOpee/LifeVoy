
package com.fm.lifevoy.puppetmaster.generated.userService;

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
 *         &lt;element name="requesterUsername" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="targetUsername" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
    "requesterUsername",
    "targetUsername"
})
@XmlRootElement(name = "UnfollowUserRequest", namespace = "http://www.fm.com/lifevoy/user/generated")
public class UnfollowUserRequest {

    @XmlElement(namespace = "http://www.fm.com/lifevoy/user/generated", required = true)
    protected String requesterUsername;
    @XmlElement(namespace = "http://www.fm.com/lifevoy/user/generated", required = true)
    protected String targetUsername;

    /**
     * Gets the value of the requesterUsername property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequesterUsername() {
        return requesterUsername;
    }

    /**
     * Sets the value of the requesterUsername property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequesterUsername(String value) {
        this.requesterUsername = value;
    }

    /**
     * Gets the value of the targetUsername property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTargetUsername() {
        return targetUsername;
    }

    /**
     * Sets the value of the targetUsername property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTargetUsername(String value) {
        this.targetUsername = value;
    }

}
