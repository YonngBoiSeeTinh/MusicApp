package com.example.musicapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TabHost;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import Adapter.ViewPagerAdapter;
import Model.Music;
import fragment.IndexFragment;

public class MainActivity extends AppCompatActivity {


    TabLayout mtabLayout;
    ViewPager mviewPager;
    ImageView imgSongPlay;
    ImageButton btnPlay, btnPre, btnNext;
    SeekBar seekBar;
    TextView tvTitlePlay, tvArtistPlay,tvTime,tvTotal;
    ArrayList<Music> arrMusic,arrTrending,arrFavorite;
    String titlePlay, artistPlay;
    int filePlay, imgPlay,positon = 0;
    boolean choosed;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mviewPager.setAdapter(viewPagerAdapter);
        mtabLayout.setupWithViewPager(mviewPager);
        mtabLayout.getTabAt(0).setIcon(R.drawable.homeicon);
        mtabLayout.getTabAt(1).setIcon(R.drawable.search_icon);
        mtabLayout.getTabAt(2).setIcon(R.drawable.library_icon);

        arrFavorite = new ArrayList<Music>();
        arrMusic = new ArrayList<Music>();
        arrTrending = new ArrayList<Music>();
        getData();
        senDataToFragment();

        LayoutSongPlay();
        mediaPlayer = MediaPlayer.create(this,filePlay);

        if(choosed) {
            if(mediaPlayer.isPlaying()) mediaPlayer.stop();
            mediaPlayer = MediaPlayer.create(this,arrMusic.get(positon).getFile());
            mediaPlayer.start();
        }

    }

    private void SetTimeTotal(){
        SimpleDateFormat timeFomart = new SimpleDateFormat("mm:ss");
        tvTotal.setText(timeFomart.format(mediaPlayer.getDuration()));
        //gán max của seekbar = mediaPlayer.getDuration()
        seekBar.setMax(mediaPlayer.getDuration());
    }
    private void MediaStar(){


    }
    public void LayoutSongPlay(){

        Intent i = getIntent();
        imgPlay =  i.getIntExtra("img",R.drawable.wn);
        filePlay = i.getIntExtra("file",R.raw.bandoi);
        titlePlay = i.getStringExtra("title");
        artistPlay =i.getStringExtra("artist");
        choosed = i.getBooleanExtra("choose",false);
        positon = i.getIntExtra("position",0);
        if(titlePlay == null || titlePlay.isEmpty()){
            imgSongPlay.setImageResource( R.drawable.wn);
            tvArtistPlay.setText("Chưa chọn bài hát");
        }
        else{
            imgSongPlay.setImageResource( imgPlay);
            tvArtistPlay.setText(artistPlay);
            tvTitlePlay.setText(titlePlay);
        }
    }

    public void AnhXa(){
        mtabLayout = findViewById(R.id.tabLayout);
        mviewPager = findViewById(R.id.viewPager);
        imgSongPlay = findViewById(R.id.imgSongpl);
        imgSongPlay = findViewById(R.id.imgSongpl);
        tvTitlePlay = findViewById(R.id.tvTitlepl);
        tvArtistPlay = findViewById(R.id.tvArtistpl);
        btnNext = findViewById(R.id.btnNext);
        btnPlay = findViewById(R.id.btnPlay);
        btnNext = findViewById(R.id.btnNext);
        seekBar = findViewById(R.id.seekbar);
    }


    public ArrayList<Music> getArrMusic() {
        return arrMusic;
    }

    public void setArrMusic(ArrayList<Music> arrMusic) {
        this.arrMusic = arrMusic;
    }

    public ArrayList<Music> getArrTrending() {
        return arrTrending;
    }

    public void setArrTrending(ArrayList<Music> arrTrending) {
        this.arrTrending = arrTrending;
    }

    void senDataToFragment(){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.viewPager,new IndexFragment());
        fragmentTransaction.commit();
    }

    void getData(){
        arrMusic.add(new Music(0,R.drawable.wn,"3107 id 2022","W/n ft 267",R.raw.wn));
        arrMusic.add(new Music(1,R.drawable.chungtadayeunhau,"Bạn đời","Karik",R.raw.bandoi));

        arrTrending.add(new Music(0,R.drawable.wn,"3107 id 2022","W/n ft 267",R.raw.wn));
        arrTrending.add(new Music(1,R.drawable.chungtadayeunhau,"Bạn đời","Karik",R.raw.bandoi));
    }


}