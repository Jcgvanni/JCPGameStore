package com.example.jcpgamestore;

import androidx.appcompat.app.AppCompatActivity;
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
    List<String> gameList = new ArrayList<>();
    List<Integer> gamePic = new ArrayList<>();
    List<Integer> gameMusic = new ArrayList<>();
    MediaPlayer currentSong = new MediaPlayer();
    private SearchView mSearchView;

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
        ListView listViewGames = findViewById(R.id.listGames );
        listViewGames.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, gameList));
        MyCustomAdapter myAdapter = new MyCustomAdapter( this,gameList, gamePic );
        listViewGames.setAdapter( myAdapter );
        listViewGames.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position){
                    case 0:
                       // startActivity(new Intent(MainActivity.this, ShoppingCart.class));
                        break;
                    case 1 :
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        break;
                }

            }
        } );

    }
    //Search widget in Menu Bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate( R.menu.menu_search, menu );
        MenuItem item = menu.findItem( R.id.menuSearch );
        SearchView searchView = (SearchView)item.getActionView();

        searchView.setOnQueryTextListener( new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        } );

        return super.onCreateOptionsMenu( menu );
    }
}
