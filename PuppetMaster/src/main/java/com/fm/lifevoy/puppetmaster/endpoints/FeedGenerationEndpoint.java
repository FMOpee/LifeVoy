package com.fm.lifevoy.puppetmaster.endpoints;

import com.fm.lifevoy.puppetmaster.client.PostServiceClient;
import com.fm.lifevoy.puppetmaster.client.UserClient;
import com.fm.lifevoy.puppetmaster.generated.feedGeneration.FeedGenerationRequest;
import com.fm.lifevoy.puppetmaster.generated.feedGeneration.FeedGenerationResponse;
import com.fm.lifevoy.puppetmaster.generated.feedGeneration.PostClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;

@Endpoint
public class FeedGenerationEndpoint {
    private static final String NAMESPACE_URI = "http://www.fm.com/lifevoy/task/generated";
    private static UserClient userClient;
    private static PostServiceClient postServiceClient;

    @Autowired
    public FeedGenerationEndpoint(UserClient userClient, PostServiceClient postServiceClient) {
        this.userClient = userClient;
        this.postServiceClient = postServiceClient;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "FeedGenerationRequest")
    @ResponsePayload
    public FeedGenerationResponse getFeed(@RequestPayload FeedGenerationRequest request) {
        String username = request.getUsername();
        List<String> followings = userClient.getFollowings(username);
        List<PostClient> posts = postServiceClient.getFeed(followings);
        FeedGenerationResponse response = new FeedGenerationResponse();
        response.getPosts().addAll(posts);
        return response;
    }
}
