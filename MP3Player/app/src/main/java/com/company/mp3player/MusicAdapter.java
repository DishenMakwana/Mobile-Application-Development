package com.company.mp3player;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.MusicViewHolder> {//derive the music adapter class from the recycler

    ArrayList<String> list;//we want to store all audio file
    Context mContext;

    public MusicAdapter(ArrayList<String> list, Context mContext) {
        this.list = list;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MusicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {//we will add to the card music design that we made.

        View view = LayoutInflater.from(parent.getContext())//create view class
                //The parent object represents the activity that contains the recycler view that is the main activity.
                .inflate(R.layout.card_music,parent,false);

        return new MusicViewHolder(view);//we can pass the view object to the music view holder method as a parameter.
    }

    @Override
    public void onBindViewHolder(@NonNull MusicViewHolder holder, final int position) {//In this method, we'll do some operations,
        // such as printing the name of the audio file on the screen,

        final String filePath = list.get(position);
        Log.e("filepath : ",filePath);
        final String title = filePath.substring(filePath.lastIndexOf("/")+1);
        holder.textViewFileName.setText(title);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext,MusicActivity.class);
                intent.putExtra("title",title);
                intent.putExtra("filepath",filePath);
                intent.putExtra("position",position);
                intent.putExtra("list",list);

                mContext.startActivity(intent);


            }
        });

    }

    @Override
    public int getItemCount() {//the third method will be the length of the array we created,
        return list.size();
    }

    public class MusicViewHolder extends RecyclerView.ViewHolder {// this class is responsible for defining the card
            // music design that we made in the adapter class.

        private TextView textViewFileName;//TextView component in the card music design.
        private CardView cardView;// card view component.

        public MusicViewHolder(@NonNull View itemView)  {//constructor
            super(itemView);//in the constructor, match components to their IDs.

            textViewFileName = itemView.findViewById(R.id.textViewFileName);
            cardView = itemView.findViewById(R.id.cardView);

        }
    }
}