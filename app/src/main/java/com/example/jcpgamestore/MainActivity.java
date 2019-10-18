package com.example.jcpgamestore;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<String> gameList = new ArrayList<>();
    List<Integer> gamePic = new ArrayList<>();
    List<Integer> gameMusic = new ArrayList<>();
    MediaPlayer currentSong = new MediaPlayer();

    private void addItems(){
        gameList.add("Avengers");
        gamePic.add(R.drawable.avengers);
        //gameMusic.add(R.raw.);
        gameList.add("Call of Duty: Modern Warfare");
        gamePic.add(R.drawable.callofduty);
        //gameMusic.add(R.raw.);
        gameList.add("Cyberpunk 2077");
        gamePic.add(R.drawable.cyberpunk2077);
        //gameMusic.add(R.raw.);
        gameList.add("Final Fantasy VII: Remake");
        gamePic.add(R.drawable.ffviiremake);
       // gameMusic.add(R.raw.);
        gameList.add("Gran Turismo");
        gamePic.add(R.drawable.granturismo);
        //gameMusic.add(R.raw.);
        gameList.add("God of War");
        gamePic.add(R.drawable.godofwar);
        //gameMusic.add(R.raw.);
        gameList.add("Street Fighter V");
        gamePic.add(R.drawable.streetfighter5);
        //gameMusic.add(R.raw.);
        gameList.add("UFC 3");
        gamePic.add(R.drawable.ufc3);
        //gameMusic.add(R.raw.);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addItems();
        final ListView listGames = findViewById(R.id.listGame);
        listGames.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, gameList));
    }
}
