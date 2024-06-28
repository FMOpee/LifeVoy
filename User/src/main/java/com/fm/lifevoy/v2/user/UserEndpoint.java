package com.fm.lifevoy.v2.user;

import com.fm.lifevoy.v2.user.generated.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;

@Endpoint
public class UserEndpoint {
    private static final String NAMESPACE_URI = "http://fm.com/lifevoy/v2/user";
    private final UserRepository userRepository;

    @Autowired
    public UserEndpoint(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "LoginRequest")
    @ResponsePayload
    public LoginResponse login(@RequestPayload LoginRequest loginRequest) {
        User u = userRepository.getUser(loginRequest.getUsername());
        LoginResponse response = new LoginResponse();
        if (u == null || !u.getPassword().equals(loginRequest.getPassword())) {
            response.setSuccess(false);
            return response;
        }
        response.setSuccess(true);
        response.setUser(u);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI,localPart = "SignupRequest")
    @ResponsePayload
    public SignupResponse signup(@RequestPayload SignupRequest signupRequest) {
        User u = userRepository.getUser(signupRequest.getUsername());
        SignupResponse response = new SignupResponse();
        if(u!=null){
            response.setSuccess(false);
            return response;
        }
        u = new User();
        response.setSuccess(true);
        PublicProfile profile = new PublicProfile();
        profile.setUsername(signupRequest.getUsername());
        u.setPassword(signupRequest.getPassword());
        u.setProfile(profile);
        response.setUser(u);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetFollowersRequest")
    @ResponsePayload
    public GetFollowersResponse getFollowers(@RequestPayload GetFollowersRequest getFollowersRequest) {
        GetFollowersResponse response = new GetFollowersResponse();
        List<String> followers = userRepository .getUser(getFollowersRequest.getUsername())
                                                .getProfile()
                                                .getFollowers();
        response.getFollowerUsernames().addAll(followers);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetFollowingsRequest")
    @ResponsePayload
    public GetFollowingsResponse getFollowings(@RequestPayload GetFollowingsRequest request){
        GetFollowingsResponse response = new GetFollowingsResponse();
        response.getFollowingUsernames()
                .addAll(userRepository
                        .getUser(request.getUsername())
                        .getProfile()
                        .getFollowings()
                );
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetUserRequest")
    @ResponsePayload
    public GetUserResponse getUsers(@RequestPayload GetUserRequest request){
        GetUserResponse response = new GetUserResponse();
        for (String username: request.getUsernames()){
            response.getProfiles()
                    .add(userRepository
                            .getUser(username)
                            .getProfile()
                    );
        }
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "FollowUserRequest")
    public void follow(@RequestPayload FollowUserRequest request){
        User requester = userRepository.getUser(request.getRequesterUsername());
        User target = userRepository.getUser(request.getTargetUsername());
        if (!requester.getProfile()
                .getFollowings()
                .contains(request
                        .getTargetUsername())
        ) {
            requester.getProfile()
                    .getFollowings()
                    .add(request
                            .getTargetUsername());
        }
        if(!target.getProfile()
                .getFollowers()
                .contains(request
                        .getRequesterUsername())
        ){
            target.getProfile()
                    .getFollowers()
                    .add(request
                            .getRequesterUsername());
        }

    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "UnfollowUserRequest")
    public void unfollow(@RequestPayload UnfollowUserRequest request){
        userRepository
                .getUser(request
                        .getRequesterUsername())
                .getProfile()
                .getFollowings()
                .remove(request
                        .getTargetUsername());
        userRepository
                .getUser(request
                        .getTargetUsername())
                .getProfile()
                .getFollowers()
                .remove(request
                        .getRequesterUsername());
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetAllUserNamesRequest")
    @ResponsePayload
    public GetAllUserNamesResponse getAllUserNames(@RequestPayload GetAllUserNamesRequest request) {
        GetAllUserNamesResponse response = new GetAllUserNamesResponse();
        if (request.getToken().equals("123456789")){
            response.getUsernames().addAll(userRepository.listUsernames());
            return response;
        }
        return response;
    }

}
