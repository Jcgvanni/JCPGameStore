package com.example.jcpgamestore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    private SearchView mSearchView;
    private static RecyclerView myRecycle;
    static View.OnClickListener myOnClickListener;
    private RecyclerView.LayoutManager layoutManager;
    private static ArrayList<DataGame> data;
    private CustomAdapter adapter;
    private ImageView cart_icon;

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
            for(int i = 0; i < myGames.gameName.length; i++){
                data.add(new DataGame(
                        myGames.gameName[i],
                        myGames.gamePrice[i],
                        myGames.gameImages[i]));

            }
            adapter = new CustomAdapter(data);
            myRecycle.setAdapter(adapter);
            myDb = new DatabaseHelper(this);
            myDb.addGameData("Avengers", 79.99);
            myDb.addGameData("Call of Duty: Modern Warfare", 79.99);
            myDb.addGameData("CyberPunk 2077", 79.99);
            myDb.addGameData("Final Fantasy VII: Remake", 79.99);
            myDb.addGameData("God of War", 39.99);
            myDb.addGameData("Gran Turismo", 24.99);
            myDb.addGameData("Street Fighter V", 24.99);
            myDb.addGameData("UFC 3", 19.99);


        }
    private class MyOnClickListener implements View.OnClickListener {
        public MyOnClickListener(Context context    ) {
        }
        @Override
        public void onClick(View v){

        }
    }
    //Search widget in Menu Bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflate the menu;
        MenuInflater inflater = getMenuInflater();
        inflater.inflate( R.menu.menu_search, menu );

        //Cart Icon to check out
        MenuItem cart_icon = menu.findItem(R.id.menuCart);
        cart_icon.setOnMenuItemClickListener( new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                startActivity( new Intent( MainActivity.this, CartActivity.class ) );
                return true;
            }
        } );



        MenuItem item = menu.findItem( R.id.menuSearch );
        SearchView searchView = (SearchView)item.getActionView();
        searchView.setOnQueryTextListener( new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        } );

        return super.onCreateOptionsMenu( menu );
    }


}








