
package com.fm.lifevoy.v2.generateprofile.generated;

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
 *         &lt;element name="username" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="followerCount" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="followingCount" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="posts" type="{http://www.fm.com/lifevoy/v2/profile}Post" maxOccurs="unbounded"/&gt;
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
    "username",
    "followerCount",
    "followingCount",
    "posts"
})
@XmlRootElement(name = "GetProfileResponse", namespace = "http://www.fm.com/lifevoy/v2/profile")
public class GetProfileResponse {

    @XmlElement(namespace = "http://www.fm.com/lifevoy/v2/profile", required = true)
    protected String username;
    @XmlElement(namespace = "http://www.fm.com/lifevoy/v2/profile")
    protected long followerCount;
    @XmlElement(namespace = "http://www.fm.com/lifevoy/v2/profile")
    protected long followingCount;
    @XmlElement(namespace = "http://www.fm.com/lifevoy/v2/profile", required = true)
    protected List<Post> posts;

    /**
     * Gets the value of the username property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the value of the username property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsername(String value) {
        this.username = value;
    }

    /**
     * Gets the value of the followerCount property.
     * 
     */
    public long getFollowerCount() {
        return followerCount;
    }

    /**
     * Sets the value of the followerCount property.
     * 
     */
    public void setFollowerCount(long value) {
        this.followerCount = value;
    }

    /**
     * Gets the value of the followingCount property.
     * 
     */
    public long getFollowingCount() {
        return followingCount;
    }

    /**
     * Sets the value of the followingCount property.
     * 
     */
    public void setFollowingCount(long value) {
        this.followingCount = value;
    }

    /**
     * Gets the value of the posts property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the posts property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPosts().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Post }
     * 
     * 
     */
    public List<Post> getPosts() {
        if (posts == null) {
            posts = new ArrayList<Post>();
        }
        return this.posts;
    }

}
