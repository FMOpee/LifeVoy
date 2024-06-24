
package com.fm.lifevoy.post.generated;

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
 *         &lt;element name="psot" type="{http://www.fm.com/lifevoy/post/generated}Post"/&gt;
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
    "psot"
})
@XmlRootElement(name = "GetPostResponse", namespace = "http://www.fm.com/lifevoy/post/generated")
public class GetPostResponse {

    @XmlElement(namespace = "http://www.fm.com/lifevoy/post/generated", required = true)
    protected Post psot;

    /**
     * Gets the value of the psot property.
     * 
     * @return
     *     possible object is
     *     {@link Post }
     *     
     */
    public Post getPsot() {
        return psot;
    }

    /**
     * Sets the value of the psot property.
     * 
     * @param value
     *     allowed object is
     *     {@link Post }
     *     
     */
    public void setPsot(Post value) {
        this.psot = value;
    }

}
