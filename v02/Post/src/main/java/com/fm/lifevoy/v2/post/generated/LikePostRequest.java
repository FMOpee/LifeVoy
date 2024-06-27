
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
 *         &lt;element name="postID" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="requesterUsername" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
    "postID",
    "requesterUsername"
})
@XmlRootElement(name = "LikePostRequest", namespace = "http://fm.com/lifevoy/v2/post")
public class LikePostRequest {

    @XmlElement(namespace = "http://fm.com/lifevoy/v2/post")
    protected long postID;
    @XmlElement(namespace = "http://fm.com/lifevoy/v2/post", required = true)
    protected String requesterUsername;

    /**
     * Gets the value of the postID property.
     * 
     */
    public long getPostID() {
        return postID;
    }

    /**
     * Sets the value of the postID property.
     * 
     */
    public void setPostID(long value) {
        this.postID = value;
    }

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

}
