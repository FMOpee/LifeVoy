package com.fm.lifevoy.puppetmaster.client;

import com.fm.lifevoy.puppetmaster.generated.userService.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserClient {
    private final WebServiceTemplate webServiceTemplate;

//    @Autowired
    public UserClient() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setPackagesToScan("com.fm.lifevoy.puppetmaster.generated.userService");
        webServiceTemplate = new WebServiceTemplate(marshaller);
    }

    public List<String> getFollowings(String username) {
        GetFollowingsRequest request = new GetFollowingsRequest();
        request.setUsername(username);
        GetFollowingsResponse response = (GetFollowingsResponse) webServiceTemplate.marshalSendAndReceive(request);
        List<User> followings = response.getFollowings();
        List<String> usernames = new ArrayList<>();
        for (User user : followings) {
            usernames.add(user.getUserName());
        }
        return usernames;
    }

}
