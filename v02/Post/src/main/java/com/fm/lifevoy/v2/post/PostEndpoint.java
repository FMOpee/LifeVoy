package com.fm.lifevoy.v2.post;

import com.fm.lifevoy.v2.post.generated.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;

import static com.fm.lifevoy.v2.post.PostEligibilityClient.canPost;

@Endpoint
public class PostEndpoint {
    private static final String NAMESPACE_URI="http://fm.com/lifevoy/v2/post";
    private final PostRepository postRepository;

    @Autowired
    public PostEndpoint(PostRepository postRepository){
        this.postRepository=postRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "CreatePostRequest")
    @ResponsePayload
    public CreatePostResponse createPost(@RequestPayload CreatePostRequest request){
        Post post=new Post();
        CreatePostResponse response=new CreatePostResponse();
        if(canPost( request.getText(), request.getPosterUsername() )) {
            post.setText(request.getText());
            post.setPosterUsername(request.getPosterUsername());
            response.setPost( postRepository.createNewPost(post) );
            response.setSuccess(true);
            return response;
        }
        response.setSuccess(false);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetPostsUsingPosterRequest")
    @ResponsePayload
    public GetPostsUsingPosterResponse getPostsUsingPoster(@RequestPayload GetPostsUsingPosterRequest request){
        GetPostsUsingPosterResponse response=new GetPostsUsingPosterResponse();
        response.getPost()
            .addAll(postRepository
            .getPosts(request
            .getPosterUsernames()));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetPostUsingIDRequest")
    @ResponsePayload
    public GetPostUsingIDResponse getPostUsingID(@RequestPayload GetPostUsingIDRequest request){
        GetPostUsingIDResponse response=new GetPostUsingIDResponse();
        response
            .setPost(postRepository
            .getPost(request
            .getPostID()));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "LikePostRequest")
    public void likePost(@RequestPayload LikePostRequest request){
        List<String> likerUsernames = postRepository.getPost(request.getPostID()).getLikerUsernames();

        if (!likerUsernames.contains(request.getRequesterUsername()))
            likerUsernames.add(request.getRequesterUsername());
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "DislikePostRequest")
    public void dislikePost(@RequestPayload DislikePostRequest request){
        postRepository.getPost(request.getPostID()).getLikerUsernames().remove(request.getRequesterUsername());
    }


}
