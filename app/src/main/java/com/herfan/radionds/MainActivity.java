package com.herfan.radionds;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private Button btnPlay, pauseButton, stopButton;
    private TextView statusText;
    //private String streamUrl = "https://stream.integracionvirtual.com/proxy/arboleda?mp=/stream";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPlay = findViewById(R.id.btnPlay);
        pauseButton = findViewById(R.id.pauseButton);
        stopButton = findViewById(R.id.btnStop);
        ExoPlayer exoPlayer = new ExoPlayer.Builder(this ).build();

         btnPlay.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 MediaItem url = MediaItem.fromUri("http://150.136.165.107:8000/radio.mp3");
                 exoPlayer.setMediaItem(url);
                 exoPlayer.prepare();
                 exoPlayer.play();
             }
         });

         pauseButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 exoPlayer.stop();
             }
         });





    }

}
