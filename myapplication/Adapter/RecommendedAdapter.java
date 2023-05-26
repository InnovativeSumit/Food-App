package com.example.myapplication.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.Activity.ShowDetailActivity;
import com.example.myapplication.Domain.RecommendedDomains;
import com.example.myapplication.Domain.FoodDomain;
import com.example.myapplication.R;

import java.util.ArrayList;

public class RecommendedAdapter extends RecyclerView.Adapter<RecommendedAdapter.ViewHolder> {
    ArrayList<FoodDomain> categoryDomains;

    public RecommendedAdapter(ArrayList<FoodDomain> categoryDomains) {
        this.categoryDomains = categoryDomains;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_recommended, parent, false);

        return new ViewHolder(inflate);
    }
@Override
public void onBindViewHolder(@NonNull ViewHolder holder, int position){
        holder.title.setText(categoryDomains.get(position).getTitle());
        holder.fee.setText(String.valueOf(RecommendedDomains.get(position).getFee()));

        int drawableReourceId=holder.itemView.getContext().getResources()
                .getIdentifier(RecommendedDomains.get(position).getPic(),"drawable",
                        holder.itemView.getContext().getPackageName());
    Glide.with(holder.itemView.getContext())
            .load(drawableReourceId)
            .into(holder.Pic);
    holder.addBtn.setOnClickListener(view -> {
        Intent intent=new Intent(holder.itemView.getContext(), ShowDetailActivity.class);
        Intent.putExtra("object",RecommendedDomains.get(position));
        holder.itemView.getContext().startActivity(intent);

    });
    }

    @Override
    public int getItemCount() { return RecommendedDomains.size(); }

    public class ViewHolder extends  RecyclerView.ViewHolder {
        TextView title,fee;
        ImageView Pic;
       ImageView addBtn;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.title);
            Pic=itemView.findViewById(R.id.pic);
           fee=itemView.findViewById(R.id.fee);
           addBtn=itemView.findViewById(R.id.addBtn);
        }
    }

}
