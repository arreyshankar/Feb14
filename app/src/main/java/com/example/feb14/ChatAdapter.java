package com.example.feb14;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.feb14.Message;
import com.squareup.picasso.Picasso;

import java.util.List;

class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder> {
    private static final int CHAT_END = 1;
    private static final int CHAT_START = 2;
    private static final int IMAGE_END = 3;
    private static final int IMAGE_START = 4;
    private String MessageTimestamp;
    private List<Message> mDataSet;
    private String mId;

    ChatAdapter(List<Message> dataSet, String id, String timestamp) {
        mDataSet = dataSet;
        MessageTimestamp = timestamp;
        mId = id;
    }

    @Override
    public ChatAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        if (viewType == CHAT_END) {
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_chat_end, parent, false);
            return new ViewHolder(v);
        } else if(viewType == CHAT_START){
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_chat_start, parent, false);
            return new ViewHolder(v);
        } else if(viewType == IMAGE_END){
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_image_end,parent,false);
            return new ViewHolder(v);
        } else {
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_image_start,parent,false);
            return new ViewHolder(v);
        }


    }

    @Override
    public int getItemViewType(int position) {
        if (mDataSet.get(position).getId().equals(mId)) {
            if(mDataSet.get(position).getIsImage() == Boolean.TRUE){
                return IMAGE_END;
            } else{
                return CHAT_END;
            }
        } else if(mDataSet.get(position).getIsImage() == Boolean.TRUE){
            return IMAGE_START;
        } else {
            return CHAT_START;
        }
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Message chat = mDataSet.get(position);
        holder.mTextView.setText(chat.getMessage());
        if(mDataSet.get(position).getIsImage() == Boolean.TRUE)
            Picasso.get().load(chat.getMessage()).into(holder.imageView);
        holder.messageTimestamp.setText(chat.getTimestamp());
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView mTextView;
        ImageView imageView;
        TextView messageTimestamp;

        ViewHolder(View v) {
            super(v);
            imageView = (ImageView) itemView.findViewById(R.id.imageContent);
            mTextView = (TextView) itemView.findViewById(R.id.tvMessage);
            messageTimestamp = (TextView) itemView.findViewById(R.id.messageTimestamp);
        }
    }
}
