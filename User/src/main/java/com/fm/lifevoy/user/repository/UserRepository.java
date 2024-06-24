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
        u1.getFollowers().add(usernames[1]);
        u1.getFollowers().add(usernames[2]);
        u1.getFollowers().add(usernames[3]);

        u1.getFollowings().add(usernames[1]);
        u1.getFollowings().add(usernames[2]);
        u1.getFollowings().add(usernames[3]);
        u1.getFollowings().add(usernames[4]);

        u1.getPosts().add(1L);
        u1.getPosts().add(2L);
        u1.getPosts().add(3L);

        users.put(usernames[0],u1 );

        User u2 = new User();
        u2.setUserName(usernames[1]);
        u2.setPassword(usernames[1]);

        u2.getFollowers().add(usernames[0]);

        u2.getFollowings().add(usernames[0]);
        u2.getFollowings().add(usernames[2]);

        u2.getPosts().add(4L);
        u2.getPosts().add(5L);
        u2.getPosts().add(6L);

        users.put(usernames[1],u2 );

        User u3 = new User();
        u3.setUserName(usernames[2]);
        u3.setPassword(usernames[2]);

        u3.getFollowers().add(usernames[0]);
        u3.getFollowers().add(usernames[1]);
        u3.getFollowers().add(usernames[2]);
        u3.getFollowers().add(usernames[3]);
        u3.getFollowers().add(usernames[4]);

        u3.getFollowings().add(usernames[0]);

        u3.getPosts().add(7L);
        u3.getPosts().add(8L);
        u3.getPosts().add(9L);

        users.put(usernames[2],u3 );

        User u4 = new User();
        u4.setUserName(usernames[3]);
        u4.setPassword(usernames[3]);

        u4.getFollowers().add(usernames[0]);
        u4.getFollowers().add(usernames[4]);

        u4.getFollowings().add(usernames[0]);
        u4.getFollowings().add(usernames[2]);
        u4.getFollowings().add(usernames[4]);

        u4.getPosts().add(10L);
        u4.getPosts().add(11L);
        u4.getPosts().add(12L);

        users.put(usernames[3],u4 );

        User u5 = new User();
        u5.setUserName(usernames[4]);
        u5.setPassword(usernames[4]);

        u5.getFollowers().add(usernames[0]);
        u5.getFollowers().add(usernames[3]);

        u5.getFollowings().add(usernames[2]);
        u5.getFollowings().add(usernames[3]);

        u5.getPosts().add(13L);
        u5.getPosts().add(14L);
        u5.getPosts().add(15L);

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
