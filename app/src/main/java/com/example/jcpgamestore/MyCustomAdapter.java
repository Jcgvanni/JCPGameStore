package com.example.jcpgamestore;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

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
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
