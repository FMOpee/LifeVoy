package com.fm.lifevoy.v2.generatefeed;

import com.fm.lifevoy.v2.generatefeed.clients.PostClient;
import com.fm.lifevoy.v2.generatefeed.clients.UserClient;
import com.fm.lifevoy.v2.generatefeed.generated.GetFeedRequest;
import com.fm.lifevoy.v2.generatefeed.generated.GetFeedResponse;
import com.fm.lifevoy.v2.generatefeed.generated.Post;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

@Endpoint
public class FeedEndpoint {
    private static final String NAMESPACE_URI = "http://www.fm.com/lifevoy/v2/feed";

    @PayloadRoot(namespace = NAMESPACE_URI,localPart = "GetFeedRequest")
    @ResponsePayload
    public GetFeedResponse getFeed(@RequestPayload GetFeedRequest req) throws IOException, ParserConfigurationException, SAXException {
        String username = req.getUsername();
        List<String> followings = UserClient.getFollowings(username);
        List<Post> posts = PostClient.getFeed(followings);
        GetFeedResponse response = new GetFeedResponse();
        response.getPosts().addAll(posts);
        return response;
    }
}
