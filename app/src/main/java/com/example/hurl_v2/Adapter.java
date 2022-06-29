package com.example.hurl_v2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.allPost> {

    //creating arraylist for all posts in timeline
    ArrayList<Timeline> allPosts;
    public Adapter(ArrayList<Timeline> allPosts ){ // CONSTRUCTOR OF THIS CLASS
        this.allPosts = allPosts;
    }

    @NonNull
    @Override
    public allPost onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View activity = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_singlepost,parent,false);
        return new allPost(activity);
    }

    //create a sginle bindviewholder to update contents of recycler view
    @Override
    public void onBindViewHolder(@NonNull allPost holder, int position) {
        holder.authorname.setText(allPosts.get(position).getPostusername());
        holder.postdesc.setText(allPosts.get(position).getPostcontent());
        holder.dateposted.setText(allPosts.get(position).getPostdate());
    }

    @Override
    public int getItemCount() {
        return allPosts.size();
    }

    static class allPost extends RecyclerView.ViewHolder{
        TextView authorname, postdesc, dateposted;

        //single row item list for all the post in the timeline
        public allPost(@NonNull View itemView) {
            super(itemView);
            authorname = itemView.findViewById(R.id.single_post_name);
            postdesc = itemView.findViewById(R.id.single_post_description);
            dateposted = itemView.findViewById(R.id.single_post_date);
        }
    }
}
