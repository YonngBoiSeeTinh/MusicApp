package fragment;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicapp.MainActivity;
import com.example.musicapp.R;

import java.io.Serializable;
import java.util.ArrayList;

import Adapter.SongAdapter;
import Adapter.TrendingAdapter;
import Model.Music;
import myinterface.icClickItem;

public class IndexFragment extends Fragment {

    public IndexFragment() {

    }

    RecyclerView rvSong, rvTrending;
    SongAdapter songAdapter;
    TrendingAdapter trendingAdapter;
    ArrayList<Music> arrMusic;



    MainActivity mainActivity;
    ArrayList<Music> trendingList;
    Music song;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Gắn layout cho fragment
        View view = inflater.inflate(R.layout.fragment_index, container, false);
        arrMusic = new ArrayList<Music>();
        trendingList = new ArrayList<Music>();
        rvSong = view.findViewById(R.id.rvSong);
        rvTrending = view.findViewById(R.id.rvTrending);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mainActivity = (MainActivity) getActivity();
        arrMusic = mainActivity.getArrMusic();
        trendingList = mainActivity.getArrTrending();
        rvSong = view.findViewById(R.id.rvSong);
        rvTrending = view.findViewById(R.id.rvTrending);

        songAdapter = new SongAdapter(getContext(),arrMusic, new icClickItem() {
            @Override
            public void onClickItem(Music music) {

                Intent i = new Intent(getContext(), MainActivity.class);
                i.putExtra("img", music.getImage());
                i.putExtra("choose", true);
                i.putExtra("title", music.getTitle());
                i.putExtra("artist", music.getArtist());
                i.putExtra("file", music.getFile());
                i.putExtra("positon",music.getId());
                startActivity(i);

            }
        });
        trendingAdapter = new TrendingAdapter(getContext(),arrMusic);

        rvSong.setAdapter(songAdapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 1);
        rvSong.setLayoutManager((gridLayoutManager));

        rvTrending.setAdapter(trendingAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false);
        rvTrending.setLayoutManager(linearLayoutManager);


    }
}
