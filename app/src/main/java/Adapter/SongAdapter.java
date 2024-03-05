package Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicapp.R;

import java.util.ArrayList;

import Model.Music;
import fragment.IndexFragment;
import myinterface.icClickItem;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.ViewHolder> {

    Context context;
    ArrayList<Music> arrMusic;
    icClickItem icClickItems;

    public SongAdapter(Context context, ArrayList<Music> arr_NhanVien){
        this.context=  context;
        this.arrMusic=arr_NhanVien;
    }
    public SongAdapter( Context context,ArrayList<Music> arr_NhanVien,icClickItem icClick){
        this.context=  context;
        this.arrMusic=arr_NhanVien;
        this.icClickItems = icClick;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View viewNhanvien=layoutInflater.inflate(R.layout.song_items,parent,false);
        ViewHolder viewHolderNV=new ViewHolder(viewNhanvien);
        return  viewHolderNV;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Music item=arrMusic.get(position);

        holder.tvName.setText(item.getTitle());
        holder.tvArtist.setText(item.getArtist());
        holder.imgUser.setImageResource(item.getImage());
        holder.cardSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                icClickItems.onClickItem(item);
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrMusic.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgUser;
        TextView tvName,tvArtist;
        CardView cardSong;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvArtist=itemView.findViewById(R.id.tvNameSinger);
            tvName=itemView.findViewById(R.id.tvNameSong);
            imgUser=itemView.findViewById(R.id.imgSong);
            cardSong = itemView.findViewById(R.id.cardSong);

        }
    }

}
