package com.fm.lifevoy.post.repository;

import com.fm.lifevoy.post.generated.Post;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class PostRepository {
    private static final Map<Long, Post> posts = new HashMap<>();
    private static Long nextPostId = 1L;

    @PostConstruct
    public void init() {
        String[] usernames = new String[]{"fahim","proma","rudro","kazi","nahid"};

        Post p1 = new Post();
        p1.setPostID(nextPostId++);
        p1.setText("post text 1");
        p1.setPosterUsername(usernames[0]);
        p1.getLikers().addAll(List.of(new String[]{usernames[0],usernames[1],usernames[2]}));
        posts.put(p1.getPostID(), p1);
        Post p2 = new Post();
        p2.setPostID(nextPostId++);
        p2.setText("post text 2");
        p2.setPosterUsername(usernames[0]);
        p2.getLikers().addAll(List.of(new String[]{usernames[3],usernames[1],usernames[2]}));
        posts.put(p2.getPostID(), p2);
        Post p3 = new Post();
        p3.setPostID(nextPostId++);
        p3.setText("post text 3");
        p3.setPosterUsername(usernames[0]);
        p3.getLikers().addAll(List.of(new String[]{usernames[1],usernames[4],usernames[2]}));
        posts.put(p3.getPostID(), p3);

        Post p4 = new Post();
        p4.setPostID(nextPostId++);
        p4.setText("post text 4");
        p4.setPosterUsername(usernames[1]);
        p1.getLikers().addAll(List.of(new String[]{usernames[0],usernames[1],usernames[2]}));
        posts.put(p4.getPostID(), p4);
        Post p5 = new Post();
        p5.setPostID(nextPostId++);
        p5.setText("post text 5");
        p5.setPosterUsername(usernames[1]);
        p5.getLikers().addAll(List.of(new String[]{usernames[0],usernames[1],usernames[2]}));
        posts.put(p5.getPostID(), p5);
        Post p6 = new Post();
        p6.setPostID(nextPostId++);
        p6.setPosterUsername(usernames[1]);
        p6.setText("post text 6");
        p6.getLikers().addAll(List.of(new String[]{usernames[0],usernames[1],usernames[2]}));
        posts.put(p6.getPostID(), p6);

        Post p7 = new Post();
        p7.setPostID(nextPostId++);
        p7.setText("post text 7");
        p7.setPosterUsername(usernames[2]);
        p7.getLikers().addAll(List.of(new String[]{usernames[0],usernames[1],usernames[2]}));
        posts.put(p7.getPostID(), p7);
        Post p8 = new Post();
        p8.setPostID(nextPostId++);
        p8.setText("post text 8");
        p8.setPosterUsername(usernames[2]);
        p8.getLikers().addAll(List.of(new String[]{usernames[0],usernames[1],usernames[2]}));
        posts.put(p8.getPostID(), p8);
        Post p9 = new Post();
        p9.setPostID(nextPostId++);
        p9.setText("post text 9");
        p9.setPosterUsername(usernames[2]);
        p9.getLikers().addAll(List.of(new String[]{usernames[0],usernames[1],usernames[2]}));
        posts.put(p9.getPostID(), p9);

        Post p10 = new Post();
        p10.setPostID(nextPostId++);
        p10.setText("post text 10");
        p10.setPosterUsername(usernames[3]);
        p10.getLikers().addAll(List.of(new String[]{usernames[0],usernames[1],usernames[2]}));
        posts.put(p10.getPostID(), p10);
        Post p11 = new Post();
        p11.setPostID(nextPostId++);
        p11.setText("post text 11");
        p11.setPosterUsername(usernames[3]);
        p11.getLikers().addAll(List.of(new String[]{usernames[0],usernames[1],usernames[2]}));
        posts.put(p11.getPostID(), p11);
        Post p12 = new Post();
        p12.setPostID(nextPostId++);
        p12.setText("post text 12");
        p12.setPosterUsername(usernames[3]);
        p12.getLikers().addAll(List.of(new String[]{usernames[0],usernames[1],usernames[2]}));
        posts.put(p12.getPostID(), p12);

        Post p13 = new Post();
        p13.setPostID(nextPostId++);
        p13.setText("post text 13");
        p13.setPosterUsername(usernames[4]);
        p13.getLikers().addAll(List.of(new String[]{usernames[0],usernames[1],usernames[2]}));
        posts.put(p13.getPostID(), p13);
        Post p14 = new Post();
        p14.setPostID(nextPostId++);
        p14.setText("post text 14");
        p14.setPosterUsername(usernames[4]);
        p14.getLikers().addAll(List.of(new String[]{usernames[0],usernames[1],usernames[2]}));
        posts.put(p14.getPostID(), p14);
        Post p15 = new Post();
        p15.setPostID(nextPostId++);
        p15.setText("post text 15");
        p15.setPosterUsername(usernames[4]);
        p15.getLikers().addAll(List.of(new String[]{usernames[0],usernames[1],usernames[2]}));
        posts.put(p15.getPostID(), p15);
    }

    public Post getPost(Long postID){
        return posts.get(postID);
    }
    public List<Post> getPosts(List<Long> postIDs){
        List<Post> posts = new ArrayList<>();
        for(Long postID : postIDs){
            posts.add(getPost(postID));
        }
        return posts;
    }
    public void updatePost(Post post){
        posts.put(post.getPostID(), post);
    }
    public Post createNewPost(String poster, String text){
        Post post = new Post();
        post.setPostID(nextPostId++);
        post.setText("post text " + text);
        post.setPosterUsername(poster);
        posts.put(post.getPostID(), post);
        return post;
    }
    public List<Post> getAllPosts(){
        return new ArrayList<>(posts.values());
    }
}

