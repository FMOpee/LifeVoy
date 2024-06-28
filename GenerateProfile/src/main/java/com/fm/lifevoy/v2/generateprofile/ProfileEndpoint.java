package com.fm.lifevoy.v2.generateprofile;

import com.fm.lifevoy.v2.generateprofile.clients.PairOfLong;
import com.fm.lifevoy.v2.generateprofile.clients.PostClient;
import com.fm.lifevoy.v2.generateprofile.clients.UserClient;
import com.fm.lifevoy.v2.generateprofile.generated.GetProfileRequest;
import com.fm.lifevoy.v2.generateprofile.generated.GetProfileResponse;
import com.fm.lifevoy.v2.generateprofile.generated.Post;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Endpoint
public class ProfileEndpoint {
    private static final String NAMESPACE_URI = "http://www.fm.com/lifevoy/v2/profile";

    @PayloadRoot(namespace = NAMESPACE_URI,localPart = "GetProfileRequest")
    @ResponsePayload
    public GetProfileResponse getFeed(@RequestPayload GetProfileRequest req) throws IOException, ParserConfigurationException, SAXException {
        String username = req.getUsername();
        PairOfLong ff = UserClient.getFollowingAndFollowerCount(username);
        List<String> al = new ArrayList<>();
        al.add(username);
        List<Post> posts = PostClient.getFeed(al);
        GetProfileResponse response = new GetProfileResponse();
        response.getPosts().addAll(posts);
        response.setFollowerCount(ff.followerCount);
        response.setFollowingCount(ff.followingCount);
        response.setUsername(username);
        return response;
    }
}
