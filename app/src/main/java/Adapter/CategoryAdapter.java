package Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicapp.R;

import java.util.ArrayList;

import Model.Category;


public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    Activity context;
    ArrayList<Category> arrCate;

    public CategoryAdapter(Activity context,ArrayList<Category> arr_NhanVien){
        this.context=context;
        this.arrCate=arr_NhanVien;
    }

    @NonNull
    @Override
    public CategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View viewNhanvien=layoutInflater.inflate(R.layout.theloai_items,parent,false);
        CategoryAdapter.ViewHolder viewHolderNV=new CategoryAdapter.ViewHolder(viewNhanvien);
        return  viewHolderNV;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.ViewHolder holder, int position) {
        Category item=arrCate.get(position);

        holder.tvNameCate.setText(item.getCate());

        holder.imgCate.setImageResource(item.getImgCate());

    }

    @Override
    public int getItemCount() {
        return arrCate.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgCate;
        TextView tvNameCate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNameCate=itemView.findViewById(R.id.tvCate);
            imgCate=itemView.findViewById(R.id.imgCate);

        }
    }
}
