package com.example.ae.yora.services;


import android.net.Uri;

import com.example.ae.yora.InfraStructure.ServiceResponse;
import com.example.ae.yora.InfraStructure.User;

public final class Account {
    private Account(){}

    public static class UserResponse extends ServiceResponse{
        public int id;
        public String avatarUrl;
        public String displayName;
        public String userName;
        public String Email;
        public String authToken;
        public boolean HasPassword;
    }

    public static class ChangeAvatarRequest{
        public Uri newAvatarUri;

        public ChangeAvatarRequest(Uri newAvatarUri){
            this.newAvatarUri = newAvatarUri;

        }
    }

    public static class ChangeAvatarResponse extends ServiceResponse{

    }

    public static class UpdateProfileRequest{
        public String displayName;
        public String email;

        public UpdateProfileRequest(String displayName, String email) {
            this.displayName = displayName;
            this.email = email;
        }
    }

    public static class UpdateProfileResponse extends ServiceResponse{

    }

    public static class ChangePasswordRequest{
        public String currentPassword;
        public String newPassword;
        public String confirmNewPassword;

        public ChangePasswordRequest(String currentPassword, String newPassword, String confirmNewPassword) {
            this.currentPassword = currentPassword;
            this.newPassword = newPassword;
            this.confirmNewPassword = confirmNewPassword;
        }
    }

    public static class ChangePasswordResponse extends ServiceResponse{

    }

    public static class LoginWithUsernameRequest{
        public String userName;
        public String password;

        public LoginWithUsernameRequest(String userName, String password) {
            this.userName = userName;
            this.password = password;
        }
    }
    public static class LoginWithUsernameResponse extends UserResponse{
    }

    public static class LoginWithLocalTokenRequest{
        public String authToken;

        public LoginWithLocalTokenRequest(String authToken) {
            this.authToken = authToken;
        }
    }
    public static class LoginWithLocalTokenResponse extends UserResponse{

    }

    public static class LoginWithExternalTokenRequest{
        public String provider;
        public String token;
        public String clientId;

        public LoginWithExternalTokenRequest(String provider, String token, String clientId) {
            this.provider = provider;
            this.token = token;
            this.clientId = "android";
        }
    }
    public static class LoginWithExternalTokentResponse extends UserResponse{
    }

    public static class RegisterRequest{
        public String userName;
        public String email;
        public String password;
        public String clientID;

        public RegisterRequest(String userName, String email, String password) {
            this.userName = userName;
            this.email = email;
            this.password = password;
            this.clientID = "android";
        }
    }
    public static class RegisterResponse extends UserResponse{

    }

    public static class RegisterWithExternalTokentRequest{
        public String userName;
        public String email;
        public String provider;
        public String Token;
        public String clientId;

        public RegisterWithExternalTokentRequest(String userName, String email, String provider, String token) {
            this.userName = userName;
            this.email = email;
            this.provider = provider;
            Token = token;
            this.clientId = "android";
        }
    }
    public static class RegisterWithExternalTokenResponse extends UserResponse{

    }


    public static class UserDetailsUpdatedEvent{
        public User user;

        public UserDetailsUpdatedEvent(User user) {
            this.user = user;
        }
    }
}



































