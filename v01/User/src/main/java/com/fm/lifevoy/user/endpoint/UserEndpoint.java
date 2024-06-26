package com.fm.lifevoy.user.endpoint;

import com.fm.lifevoy.user.generated.*;
import com.fm.lifevoy.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;

@Endpoint
public class UserEndpoint {
    private static final String NAMESPACE_URI = "http://www.fm.com/lifevoy/user/generated";
    private final UserRepository userRepository;

    @Autowired
    public UserEndpoint(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetUserByUsernameRequest")
    @ResponsePayload
    public GetUserByUsernameResponse getUserByUsername(@RequestPayload GetUserByUsernameRequest request){
        User u = userRepository.getUser(request.getUserName());
        GetUserByUsernameResponse response = new GetUserByUsernameResponse();
        response.setUser(u);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetFollowersRequest")
    @ResponsePayload
    public GetFollowersResponse getFollowers(@RequestPayload GetFollowersRequest request){
        User user = userRepository.getUser(request.getUsername());
        List<String> usernames = user.getFollowers();
        GetFollowersResponse response = new GetFollowersResponse();
        for (String follower : usernames)
            response.getFollowers().add(userRepository.getUser(follower));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetFollowingsRequest")
    @ResponsePayload
    public GetFollowingsResponse getFollowings(@RequestPayload GetFollowingsRequest request){
        User user = userRepository.getUser(request.getUsername());
        List<String> usernames = user.getFollowers();
        GetFollowingsResponse response = new GetFollowingsResponse();
        for (String following : usernames)
            response.getFollowings().add(userRepository.getUser(following));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "FollowUserRequest")
    @ResponsePayload
    public FollowUserResponse follow(@RequestPayload FollowUserRequest request){
        User target = userRepository.getUser(request.getTargetUsername());
        User requester = userRepository.getUser(request.getRequesterUsername());
        if(target == null || requester == null) return null;
        else{
            target.getFollowers().add(requester.getUserName());
            requester.getFollowings().add(target.getUserName());
            userRepository.putUser(target);
            userRepository.putUser(requester);
        }
        FollowUserResponse response = new FollowUserResponse();
        response.setTargetUser(target);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "UnfollowUserRequest")
    @ResponsePayload
    public UnfollowUserResponse unfollow(@RequestPayload UnfollowUserRequest request){
        User target = userRepository.getUser(request.getTargetUsername());
        User requester = userRepository.getUser(request.getRequesterUsername());
        if(target == null || requester == null) return null;
        else{
            target.getFollowers().remove(requester.getUserName());
            requester.getFollowings().remove(target.getUserName());
            userRepository.putUser(target);
            userRepository.putUser(requester);
        }
        UnfollowUserResponse response = new UnfollowUserResponse();
        response.setTargetUser(target);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "SignUpRequest")
    @ResponsePayload
    public SignUpResponse signup(@RequestPayload SignUpRequest request){
        String username = request.getUsername();
        String pass = request.getPassword();
        User requester = userRepository.getUser(username);
        if(requester != null) return null;
        else{
            requester = new User();
            requester.setUserName(username);
            requester.setPassword(pass);
            userRepository.putUser(requester);
        }
        SignUpResponse response = new SignUpResponse();
        response.setNewUser(requester);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "SignInRequest")
    @ResponsePayload
    public SignInResponse signin(@RequestPayload SignInRequest request){
        String username = request.getUsername();
        String pass = request.getPassword();
        User requester = userRepository.getUser(username);
        if(requester == null || !pass.equals(request.getPassword())) return null;
        else{
            SignInResponse response = new SignInResponse();
            response.setNewUser(requester);
            return response;
        }

    }
}
