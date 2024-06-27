package com.fm.lifevoy.v2.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;

@Endpoint
public class PostEndpoint {
    private static final String NAMESPACE_URI="http://fm.com/lifevoy/v2/post";
    private final PostRepository postRepository;

    @Autowired
    public PostEndpoint(PostRepository postRepository){
        this.postRepository=postRepository;
    }

    


}
