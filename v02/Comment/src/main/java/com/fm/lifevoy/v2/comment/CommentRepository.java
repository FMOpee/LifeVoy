package com.fm.lifevoy.v2.comment;

import com.fm.lifevoy.v2.comment.generated.Comment;
import com.fm.lifevoy.v2.comment.generated.Reply;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Component
public class CommentRepository {
    private HashMap<Long, Comment> comments = new HashMap<>();
    private static long commentID=1L;

    @PostConstruct
    public void init() {
        for (int i = 0; i < 200; i++) {
            Comment c = addComment(
                    "comment "+i,
                    "username"+(i%6+1),
                    i%40+1);
            addReply("username"+((i+1)%10+1),
                    "reply"+i,
                    c.getCommentID());
            addReply("username"+((i+2)%10+1),
                    "reply"+i+i,
                    c.getCommentID());
        }
    }

    public Comment addReply(String username,String text, long commentID){
        Comment c = getComment(commentID);
        if(c != null){
            Reply r1 = new Reply();
            r1.setText(text);
            r1.setUsername(username);
            c.getReplies().add(r1);
        }
        return c;
    }

    public Comment addComment(String commentText,String commenter, long postID) {
        Comment comment = new Comment();
        comment.setCommentID(commentID++);
        comment.setCommenter(commenter);
        comment.setText(commentText);
        comment.setPostID(postID);
        comments.put(comment.getCommentID(),comment);
        return comment;
    }

    public Comment getComment(long commentID){
        return comments.get(commentID);
    }

    public List<Comment> getComments(long postID){
        List<Comment> retcom = new ArrayList<>();
        for (Comment c:comments.values()){
            if(c.getPostID()==postID){
                retcom.add(c);
            }
        }
        return retcom;
    }
}
