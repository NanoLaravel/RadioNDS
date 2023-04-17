package com.herfan.radionds;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
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
    private TextView tvEstado;
    private boolean isPlaying = false;
    private Handler handler = new Handler();
    private boolean isVisible = true;
      GridView tabla;
    //private String streamUrl = "https://stream.integracionvirtual.com/proxy/arboleda?mp=/stream";

    List <String> nombreEstacion;
    List <String> descripcionEstacion;
    List <String> urlEnviar_elemento;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPlay = findViewById(R.id.btnPlay);
        stopButton = findViewById(R.id.btnStop);
        tvEstado = findViewById(R.id.tvEstado);
        ExoPlayer exoPlayer = new ExoPlayer.Builder(this ).build();


//        btnPlay.setOnClickListener(new View.OnClickListener() {
//             @Override
//             public void onClick(View v) {
//                 MediaItem url = MediaItem.fromUri("http://150.136.165.107:8000/radio.mp3");
//                 exoPlayer.setMediaItem(url);
//                 exoPlayer.prepare();
//                 exoPlayer.play();
//                 tvEstado.setText("reproduciendo...");
//
//
//             }
//         });
//
//         stopButton.setOnClickListener(new View.OnClickListener() {
//             @Override
//             public void onClick(View v) {
//                 exoPlayer.stop();
//                 tvEstado.setText("detenido");
//
//             }
//         });


         tabla = findViewById(R.id.tabla);

         nombreEstacion = new ArrayList<String>();
         nombreEstacion.add("tuplanetaonline");
        nombreEstacion.add("Arboledas stereo FM");
        nombreEstacion.add("Belencita stereo FM");
        nombreEstacion.add("mi gente 101.7 FM");
        nombreEstacion.add("sagrado corazon FM");
        nombreEstacion.add("Olimpica stereo");
        nombreEstacion.add("Tropicana Stereo");
        nombreEstacion.add("Lavoz de Toledo FM");


        descripcionEstacion = new ArrayList<String>();
        descripcionEstacion.add("emisora con enfasis ecologico, emite desde Chinacota");
        descripcionEstacion.add("emisora comunitaria de Arboledas");
        descripcionEstacion.add("emisora belencita estereo de Salazar de las palmas");
        descripcionEstacion.add("Radio difusora de interes publico de Cucutilla");
        descripcionEstacion.add("transmitiendo desde Bochalema");
        descripcionEstacion.add("emite desde Cúcuta");
        descripcionEstacion.add("emite desde Cúcuta");
        descripcionEstacion.add("la autentica, emite desde Toledo");

        urlEnviar_elemento = new ArrayList<String>();
        urlEnviar_elemento.add("http://150.136.165.107:8000/radio.mp3");//tuplanetaonline
        urlEnviar_elemento.add("https://stream.integracionvirtual.com/proxy/arboleda?mp=/stream");//arboledas
        urlEnviar_elemento.add("https://stream.zenolive.com/3ncca6asuf9uv");//salazar
        urlEnviar_elemento.add("http://stream.zeno.fm/7gp9phwgr0hvv?1680826211449");//cucutilla
        urlEnviar_elemento.add("https://estructuraweb.com.co:9069/live");//Bochalema
        urlEnviar_elemento.add("https://24073.live.streamtheworld.com/OLP_CUCUTAAAC.aac");//olimpica stereo
        urlEnviar_elemento.add("https://22203.live.streamtheworld.com/TROPICANA_SC");//tropicana
        urlEnviar_elemento.add("https://stream2.emisorasvirtuales.com/proxy/toledo/stream");//la voz de toledo

        int[] imagenes = {
                R.drawable.logo1,
                R.drawable.davidradio,
                R.drawable.monalizacelular,
                R.drawable.monorayas,
                R.drawable.gatico,
                R.drawable.pajaroraro,
                R.drawable.pajaro,
                R.drawable.perro

        };

        Adaptador adaptador = new Adaptador(this, R.layout.elemento, nombreEstacion, descripcionEstacion, imagenes, urlEnviar_elemento);
        tabla.setAdapter(adaptador);
        tabla.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(MainActivity.this, "escuchas: "+ nombreEstacion.get(position), Toast.LENGTH_SHORT).show();

                    MediaItem url = MediaItem.fromUri(urlEnviar_elemento.get(position));
                    exoPlayer.setMediaItem(url);
                    exoPlayer.prepare();
                    exoPlayer.play();

                    isPlaying = true;
                tvEstado.setText("reproduciendo...");
                // Programa la aparición y desaparición del texto
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (isVisible) {
                            tvEstado.setVisibility(View.INVISIBLE);
                            isVisible = false;
                        } else {
                            tvEstado.setVisibility(View.VISIBLE);
                            isVisible = true;
                        }
                        handler.postDelayed(this, 3000); // Programa la próxima ejecución después de 1 segundo
                    }
                }, 3000); // Programa la primera ejecución después de 1 segundo

                if (isPlaying){
                    stopButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            exoPlayer.stop();
                            tvEstado.setText("detenido");

                        }
                    });
                }
                btnPlay.setOnClickListener(new View.OnClickListener() {
//
             public void onClick(View v) {
                 exoPlayer.setMediaItem(url);
                 exoPlayer.prepare();
                 exoPlayer.play();
                 tvEstado.setText("reproduciendo...");


             }
         });

            }
        });
    }

}
