package Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicapp.R;

import java.util.ArrayList;

import Model.Music;
import fragment.LibararyFragment;

public class TrendingAdapter extends RecyclerView.Adapter<TrendingAdapter.ViewHolder> {
    Context context;
    ArrayList<Music> arrMusic;

    public TrendingAdapter(Context context, ArrayList<Music> arr_NhanVien){
        this.context=  context;
        this.arrMusic=arr_NhanVien;
    }

    @NonNull
    @Override
    public TrendingAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View viewNhanvien=layoutInflater.inflate(R.layout.trending_items,parent,false);
        TrendingAdapter.ViewHolder viewHolderNV=new TrendingAdapter.ViewHolder(viewNhanvien);
        return  viewHolderNV;
    }

    @Override
    public void onBindViewHolder(@NonNull TrendingAdapter.ViewHolder holder, int position) {
        Music item=arrMusic.get(position);


        holder.tvName.setText(item.getTitle());
        holder.tvArtist.setText(item.getArtist());
        holder.imgUser.setImageResource(item.getImage());

    }

    @Override
    public int getItemCount() {
        return arrMusic.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgUser;
        TextView tvName,tvArtist;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvArtist=itemView.findViewById(R.id.tvSingerTreding);
            tvName=itemView.findViewById(R.id.tvNameSongTrending);
            imgUser=itemView.findViewById(R.id.imgTrending);

        }
    }
}
