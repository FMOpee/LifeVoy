
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
 *         &lt;element name="post" type="{http://fm.com/lifevoy/v2/post}Post"/&gt;
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
    "post"
})
@XmlRootElement(name = "GetPostUsingIDResponse", namespace = "http://fm.com/lifevoy/v2/post")
public class GetPostUsingIDResponse {

    @XmlElement(namespace = "http://fm.com/lifevoy/v2/post", required = true)
    protected Post post;

    /**
     * Gets the value of the post property.
     * 
     * @return
     *     possible object is
     *     {@link Post }
     *     
     */
    public Post getPost() {
        return post;
    }

    /**
     * Sets the value of the post property.
     * 
     * @param value
     *     allowed object is
     *     {@link Post }
     *     
     */
    public void setPost(Post value) {
        this.post = value;
    }

}
