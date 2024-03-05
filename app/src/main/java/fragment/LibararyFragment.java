package fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicapp.R;

import java.util.ArrayList;

import Adapter.SongAdapter;
import Adapter.TrendingAdapter;
import Model.Music;
import myinterface.icClickItem;


public class LibararyFragment extends Fragment {


    public LibararyFragment() {

    }


    RecyclerView rvSong;
    SongAdapter songAdapter;



    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_libarary, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ArrayList<Music> arrMusic = new ArrayList<Music>();
        arrMusic.add(new Music(R.drawable.wn,"3107","W/n  ft 267"));
        arrMusic.add(new Music(R.drawable.wn,"3107","W/n  ft 267"));
        arrMusic.add(new Music(R.drawable.wn,"3107","W/n  ft 267"));
        arrMusic.add(new Music(R.drawable.wn,"3107","W/n  ft 267"));

        rvSong = view.findViewById(R.id.rvSong2);

        songAdapter = new SongAdapter(getContext(),arrMusic, new icClickItem() {
            @Override
            public void onClickItem(Music music) {


            }
        });
        rvSong.setAdapter(songAdapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 1);
        rvSong.setLayoutManager((gridLayoutManager));


    }
}


//