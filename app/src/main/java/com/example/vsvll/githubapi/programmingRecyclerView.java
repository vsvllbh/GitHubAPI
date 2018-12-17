package com.example.vsvll.githubapi;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.bumptech.glide.Glide;


public class programmingRecyclerView extends RecyclerView.Adapter<programmingRecyclerView.myViewHolder> {

    Data[] data;
    Context context;

    public programmingRecyclerView(Context context,Data[] Data) {
        this.data = Data;
        this.context = context;
    }


    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.row_single, viewGroup, false);

        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final myViewHolder myViewHolder, int i) {
             final Data d = data[i];
            myViewHolder.textView.setText(d.getLogin());
            Glide.with(myViewHolder.imageView.getContext()).load(d.getAvatarUrl()).into(myViewHolder.imageView);

           myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {

                   Intent intent = new Intent(myViewHolder.imageView.getContext(), particularItem.class);
                   intent.putExtra("image_url",d.getAvatarUrl());
                   intent.putExtra("image_name",d.getLogin());
                   myViewHolder.imageView.getContext().startActivity(intent);

               }
           });

    }



    @Override
    public int getItemCount() {
        return data.length;
    }

    //Inner class myViewHolder
    public class myViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;
        LinearLayout linearLayout;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.title);
            linearLayout = itemView.findViewById(R.id.LinearLayout);
        }
    }
}