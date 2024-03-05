package com.example.musicapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import Model.Music;

public class song_play extends AppCompatActivity {

    ImageView imgSong;
    ImageButton btnPlay, btnPre, btnNext;
    SeekBar seekBar;
    TextView tvTitle, tvArtist,tvTime,tvTotal;
    int positon = 0;
    Animation animation;
    MediaPlayer mediaPlayer;
    ArrayList<Music> musicList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_play);

        AnhXa();
        AddSong();
        animation = AnimationUtils.loadAnimation(this,R.anim.rotate_img);

        MediaStar();

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                    btnPlay.setImageResource(R.drawable.play_icon);
                
                }
                else{
                    imgSong.startAnimation(animation);
                    mediaPlayer.start();
                    btnPlay.setImageResource(R.drawable.stopbtn_foreground);
                }
                SetTimeTotal();
                UpdateTime();

            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                positon++;
                if(positon > musicList.size()-1){
                    positon = 0;
                }
                if(mediaPlayer.isPlaying()) mediaPlayer.stop();
                MediaStar();
                mediaPlayer.start();
                btnPlay.setImageResource(R.drawable.stopbtn_foreground);
                SetTimeTotal();
                UpdateTime();
            }
        });
        btnPre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                positon--;
                if(positon <0) positon = musicList.size()-1;
                if(mediaPlayer.isPlaying()) mediaPlayer.stop();
                MediaStar();
                mediaPlayer.start();
                SetTimeTotal();
                UpdateTime();
                btnPlay.setImageResource(R.drawable.stopbtn_foreground);
            }
        });
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //sau khi thả tay mới tua
                mediaPlayer.seekTo(seekBar.getProgress());

            }
        });

    }
    private void UpdateTime(){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SimpleDateFormat timeFomart = new SimpleDateFormat("mm:ss");
                tvTime.setText(timeFomart.format(mediaPlayer.getCurrentPosition()));
                //update progress cua seekbar
                seekBar.setProgress(mediaPlayer.getCurrentPosition());
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        positon++;
                        if(positon > musicList.size()-1) positon = 0;
                        if(mediaPlayer.isPlaying()) mediaPlayer.stop();
                        MediaStar();
                        mediaPlayer.start();
                        btnPlay.setImageResource(R.drawable.stopbtn_foreground);
                        SetTimeTotal();
                        UpdateTime();
                    }
                });
                handler.postDelayed(this,100);
            }
        },100);
    }
    private void SetTimeTotal(){
        SimpleDateFormat timeFomart = new SimpleDateFormat("mm:ss");
        tvTotal.setText(timeFomart.format(mediaPlayer.getDuration()));
        //gán max của seekbar = mediaPlayer.getDuration()
        seekBar.setMax(mediaPlayer.getDuration());
    }
    private void MediaStar(){
        mediaPlayer = MediaPlayer.create(this,musicList.get(positon).getFile());
        tvTitle.setText(musicList.get(positon).getTitle());
        tvArtist.setText(musicList.get(positon).getArtist());
        imgSong.setImageResource(musicList.get(positon).getImage());
    }
    private void AddSong(){
        musicList = new ArrayList<>();
        musicList.add(new Music(R.drawable.wn,"3107 id 2022","W/n ft 267",R.raw.wn));
        musicList.add(new Music(R.drawable.chungtadayeunhau,"Bạn đời","Karik",R.raw.bandoi));
    }
    private void AnhXa(){
        imgSong = findViewById(R.id.imgSong);
        btnNext = findViewById(R.id.btnNext);
        btnPlay = findViewById(R.id.btnPlay);
        btnPre = findViewById(R.id.btnPre);
        seekBar =findViewById(R.id.seekbar);
        tvArtist = findViewById(R.id.tvArtist);
        tvTitle = findViewById(R.id.tvTitle);
        tvTime = findViewById(R.id.tvTime);
        tvTotal = findViewById(R.id.tvTotalTime);
    }
}