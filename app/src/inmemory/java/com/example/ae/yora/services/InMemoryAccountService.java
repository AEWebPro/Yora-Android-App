package com.example.ae.yora.services;


import android.util.Log;

import com.example.ae.yora.InfraStructure.Auth;
import com.example.ae.yora.InfraStructure.User;
import com.example.ae.yora.InfraStructure.YoraApplication;
import com.squareup.otto.Subscribe;

public class InMemoryAccountService  extends BaseInMemoryService{
    public InMemoryAccountService (YoraApplication application){
        super(application);
    }

    @Subscribe
    public void updateProfile(final Account.UpdateProfileRequest request){
       final Account.UpdateProfileResponse response = new Account.UpdateProfileResponse();
        if(request.displayName.equals("ahmed")){
            response.setPropertyError("displayName", "You can't be named ahmed");
        }

        invokeDelayed(new Runnable() {
            @Override
            public void run() {
                User user = application.getAuth().getUser();
                user.setDisplayName(request.displayName);
                user.setEmail(request.email);

                bus.post(response);
                bus.post(new Account.UserDetailsUpdatedEvent(user));
            }
        }, 1000, 2000);
    }

    @Subscribe
    public void updateAvatar(final Account.ChangeAvatarRequest request){
        invokeDelayed(new Runnable() {
            @Override
            public void run() {
                User user = application.getAuth().getUser();
                user.setAvatarUrl(request.newAvatarUri.toString());

                bus.post(new Account.ChangeAvatarResponse());
                bus.post(new Account.UserDetailsUpdatedEvent(user));
            }
        },2000,3000);
    }

    @Subscribe
    public void changePassword(Account.ChangePasswordRequest request){
        Account.ChangePasswordResponse response = new Account.ChangePasswordResponse();

        if(!request.newPassword.equals(request.confirmNewPassword)){
            response.setPropertyError("confirmNewPassword","Passwords must match!");
        }
        if(request.newPassword.length() < 3){
            response.setPropertyError("newPassword", "Password must be larger that 3 characters");
        }
        postDelayed(response);
    }

    @Subscribe
    public void loginWithUserName(final Account.LoginWithUsernameRequest request){
        invokeDelayed(new Runnable() {
            @Override
            public void run() {
                Account.LoginWithUsernameResponse response =  new Account.LoginWithUsernameResponse();
                if(request.userName.equals("ahmed"))
                    response.setPropertyError("userName", "Invalid username or password");

                loginUser(response);
                bus.post(response);
            }
        },1000,2000);
    }
    @Subscribe
    public void loginWithExternalLogin( Account.LoginWithExternalTokenRequest request){
        invokeDelayed(new Runnable() {
            @Override
            public void run() {
                Account.LoginWithExternalTokentResponse response = new Account.LoginWithExternalTokentResponse();
                loginUser(response);
                bus.post(response);
            }
        },1000,2000);
    }
    @Subscribe
    public void register(Account.RegisterRequest request){
        invokeDelayed(new Runnable() {
            @Override
            public void run() {
                Account.RegisterResponse response = new Account.RegisterResponse();
                loginUser(response);
                bus.post(response);
            }
        },1000,2000);
    }
    @Subscribe
    public void externalRegister(Account.RegisterWithExternalTokentRequest request){
        invokeDelayed(new Runnable() {
            @Override
            public void run() {
                Account.RegisterWithExternalTokenResponse response = new Account.RegisterWithExternalTokenResponse();
                loginUser(response);
                bus.post(response);
            }
        },1000,2000);
    }
    @Subscribe
    public void loginWithLocalToken (Account.LoginWithLocalTokenRequest request){
        invokeDelayed(new Runnable() {
            @Override
            public void run() {
                Account.LoginWithLocalTokenResponse response = new Account.LoginWithLocalTokenResponse();
                loginUser(response);
                bus.post(response);
            }
        },1000,2000);
    }
    private void loginUser(Account.UserResponse response){
        Auth auth = application.getAuth();
        User user = auth.getUser();

        user.setDisplayName("Ahmed Ehab");
        user.setUserName("ahmedehab");
        user.setEmail("ahmed@gmail.com");
        user.setAvatarUrl("http://www.gravatar.com/avatar/1?d=identicon");
        user.setLoggedIn(true);
        user.setId(123);

        bus.post(new Account.UserDetailsUpdatedEvent(user));
        auth.setAuthToken("fakeAuthToken");

        response.displayName = user.getDisplayName();
        response.userName = user.getUserName();
        response.Email = user.getEmail();
        response.avatarUrl = user.getAvatarUrl();
        response.id = user.getId();
        response.authToken = auth.getAuthToken();
    }
}
















