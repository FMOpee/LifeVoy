package com.fm.lifevoy.user.repository;

import com.fm.lifevoy.user.generated.User;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class UserRepository {
    private static final Map<String, User> users = new HashMap<String, User>();

    @PostConstruct
    public void init() {
        String[] usernames = new String[]{"fahim","proma","rudro","kazi","nahid"};

        User u1 = new User();
        u1.setUserName(usernames[0]);
        u1.setPassword(usernames[0]);
        u1.getFollowers().addAll(List.of(new String[]{usernames[1],usernames[2],usernames[3]}));
        u1.getFollowings().addAll(List.of(new String[]{usernames[1],usernames[2],usernames[3],usernames[4]}));
        u1.getPosts().addAll(List.of(new Long[]{1L, 2L, 3L}));
        users.put(usernames[0],u1 );

        User u2 = new User();
        u2.setUserName(usernames[1]);
        u2.setPassword(usernames[1]);
        u2.getFollowers().add(usernames[0]);
        u2.getFollowings().addAll(List.of(new String[]{usernames[0],usernames[2]}));
        u2.getPosts().addAll(List.of(new Long[]{4L, 5L, 6L}));
        users.put(usernames[1],u2 );

        User u3 = new User();
        u3.setUserName(usernames[2]);
        u3.setPassword(usernames[2]);
        u3.getFollowers().addAll(List.of(new String[]{usernames[0],usernames[1],usernames[3],usernames[4]}));
        u3.getFollowings().add(usernames[0]);
        u3.getPosts().addAll(List.of(new Long[]{7L, 8L, 9L}));
        users.put(usernames[2],u3 );

        User u4 = new User();
        u4.setUserName(usernames[3]);
        u4.setPassword(usernames[3]);
        u4.getFollowers().addAll(List.of(new String[]{usernames[0],usernames[4]}));
        u4.getFollowings().addAll(List.of(new String[]{usernames[0],usernames[2],usernames[4]}));
        u4.getPosts().addAll(List.of(new Long[]{10L,11L,12L}));
        users.put(usernames[3],u4 );

        User u5 = new User();
        u5.setUserName(usernames[4]);
        u5.setPassword(usernames[4]);
        u5.getFollowers().addAll(List.of(new String[]{usernames[0],usernames[3]}));
        u5.getFollowings().addAll(List.of(new String[]{usernames[2],usernames[3]}));
        u5.getPosts().addAll(List.of(new Long[]{13L,14L,15L}));
        users.put(usernames[4],u5 );
    }

    public User getUser(String username){
        return users.get(username);
    }
    public void putUser(User user){
        users.put(user.getUserName(),user);
    }
    public List<User> getUsers(List<String> usernames) {
        List<User> listOfUsers = new ArrayList<>();
        for(String username:usernames){
            User u = users.get(username);
            if(u==null)
                listOfUsers.add(users.get(username));
        }
        return listOfUsers;
    }

}
