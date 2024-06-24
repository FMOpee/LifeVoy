
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
 *         &lt;element name="targetUser" type="{http://www.fm.com/lifevoy/user/generated}User"/&gt;
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
    "targetUser"
})
@XmlRootElement(name = "UnfollowUserResponse", namespace = "http://www.fm.com/lifevoy/user/generated")
public class UnfollowUserResponse {

    @XmlElement(namespace = "http://www.fm.com/lifevoy/user/generated", required = true)
    protected User targetUser;

    /**
     * Gets the value of the targetUser property.
     * 
     * @return
     *     possible object is
     *     {@link User }
     *     
     */
    public User getTargetUser() {
        return targetUser;
    }

    /**
     * Sets the value of the targetUser property.
     * 
     * @param value
     *     allowed object is
     *     {@link User }
     *     
     */
    public void setTargetUser(User value) {
        this.targetUser = value;
    }

}
