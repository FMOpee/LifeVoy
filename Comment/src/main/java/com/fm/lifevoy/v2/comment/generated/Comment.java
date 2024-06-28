
package com.fm.lifevoy.v2.comment.generated;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Comment complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Comment"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="commentID" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="postID" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="commenter" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="text" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="replies" type="{http://fm.com/lifevoy/v2/comment}Reply" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Comment", namespace = "http://fm.com/lifevoy/v2/comment", propOrder = {
    "commentID",
    "postID",
    "commenter",
    "text",
    "replies"
})
public class Comment {

    @XmlElement(namespace = "http://fm.com/lifevoy/v2/comment")
    protected long commentID;
    @XmlElement(namespace = "http://fm.com/lifevoy/v2/comment")
    protected long postID;
    @XmlElement(namespace = "http://fm.com/lifevoy/v2/comment", required = true)
    protected String commenter;
    @XmlElement(namespace = "http://fm.com/lifevoy/v2/comment", required = true)
    protected String text;
    @XmlElement(namespace = "http://fm.com/lifevoy/v2/comment", required = true)
    protected List<Reply> replies;

    /**
     * Gets the value of the commentID property.
     * 
     */
    public long getCommentID() {
        return commentID;
    }

    /**
     * Sets the value of the commentID property.
     * 
     */
    public void setCommentID(long value) {
        this.commentID = value;
    }

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
     * Gets the value of the commenter property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommenter() {
        return commenter;
    }

    /**
     * Sets the value of the commenter property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommenter(String value) {
        this.commenter = value;
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
     * Gets the value of the replies property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the replies property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReplies().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Reply }
     * 
     * 
     */
    public List<Reply> getReplies() {
        if (replies == null) {
            replies = new ArrayList<Reply>();
        }
        return this.replies;
    }

}
