
package com.fm.lifevoy.v2.strikechecker.generated;

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
 *         &lt;element name="eligible" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
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
    "eligible"
})
@XmlRootElement(name = "PostEligibilityCheckResponse", namespace = "http://fm.com/lifevoy/v2/strikecheck")
public class PostEligibilityCheckResponse {

    @XmlElement(namespace = "http://fm.com/lifevoy/v2/strikecheck")
    protected boolean eligible;

    /**
     * Gets the value of the eligible property.
     * 
     */
    public boolean isEligible() {
        return eligible;
    }

    /**
     * Sets the value of the eligible property.
     * 
     */
    public void setEligible(boolean value) {
        this.eligible = value;
    }

}
