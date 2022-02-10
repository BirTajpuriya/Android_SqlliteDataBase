package com.example.myapplication.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    Context context;
    ArrayList id, name, passmarks, fullmarks;

    public CustomAdapter(Context context, ArrayList id, ArrayList name, ArrayList passmarks, ArrayList fullmarks) {
        this.context = context;
        this.id = id;
        this.name = name;
        this.passmarks = passmarks;
        this.fullmarks = fullmarks;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.sample_recycleview, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.id.setText(String.valueOf(id.get(position)));
        holder.name.setText(String.valueOf(name.get(position)));
        holder.pass.setText(String.valueOf(passmarks.get(position)));
        holder.full.setText(String.valueOf(fullmarks.get(position)));
    }

    @Override
    public int getItemCount() {
        return id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView id, name, pass, full;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.userid);
            name = itemView.findViewById(R.id.name);
            pass = itemView.findViewById(R.id.passmarks);
            full = itemView.findViewById(R.id.fullmarks);
        }
    }
}
