package com.example.jcpgamestore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;

import com.example.jcpgamestore.model.Cart;
import com.example.jcpgamestore.model.DataGame;
import com.example.jcpgamestore.model.User;

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

    //TODO: Populate the logged user
    private User loggedUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = DatabaseHelper.getInstance(this);
        myRecycle = findViewById(R.id.recycleView);
        myRecycle.setHasFixedSize(true);
        myOnClickListener = new MyOnClickListener(this);
        layoutManager = new LinearLayoutManager(this);
        myRecycle.setLayoutManager(layoutManager);

        //TODO: Remove
        loggedUser = new User();
        loggedUser.setId( 100000 );
        loggedUser.setFullName( "Paulo" );
        loggedUser.setEmail( "paulo@gmail.com" );

        data = new ArrayList<>();
        adapter = new CustomAdapter(data);
        myRecycle.setAdapter(adapter);
        adapter.setUser( loggedUser );
        loadGameData();
    }

    private void loadGameData() {
        List<DataGame> productsFromDB = myDb.loadGames();
        if (productsFromDB.isEmpty()) {
            // TODO Move to the onCreate database helper method
            myDb.addProduct( "Avengers", 79.99, R.drawable.avengers );
            myDb.addProduct( "Call of Duty: Modern Warfare", 79.99, R.drawable.callofduty );
            myDb.addProduct( "CyberPunk 2077", 79.99, R.drawable.cyberpunk2077 );
            myDb.addProduct( "Final Fantasy VII: Remake", 79.99, R.drawable.ffviiremake );
            myDb.addProduct( "God of War", 39.99, R.drawable.godofwar );
            myDb.addProduct( "Gran Turismo", 24.99, R.drawable.granturismo );
            myDb.addProduct( "Street Fighter V", 24.99, R.drawable.streetfighter5 );
            myDb.addProduct( "UFC 3", 19.99, R.drawable.ufc3 );

            productsFromDB = myDb.loadGames();
        }

        adapter.updateDataSet( productsFromDB );

    }

    private class MyOnClickListener implements View.OnClickListener {
        public MyOnClickListener(Context context    ) {
            Log.d("Click", "click");
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
        final Intent intent = new Intent( MainActivity.this, CartActivity.class );
        ArrayList carts = adapter.getCarts();
        intent.putStringArrayListExtra("CART", carts);

        cart_icon.setOnMenuItemClickListener( new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                startActivity(intent);
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








