package com.icsc.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.icsc.MainActivity;
import com.icsc.R;

import java.util.ArrayList;

public class tenAdapter extends RecyclerView.Adapter<tenAdapter.tenHolder> {
    ArrayList<Modal> data;
    Context context;

    public tenAdapter(ArrayList<Modal> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public tenHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.tenrow, parent, false);
        return new tenHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull tenAdapter.tenHolder holder, int position) {
        holder.tenpdf.setText(data.get(position).getTenpdf());
        holder.tendonlowd.setText(data.get(position).getTendownload());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(holder.itemView.getContext(), MainActivity.class);
                intent.putExtra("pdfn", data.get(position).getTenpdf());
                intent.putExtra("url", data.get(position).getTendownload());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                holder.itemView.getContext().startActivities(new Intent[]{intent});
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class tenHolder extends RecyclerView.ViewHolder {
        TextView tenpdf, tendonlowd;

        public tenHolder(@NonNull View itemView) {
            super(itemView);
            tenpdf = (TextView) itemView.findViewById(R.id.tenpdf);
            tendonlowd = (TextView) itemView.findViewById(R.id.tendownlaod);
        }
    }
}
