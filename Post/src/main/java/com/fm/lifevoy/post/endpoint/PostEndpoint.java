package com.fm.lifevoy.post.endpoint;

import com.fm.lifevoy.post.generated.*;
import com.fm.lifevoy.post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.ArrayList;
import java.util.List;

@Endpoint
public class PostEndpoint {
    private static final String NAMESPACE_URI = "http://www.fm.com/lifevoy/post/generated";
    private final PostRepository postRepository;

    @Autowired
    public PostEndpoint(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI,localPart = "GetFeedRequest")
    @ResponsePayload
    public GetFeedResponse getFeed(@RequestPayload GetFeedRequest request) {
        GetFeedResponse response = new GetFeedResponse();
        List<String> followings = request.getFollowingUsernames();
        List<Post> allPosts = postRepository.getAllPosts();
//        List<Post> feedPosts = new ArrayList<>();
        for (Post p:allPosts) {
            if(followings.contains(p.getPosterUsername())){
                response.getPosts().add(p);
            }
        }
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI,localPart = "GetProfileRequest")
    @ResponsePayload
    public GetProfileResponse getProfile(@RequestPayload GetProfileRequest request) {
        GetProfileResponse response = new GetProfileResponse();
        String username = request.getUsername();
        List<Post> allPosts = postRepository.getAllPosts();
        for (Post p:allPosts) {
            if(username.equals(p.getPosterUsername()))
                response.getPosts().add(p);
        }
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI,localPart = "GetPostRequest")
    @ResponsePayload
    public GetPostResponse getPost(@RequestPayload GetPostRequest request) {
        GetPostResponse response = new GetPostResponse();
        Long postID = request.getPostID();
        Post p = postRepository.getPost(postID);
        response.setPsot(p);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI,localPart = "LikePostRequest")
    @ResponsePayload
    public LikePostResponse likePost(@RequestPayload LikePostRequest request) {
        LikePostResponse response = new LikePostResponse();
        Long postID = request.getPostID();
        String username = request.getRequesterUsername();
        Post p = postRepository.getPost(postID);
        p.getLikers().add(username);
        postRepository.updatePost(p);
        response.setPost(p);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI,localPart = "DislikePostRequest")
    @ResponsePayload
    public DislikePostResponse dislikePost(@RequestPayload DislikePostRequest request) {
        DislikePostResponse response = new DislikePostResponse();
        Long postID = request.getPostID();
        String username = request.getRequesterUsername();
        Post p = postRepository.getPost(postID);
        p.getLikers().remove(username);
        postRepository.updatePost(p);
        response.setPost(p);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI,localPart = "CreatePostRequest")
    @ResponsePayload
    public CreatePostResponse createPost(@RequestPayload CreatePostRequest request) {
        CreatePostResponse response = new CreatePostResponse();
        String username = request.getUsername();
        String text = request.getText();
        Post p = postRepository.createNewPost(username,text);
        response.setPost(p);
        return response;
    }




}
