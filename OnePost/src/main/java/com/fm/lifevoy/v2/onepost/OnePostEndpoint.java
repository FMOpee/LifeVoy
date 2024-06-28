package com.fm.lifevoy.v2.onepost;

import com.fm.lifevoy.v2.onepost.clients.CommentClient;
import com.fm.lifevoy.v2.onepost.clients.PostClient;
import com.fm.lifevoy.v2.onepost.generated.GetOnePostRequest;
import com.fm.lifevoy.v2.onepost.generated.GetOnePostResponse;
import com.fm.lifevoy.v2.onepost.generated.Post;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

@Endpoint
public class OnePostEndpoint {
    private static final String NAMESPACE_URI = "http://www.fm.com/lifevoy/v2/onepost";

    @PayloadRoot(namespace = NAMESPACE_URI,localPart = "GetOnePostRequest")
    @ResponsePayload
    public GetOnePostResponse getOnePost(@RequestPayload GetOnePostRequest req) throws IOException, ParserConfigurationException, SAXException {
        GetOnePostResponse response = new GetOnePostResponse();
        response.setPost(
                PostClient.getpost(
                        req.getPostID(),
                        CommentClient.getComments(
                                req.getPostID()
                        )
                )
        );
        return response;
    }
}
