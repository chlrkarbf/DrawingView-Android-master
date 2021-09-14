package com.mukesh.drawingview.example;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import androidx.appcompat.app.AppCompatActivity;
import com.mukesh.DrawingView;

public class MainActivity extends AppCompatActivity
    implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {
  private Button saveButton, penButton, eraserButton;
  private DrawingView drawingView;
  private SeekBar penSizeSeekBar, eraserSizeSeekBar;
  private ImageView imageView2;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    initializeUI();
    setListeners();
  }

  private void setListeners() {
    saveButton.setOnClickListener(this);
    penButton.setOnClickListener(this);
    eraserButton.setOnClickListener(this);
    penSizeSeekBar.setOnSeekBarChangeListener(this);
    eraserSizeSeekBar.setOnSeekBarChangeListener(this);
    imageView2.setOnClickListener(this);
  }

  private void initializeUI() {
    drawingView = findViewById(R.id.scratch_pad);
    saveButton = findViewById(R.id.save_button);
    penButton = findViewById(R.id.pen_button);
    eraserButton = findViewById(R.id.eraser_button);
    penSizeSeekBar = findViewById(R.id.pen_size_seekbar2);
    eraserSizeSeekBar = findViewById(R.id.eraser_size_seekbar);
    imageView2 = findViewById(R.id.imageView2);
  }

  @Override public void onClick(View view) {
    switch (view.getId()) {
      case R.id.save_button:
        drawingView.saveImage(Environment.getExternalStorageDirectory().toString(), "test",
            Bitmap.CompressFormat.PNG, 100);
        break;
      case R.id.pen_button:
        drawingView.initializePen();
        break;
      case R.id.eraser_button:
        drawingView.initializeEraser();
        break;
      case R.id.imageView2:
        Intent myintent = new Intent(MainActivity.this,MainStart.class);
        startActivity(myintent);
        finish();
      default:
        break;
    }
  }


  @Override public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
    int seekBarId = seekBar.getId();
    if (seekBarId == R.id.pen_size_seekbar2) {
      drawingView.setPenSize(i);
    } else if (seekBarId == R.id.eraser_size_seekbar) {
      drawingView.setEraserSize(i);
    }
  }

  @Override public void onStartTrackingTouch(SeekBar seekBar) {
    //Intentionally Empty
  }

  @Override public void onStopTrackingTouch(SeekBar seekBar) {
    //Intentionally Empty
  }
}
