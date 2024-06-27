package com.fm.lifevoy.v2.comment;

import com.fm.lifevoy.v2.comment.generated.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import static com.fm.lifevoy.v2.comment.PostEligibilityClient.canPost;

@Endpoint
public class CommentEndpoint {
    private static final String NAMESPACE_URI ="http://fm.com/lifevoy/v2/comment";
    private final CommentRepository commentRepository;

    @Autowired
    public CommentEndpoint(CommentRepository commentRepository){
        this.commentRepository = commentRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI,localPart = "GetCommentsRequest")
    @ResponsePayload
    public GetCommentsResponse getComments(@RequestPayload GetCommentsRequest request){
        GetCommentsResponse response = new GetCommentsResponse();
        response.getComments().addAll(commentRepository.getComments(request.getPostID()));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI,localPart = "CommentRequest")
    @ResponsePayload
    public CommentResponse comment(@RequestPayload CommentRequest request){
        CommentResponse response = new CommentResponse();
        if( canPost( request.getText(), request.getUsername() ) ){
            response.setComment(commentRepository
                    .addComment(
                            request.getText(),
                            request.getUsername(),
                            request.getPostID()));
        }
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "ReplyRequest")
    @ResponsePayload
    public ReplyResponse reply(@RequestPayload ReplyRequest request){
        ReplyResponse response = new ReplyResponse();
        if(canPost( request.getText(), request.getUsername() )){
            response.setComment(commentRepository
                    .addReply(
                            request.getUsername(),
                            request.getText(),
                            request.getCommentID()));
        }
        return response;
    }
}






