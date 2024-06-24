package com.fm.lifevoy.puppetmaster.client;

import com.fm.lifevoy.puppetmaster.generated.feedGeneration.PostClient;
import com.fm.lifevoy.puppetmaster.generated.postservice.GetFeedRequest;
import com.fm.lifevoy.puppetmaster.generated.postservice.GetFeedResponse;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostServiceClient {
    private final WebServiceTemplate webServiceTemplate;

//    @Autowired
    public PostServiceClient() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setPackagesToScan("com.fm.lifevoy.puppetmaster.generated.postservice");
        webServiceTemplate = new WebServiceTemplate(marshaller);
    }

    public List<PostClient> getFeed(List<String> followings) {
        GetFeedRequest request = new GetFeedRequest();
        for (String following : followings) {
            request.getFollowingUsernames().add(following);
        }
        GetFeedResponse response =(GetFeedResponse) webServiceTemplate.marshalSendAndReceive(request);
        List<PostClient> posts = new ArrayList<>();
        for (int i=0; i<response.getPosts().size(); i++) {
            PostClient post = new PostClient();
            post.setPostID(response.getPosts().get(i).getPostID());
            post.setText(response.getPosts().get(i).getText());
            post.setPosterUsername(response.getPosts().get(i).getPosterUsername());
            post.getLikers().addAll(response.getPosts().get(i).getLikers());
            posts.add(post);
        }
        return posts;
    }

}
