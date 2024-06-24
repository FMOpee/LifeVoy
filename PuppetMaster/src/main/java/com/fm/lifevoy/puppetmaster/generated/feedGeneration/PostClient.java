
package com.fm.lifevoy.puppetmaster.generated.feedGeneration;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PostClient complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PostClient"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="postID" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="text" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="posterUsername" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="likers" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PostClient", namespace = "http://www.fm.com/lifevoy/task/generated", propOrder = {
    "postID",
    "text",
    "posterUsername",
    "likers"
})
public class PostClient {

    @XmlElement(namespace = "http://www.fm.com/lifevoy/task/generated")
    protected long postID;
    @XmlElement(namespace = "http://www.fm.com/lifevoy/task/generated", required = true)
    protected String text;
    @XmlElement(namespace = "http://www.fm.com/lifevoy/task/generated", required = true)
    protected String posterUsername;
    @XmlElement(namespace = "http://www.fm.com/lifevoy/task/generated", required = true)
    protected List<String> likers;

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
     * Gets the value of the likers property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the likers property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLikers().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getLikers() {
        if (likers == null) {
            likers = new ArrayList<String>();
        }
        return this.likers;
    }

}
