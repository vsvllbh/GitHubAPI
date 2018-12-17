package com.example.vsvll.githubapi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;

public class particularItem extends AppCompatActivity {

    private static final String TAG = "Tagged";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.row_particular);

        if (getIntent().hasExtra("image_url") && getIntent().hasExtra("image_name")) {
            Log.d(TAG, "getIncomingIntent: found intent extras.");

            String imageUrl = getIntent().getStringExtra("image_url");
            String imageName = getIntent().getStringExtra("image_name");

             setData(imageName,imageUrl);
        }
    }

    private void setData(String imageName, String imageUrl) {

       // Toast.makeText(this,"Name is "+imageName+"\n Url is  "+imageUrl,Toast.LENGTH_LONG).show();

        TextView textView = findViewById(R.id.title);
        textView.setText(imageName);

        ImageView imageView = findViewById(R.id.imageView);
        Glide.with(this).load(imageUrl).into(imageView);
    }
}