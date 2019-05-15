package com.example.app4;

import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class description extends AppCompatActivity {
    Button bp, bps,bs;
    MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_description );
        bp = findViewById( R.id.button_play );
        bps = findViewById( R.id.button_pause );
        bs = findViewById( R.id.button_stop );
    }


    public void play(View v) {
        if (player == null) {
            player = MediaPlayer.create( this, R.raw.rhapsody);
            player.setOnCompletionListener( new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopPlayer();
                }
            } );
        }
        player.start();
        Toast.makeText( this, "Romanian Rhapsody by George Enescu is playing", Toast.LENGTH_LONG ).show();

    }

    public void pause(View v) {
        if (player != null) {
            player.pause();
        }
    }

    public void stop(View v) {
        stopPlayer();
    }

    private void stopPlayer() {
        if (player != null) {
            player.release();
            player = null;
            Toast.makeText( this, "Romanian Rhapsody by George Enescu has stopped", Toast.LENGTH_LONG ).show();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopPlayer();
    }
}
