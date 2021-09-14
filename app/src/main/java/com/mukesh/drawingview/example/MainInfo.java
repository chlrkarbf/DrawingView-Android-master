package com.mukesh.drawingview.example;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainInfo extends AppCompatActivity {

    private Button button_info_next;
    @Override


    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_info);

        Button button_start = (Button) findViewById(R.id.button_info_next);
        button_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainDrawing.class);
                startActivity(intent);
            }
        });
    }
}