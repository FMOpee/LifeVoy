package com.fm.lifevoy.generatefeed.endpoint;

import com.fm.lifevoy.generatefeed.clients.PostClient;
import com.fm.lifevoy.generatefeed.clients.UserClient;
import com.fm.lifevoy.generatefeed.generated.feed.GetFeedRequest;
import com.fm.lifevoy.generatefeed.generated.feed.GetFeedResponse;
import com.fm.lifevoy.generatefeed.generated.feed.Post;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.io.IOException;
import java.util.List;

@Endpoint
public class FeedEndpoint {
    private static final String NAMESPACE_URI = "http://www.fm.com/lifevoy/feed/generated";

    @PayloadRoot(namespace = NAMESPACE_URI,localPart = "GetFeedRequest")
    @ResponsePayload
    public GetFeedResponse getFeed(@RequestPayload GetFeedRequest req) throws IOException {
        String username = req.getUsername();
        List<String> followings = UserClient.getFollowings(username);
        List<Post> posts = PostClient.getFeed(followings);
        GetFeedResponse response = new GetFeedResponse();
        response.getPosts().addAll(posts);
        return response;
    }
}
