package com.example.loginapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MyViewHolder> {

    List<Message> messageList;
    public MessageAdapter(List<Message> messageList) {
        this.messageList = messageList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View chartView = LayoutInflater.from(parent.getContext()).inflate(R.layout.chart_item,null);
        MyViewHolder myViewholder = new MyViewHolder(chartView);
        return myViewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Message message = messageList.get(position);
        if(message.getSentBy().equals(Message.SENT_BY_ME)){
            holder.leftChartView.setVisibility(View.GONE);
            holder.rightChartView.setVisibility(View.VISIBLE);
            holder.rightTextView.setText(message.getMessage());
        }else{
            holder.rightChartView.setVisibility(View.GONE);
            holder.leftChartView.setVisibility(View.VISIBLE);
            holder.leftTextView.setText(message.getMessage());
        }
    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        LinearLayout leftChartView, rightChartView;
        TextView leftTextView, rightTextView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            leftChartView = itemView.findViewById(R.id.left_chart_view);
            rightChartView = itemView.findViewById(R.id.right_chart_view);
            leftTextView = itemView.findViewById(R.id.left_chart_text_view);
            rightTextView = itemView.findViewById(R.id.right_chart_text_view);
        }
    }
}
