package com.example.musicapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import Adapter.SongAdapter;
import Adapter.TrendingAdapter;
import Model.Music;

public class Libarary extends AppCompatActivity {
    RecyclerView rvLibra;
    SongAdapter songAdapter;
    TrendingAdapter trendingAdapter;
    ArrayList<Music> arrMusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_libarary);
        arrMusic = new ArrayList<Music>();
        arrMusic.add(new Music(R.drawable.wn,"3107","W/n  ft 267"));
        arrMusic.add(new Music(R.drawable.wn,"3107","W/n  ft 267"));
        arrMusic.add(new Music(R.drawable.wn,"3107","W/n  ft 267"));
        arrMusic.add(new Music(R.drawable.wn,"3107","W/n  ft 267"));
        arrMusic.add(new Music(R.drawable.wn,"3107","W/n  ft 267"));
        arrMusic.add(new Music(R.drawable.wn,"3107","W/n  ft 267"));
        arrMusic.add(new Music(R.drawable.wn,"3107","W/n  ft 267"));
        arrMusic.add(new Music(R.drawable.wn,"3107","W/n  ft 267"));
        rvLibra = findViewById(R.id.rvLibra);
        songAdapter = new SongAdapter(this, arrMusic);
        trendingAdapter = new TrendingAdapter(this,arrMusic);

        rvLibra.setAdapter(songAdapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1);
        rvLibra.setLayoutManager((gridLayoutManager));
    }
}