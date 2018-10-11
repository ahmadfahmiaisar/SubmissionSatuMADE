package com.example.user.bismillahsub1.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.user.bismillahsub1.DetailMovie;
import com.example.user.bismillahsub1.Helper;
import com.example.user.bismillahsub1.R;
import com.example.user.bismillahsub1.pojo.ItemResponse;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {
    private Context context;
    private ArrayList<ItemResponse> listMovie;

    public ItemAdapter(Context context, ArrayList<ItemResponse> listMovie) {
        this.context = context;
        this.listMovie = listMovie;
    }

    @NonNull
    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_list_movie, viewGroup, false);
        return new ViewHolder(view);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivMovie;
        TextView tvTitle;
        TextView tvOverview;
        TextView tvRelease;
        CardView cvDetail;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivMovie = itemView.findViewById(R.id.image_poster);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvOverview = itemView.findViewById(R.id.tv_overview);
            tvRelease = itemView.findViewById(R.id.tv_releaseDate);
            cvDetail = itemView.findViewById(R.id.cv_listMovie);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull final ItemAdapter.ViewHolder viewHolder, final int i) {
        viewHolder.tvTitle.setText(listMovie.get(i).getTitle_movie());
        viewHolder.tvOverview.setText(listMovie.get(i).getOverview_movie());
        viewHolder.tvRelease.setText(listMovie.get(i).getRelease_movie());
        Glide.with(context)
                .load("http://image.tmdb.org/t/p/w185" + listMovie.get(i).getPoster_movie())
                .into(viewHolder.ivMovie);

        viewHolder.cvDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailMovie.class);
                //Bundle bundle = new Bundle();
                intent.putExtra(Helper.POSTER, "http://image.tmdb.org/t/p/w185" + listMovie.get(i).getPoster_movie());
                intent.putExtra(Helper.TITTLE, viewHolder.tvTitle.getText().toString().trim());
                intent.putExtra(Helper.OVERVIEW, listMovie.get(i).getOverview_movie());
                intent.putExtra(Helper.RELEASE_DATE, viewHolder.tvRelease.getText().toString().trim());
                intent.putExtra(Helper.BACKDROP, "http://image.tmdb.org/t/p/w185" + listMovie.get(i).getBackdrop_movie());
                intent.putExtra(Helper.POPULAR_MOVIE, listMovie.get(i).getPopular());
                intent.putExtra(Helper.RATING_MOVIE, listMovie.get(i).getVote());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listMovie.size();
    }
}
