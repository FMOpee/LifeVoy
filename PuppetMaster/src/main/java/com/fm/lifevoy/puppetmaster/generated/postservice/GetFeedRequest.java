
package com.fm.lifevoy.puppetmaster.generated.postservice;

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
 *         &lt;element name="followingUsernames" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/&gt;
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
    "followingUsernames"
})
@XmlRootElement(name = "GetFeedRequest", namespace = "http://www.fm.com/lifevoy/post/generated")
public class GetFeedRequest {

    @XmlElement(namespace = "http://www.fm.com/lifevoy/post/generated", required = true)
    protected List<String> followingUsernames;

    /**
     * Gets the value of the followingUsernames property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the followingUsernames property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFollowingUsernames().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getFollowingUsernames() {
        if (followingUsernames == null) {
            followingUsernames = new ArrayList<String>();
        }
        return this.followingUsernames;
    }

}
