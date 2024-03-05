package com.example.musicapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import Adapter.SongAdapter;
import Adapter.TrendingAdapter;
import Model.Music;

public class Index extends AppCompatActivity {
    RecyclerView rvSong,rvTrending;
    SongAdapter songAdapter;
    TrendingAdapter trendingAdapter;
    ArrayList<Music> arrMusic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        arrMusic = new ArrayList<Music>();
        arrMusic.add(new Music(R.drawable.wn,"3107","W/n  ft 267"));
        arrMusic.add(new Music(R.drawable.wn,"3107","W/n  ft 267"));
        arrMusic.add(new Music(R.drawable.wn,"3107","W/n  ft 267"));
        arrMusic.add(new Music(R.drawable.wn,"3107","W/n  ft 267"));
        arrMusic.add(new Music(R.drawable.wn,"3107","W/n  ft 267"));
        arrMusic.add(new Music(R.drawable.wn,"3107","W/n  ft 267"));
        arrMusic.add(new Music(R.drawable.wn,"3107","W/n  ft 267"));
        arrMusic.add(new Music(R.drawable.wn,"3107","W/n  ft 267"));
        rvSong = findViewById(R.id.rvSong);
        rvTrending = findViewById(R.id.rvTrending);
        songAdapter = new SongAdapter(this, arrMusic);
        trendingAdapter = new TrendingAdapter(this,arrMusic);

        rvSong.setAdapter(songAdapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1);
        rvSong.setLayoutManager((gridLayoutManager));

        rvTrending.setAdapter(trendingAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        rvTrending.setLayoutManager(linearLayoutManager);
    }
}