package com.herfan.radionds;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private Button btnPlay, pauseButton, stopButton;
    private TextView statusText;
      GridView tabla;
    //private String streamUrl = "https://stream.integracionvirtual.com/proxy/arboleda?mp=/stream";

    List <String> nombreEstacion;
    List <String> descripcionEstacion;


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

         tabla = findViewById(R.id.tabla);

         nombreEstacion = new ArrayList<String>();
         nombreEstacion.add("tuplanetaonline");
        nombreEstacion.add("arboledas stereo");
        nombreEstacion.add("musica disco");
        nombreEstacion.add("musica clasica");
        nombreEstacion.add("musica pop");
        nombreEstacion.add("otra musica");


        descripcionEstacion = new ArrayList<String>();
        descripcionEstacion.add("emisora con enfasis ecologico");
        descripcionEstacion.add("emisora comunitaria de Arblodes");
        descripcionEstacion.add("escucha tu musica disco favorita");
        descripcionEstacion.add("escucha tu musica clasica favorita");
        descripcionEstacion.add("escucha tu musica pop favorita");
        descripcionEstacion.add("escucha otra musica favorita");

        int[] imagenes = {
                R.drawable.logo1,
                R.drawable.pajaro,
                R.drawable.panda,
                R.drawable.paraiso,
                R.drawable.perro,
                R.drawable.rana
        };

        Adaptador adaptador = new Adaptador(this, R.layout.elemento, nombreEstacion, descripcionEstacion, imagenes);
        tabla.setAdapter(adaptador);
        tabla.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });











    }

}
