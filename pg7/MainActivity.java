package com.example.framelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    boolean show=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn= findViewById(R.id.button2);
        ImageView img= findViewById(R.id.imageView2);
        ImageView img2= findViewById(R.id.imageView3);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (show){
                    img.setVisibility(View.GONE);
                    img2.setVisibility(View.VISIBLE);
                }
                else
                {
                    img.setVisibility(View.VISIBLE);
                    img2.setVisibility(View.GONE);

                }
                show=!show;
            }
        });

    }
}