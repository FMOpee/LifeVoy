
package com.fm.lifevoy.puppetmaster.generated.feedGeneration;

import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.fm.lifevoy.puppetmaster.generated.feedGeneration package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.fm.lifevoy.puppetmaster.generated.feedGeneration
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FeedGenerationRequest }
     * 
     */
    public FeedGenerationRequest createFeedGenerationRequest() {
        return new FeedGenerationRequest();
    }

    /**
     * Create an instance of {@link FeedGenerationResponse }
     * 
     */
    public FeedGenerationResponse createFeedGenerationResponse() {
        return new FeedGenerationResponse();
    }

    /**
     * Create an instance of {@link PostClient }
     * 
     */
    public PostClient createPostClient() {
        return new PostClient();
    }

}
