package com.example.manelmm3.userprofile;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class UserProfileActivity extends AppCompatActivity {

    private User info;
    private Gson gson;

    private TextView name;
    private TextView user;
    private TextView following;
    private TextView followers;
    private TextView about;

    private ImageView bg;
    private ImageView foto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        gson = new Gson();

        try {
            InputStream stream = getAssets().open("UserInfo.json");
            InputStreamReader reader = new InputStreamReader(stream);
            info = gson.fromJson(reader, User.class);
        } catch (IOException e) {
            Toast.makeText(this,"Couldn't load JSON file with user info",Toast.LENGTH_SHORT).show();
        }

        bg = findViewById(R.id.BackgroundImage);
        foto = findViewById(R.id.Foto);
        Glide.with(this)
                .load("file:///android_asset/UserProfile-background.jpg")
                .into(bg);
        Glide.with(this)
                .load("file:///android_asset/User.png")
                .apply(RequestOptions.circleCropTransform())
                .into(foto);

        name = findViewById(R.id.Name);
        user = findViewById(R.id.User);
        following = findViewById(R.id.Following);
        followers = findViewById(R.id.Followers);
        about = findViewById(R.id.AboutMe);


        updateProfile();
    }

    private void updateProfile() {
        name.setText(info.getName());
        user.setText(info.getHandle());
        following.setText(info.getFollowing());
        followers.setText(info.getFollowers());
        about.setText(info.getAbout());

    }
}
