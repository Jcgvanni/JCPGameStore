package com.example.jcpgamestore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SearchView mSearchView;
    private static RecyclerView myRecycle;
    static View.OnClickListener myOnClickListener;
    private RecyclerView.LayoutManager layoutManager;
    private static ArrayList<DataGame> data;
    private static RecyclerView.Adapter adapter;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            myRecycle = findViewById(R.id.recycleView);
            myRecycle.setHasFixedSize(true);
            myOnClickListener = new MyOnClickListener(this);
            layoutManager = new LinearLayoutManager(this);
            myRecycle.setLayoutManager(layoutManager);

            data = new ArrayList<>();
            for (int i = 0; i < myGames.gameName.length; i++){
                data.add(new DataGame(
                        myGames.gameName[i],
                        myGames.gameRelease[i],
                        myGames.gameImages[i],
                        myGames.gameMusics[i]));
            }
            adapter = new CustomAdapter(data);
            myRecycle.setAdapter(adapter);

        }

        private class MyOnClickListener implements View.OnClickListener {
            public MyOnClickListener(Context context    ) {
            }
            @Override
            public void onClick(View v){


            }
        }
    }








