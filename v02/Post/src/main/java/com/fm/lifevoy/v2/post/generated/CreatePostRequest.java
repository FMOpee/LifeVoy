
package com.fm.lifevoy.v2.post.generated;

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
 *         &lt;element name="posterUsername" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="text" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
    "posterUsername",
    "text"
})
@XmlRootElement(name = "CreatePostRequest", namespace = "http://fm.com/lifevoy/v2/post")
public class CreatePostRequest {

    @XmlElement(namespace = "http://fm.com/lifevoy/v2/post", required = true)
    protected String posterUsername;
    @XmlElement(namespace = "http://fm.com/lifevoy/v2/post", required = true)
    protected String text;

    /**
     * Gets the value of the posterUsername property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPosterUsername() {
        return posterUsername;
    }

    /**
     * Sets the value of the posterUsername property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPosterUsername(String value) {
        this.posterUsername = value;
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

}
