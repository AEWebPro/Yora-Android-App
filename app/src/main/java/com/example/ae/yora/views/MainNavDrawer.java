package com.example.ae.yora.views;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ae.yora.InfraStructure.User;
import com.example.ae.yora.R;
import com.example.ae.yora.activities.BaseActivity;
import com.example.ae.yora.activities.ContactsActivity;
import com.example.ae.yora.activities.MainActivity;
import com.example.ae.yora.activities.ProfileActivity;
import com.example.ae.yora.activities.SendMessagesActivity;
import com.example.ae.yora.services.Account;
import com.squareup.otto.Subscribe;


public class MainNavDrawer extends NavDrawer {
    private final TextView displayName;
    private final ImageView avatarImage;

    public MainNavDrawer(final BaseActivity activity) {
        super(activity);

        addItem(new ActivityNavDrawerItem(MainActivity.class,"Inbox",null, R.drawable.ic_markunread_black_24dp ,R.id.include_main_nav_drawer_top_items));
        addItem(new ActivityNavDrawerItem(SendMessagesActivity.class, "Send Messages",null,R.drawable.ic_send_black_24dp, R.id.include_main_nav_drawer_top_items));
        addItem(new ActivityNavDrawerItem(ContactsActivity.class, "Contacts",null,R.drawable.ic_group_black_24dp, R.id.include_main_nav_drawer_top_items));
        addItem(new ActivityNavDrawerItem(ProfileActivity.class, "Profile",null,R.drawable.ic_person_black_24dp, R.id.include_main_nav_drawer_top_items));

        addItem(new BasicNavDrawerItem("Logout",null,R.drawable.ic_backspace_black_24dp,R.id.include_main_nav_drawer_bottom_items){
            @Override
            public void onClick(View view){
                activity.getYoraApplication().getAuth().logout();
            }
        });

        displayName = (TextView) navDrawerView.findViewById(R.id.include_main_nav_drawer_display_name);
        avatarImage = (ImageView) navDrawerView.findViewById(R.id.include_main_nav_drawer_avatar);

        User loggedInUser = activity.getYoraApplication().getAuth().getUser();
        displayName.setText(loggedInUser.getDisplayName());

        //TODO: change avatar image to avatar url from logged User
    }

    @Subscribe
    public void onUserDetailsUpdated(Account.UserDetailsUpdatedEvent event){
        //TODO: update avatar url
        displayName.setText(event.user.getDisplayName());
    }
}
