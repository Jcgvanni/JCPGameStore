package com.example.jcpgamestore;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

public class MyCustomAdapter extends BaseAdapter {
    List<String> myList = new ArrayList<>();
    List<Integer> myPics = new ArrayList<>();
    int currentPlayingIdx;
    Context context;

    public MyCustomAdapter(Context anyContext, List<String> anyList, List<Integer> anyPics){
        //application context can be a variety of things to pass from one activity to another
        context = anyContext;
        myList = anyList;
        myPics = anyPics;
        //initialize the position of songs
        currentPlayingIdx = -1;//no song is playing (-1)
    }

    //get index
    public int getCurrentPlayingIdx(){
        return currentPlayingIdx;
    }
    //set index
    public void setCurrentPlayingIdx(int idx){
        currentPlayingIdx = idx;
        notifyDataSetChanged();//every time change same data you have to call the method datasetchanged
    }
    @Override
    public int getCount() {
        return myList.size();
    }

    @Override
    public Object getItem(int position) {
        return myPics.get( position );
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            LayoutInflater mylayoutInflater = LayoutInflater.from(context);
            convertView = mylayoutInflater.inflate(R.layout.layout_external, parent, false);

        }
        TextView txtViewItem = convertView.findViewById(R.id.txtViewItem );
        txtViewItem.setText(myList.get(position));


        Drawable img = ContextCompat.getDrawable( parent.getContext(), myPics.get( position ) );
        img.setBounds(0,0,100,100);

        Drawable imgCart = ContextCompat.getDrawable( parent.getContext(), R.drawable.addcart );
        //Drawable imgCart = ContextCompat.getDrawable( parent.getContext(), R.drawable.);
        //if (currentPlayingIdx == position){
           // imgAddCart = ContextCompat.getDrawable(parent.getContext(), R.drawable.stop);
        //}
        imgCart.setBounds(0,0,100,100);

        txtViewItem.setCompoundDrawables(img, null, imgCart, null);
        txtViewItem.setCompoundDrawablePadding(32);
        txtViewItem.setGravity( Gravity.CENTER_VERTICAL);

        return convertView;
    }
}

