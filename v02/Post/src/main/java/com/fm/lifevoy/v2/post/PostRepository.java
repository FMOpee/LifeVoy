package com.fm.lifevoy.v2.post;

import com.fm.lifevoy.v2.post.generated.Post;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class PostRepository {
    private static HashMap<Long, Post> posts = new HashMap<>();
    private static long currentPostID = 1L;

    @PostConstruct
    public void init(){
        for (int i=0;i<40;i++){
            Post p = new Post();
            p.setText("post text "+(i+1));
            p.setPosterUsername("username"+(i%10+1));
            p.getLikerUsernames().add("username"+(i%10+1));
            p.getLikerUsernames().add("username"+((i+1)%10+1));
            createNewPost(p);
        }
    }

    public Post createNewPost(Post post){
        post.setPostID(currentPostID++);
        posts.put(post.getPostID(),post);
        return post;
    }

    public void putPost(Post post){
        posts.put(post.getPostID(),post);
    }

    public Post getPost(long postID){
        return posts.get(postID);
    }

    public List<Post> getPosts(List<String> posters){
        List<Post> retPosts = new ArrayList<>();
        for (Post post: posts.values()){
            if (posters.contains(post.getPosterUsername())){
                retPosts.add(post);
            }
        }
        return retPosts;
    }
}
