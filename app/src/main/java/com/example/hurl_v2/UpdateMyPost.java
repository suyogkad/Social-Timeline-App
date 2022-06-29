package com.example.hurl_v2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class UpdateMyPost extends RecyclerView.Adapter<UpdateMyPost.allPost> {

    ArrayList<Timeline> allPosts;

    public UpdateMyPost(ArrayList<Timeline> allPosts ){ // CONSTRUCTOR OF THIS CLASS
        this.allPosts = allPosts;
    }

    @NonNull
    @Override
    public allPost onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View activity = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_updatemypost,parent,false);
        return new allPost(activity);
    }

    //to get the username, post content and posted date
    @Override
    public void onBindViewHolder(@NonNull allPost holder, int position) {
        holder.textview1.setText(allPosts.get(position).getPostusername());  //get username in the post
        holder.textview2.setText(allPosts.get(position).getPostcontent());  //get content in the post
        holder.textview3.setText(allPosts.get(position).getPostdate()); //get date in the post
    }

    @Override
    public int getItemCount() {
        return allPosts.size();
    }

    static class allPost extends RecyclerView.ViewHolder{
        TextView textview1, textview2, textview3;

        public allPost(@NonNull View itemView1) {
            super(itemView1);
            //getting variables
            textview1 = itemView1.findViewById(R.id.upost_name);
            textview2 = itemView1.findViewById(R.id.upost_description);
            textview3 = itemView1.findViewById(R.id.upost_date);
        }
    }
}
