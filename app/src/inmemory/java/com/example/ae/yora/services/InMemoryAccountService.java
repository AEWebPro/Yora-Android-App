package com.example.ae.yora.services;


import android.util.Log;

import com.example.ae.yora.InfraStructure.YoraApplication;
import com.squareup.otto.Subscribe;

public class InMemoryAccountService  extends BaseInMemoryService{
    public InMemoryAccountService (YoraApplication application){
        super(application);
    }

    @Subscribe
    public void updateProfile(Account.UpdateProfileRequest request){
        Account.UpdateProfileResponse response = new Account.UpdateProfileResponse();
        if(request.displayName.equals("ahmed")){
            response.setPropertyError("displayName", "You can't be named ahmed");
        }
        postDelayed(response, 1000, 2000);

    }

    @Subscribe
    public void updateAvatar(Account.ChangeAvatarRequest request){
        postDelayed(new Account.ChangeAvatarResponse(), 2000,3000);
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

}
