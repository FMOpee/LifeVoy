
package com.fm.lifevoy.user.generated;

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
 *         &lt;element name="followings" type="{http://www.fm.com/lifevoy/user/generated}User" maxOccurs="unbounded"/&gt;
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
    "followings"
})
@XmlRootElement(name = "GetFollowingsResponse", namespace = "http://www.fm.com/lifevoy/user/generated")
public class GetFollowingsResponse {

    @XmlElement(namespace = "http://www.fm.com/lifevoy/user/generated", required = true)
    protected List<User> followings;

    /**
     * Gets the value of the followings property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the followings property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFollowings().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link User }
     * 
     * 
     */
    public List<User> getFollowings() {
        if (followings == null) {
            followings = new ArrayList<User>();
        }
        return this.followings;
    }

}
