package com.example.newsapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kwabenaberko.newsapilib.models.Article;
import com.squareup.picasso.Picasso;

import java.util.List;

public class NewsRecyclerAdapter extends RecyclerView.Adapter<NewsRecyclerAdapter.NewsViewHolder> {

    List<Article> articleList;
    NewsRecyclerAdapter(List<Article> articleList)
    {
        this.articleList=articleList;
    }

    @NonNull
    @Override
    public NewsRecyclerAdapter.NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_recycler_item,parent,false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsRecyclerAdapter.NewsViewHolder holder, int position) {

        Article  article=articleList.get(position);
        holder.titletextview.setText(article.getTitle());
        holder.sourcetextview.setText(article.getDescription());
        Picasso.get().load(article.getUrlToImage())
                .error(R.drawable.no_image_icon)
                .placeholder(R.drawable.no_image_icon)
                .into(holder.imageView);

    }

    void updateData(List<Article> data)
    {
        articleList.clear();
        articleList.addAll(data);
    }
    @Override
    public int getItemCount() {
        return articleList.size();
    }

    class NewsViewHolder extends RecyclerView.ViewHolder
    {
        TextView titletextview,sourcetextview;
        ImageView imageView;

        public NewsViewHolder(@NonNull View itemView){
            super(itemView);
            titletextview=itemView.findViewById(R.id.article_title);
            sourcetextview=itemView.findViewById(R.id.article_source);
            imageView=itemView.findViewById(R.id.article_image_view);

        }
    }
}
