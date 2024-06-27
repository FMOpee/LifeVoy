package com.fm.lifevoy.v2.user;

import com.fm.lifevoy.v2.user.generated.PublicProfile;
import com.fm.lifevoy.v2.user.generated.User;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class UserRepository {
    private static final HashMap<String, User> users = new HashMap<String, User>();

    @PostConstruct
    public void init() {
        for(int i=1;i<=10;i++){
            PublicProfile profile = new PublicProfile();
            profile.setUsername("username"+i);
            for(int j = i%2==0?2:1; j<=10; j+=2){
                if(j!=i){
                    profile.getFollowers().add("username"+j);
                    profile.getFollowings().add("username"+j);
                }
            }
            User user = new User();
            user.setProfile(profile);
            user.setPassword("password"+i);
            users.put(profile.getUsername(), user);
        }
    }

    public User getUser(String username){
        return users.get(username);
    }

    public List<String> listUsernames() {
        List<String> usernames=new ArrayList<>();
        for (User user : users.values()) {
            usernames.add(user.getProfile().getUsername());
        }
        return usernames;
    }
}
