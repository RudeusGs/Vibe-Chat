package com.rudeusgrey.vibechat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MessagesAdapter extends RecyclerView.Adapter<MessagesAdapter.MessageViewHolder> {

    private List<Message> messageList = new ArrayList<>();
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Message message);
    }

    public MessagesAdapter(OnItemClickListener listener) {
        this.listener = listener;
    }

    public void setMessageList(List<Message> messages) {
        this.messageList = messages;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_message, parent, false);
        return new MessageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder holder, int position) {
        Message message = messageList.get(position);
        holder.bind(message, listener);
    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }

    static class MessageViewHolder extends RecyclerView.ViewHolder {
        ImageView profileImage;
        TextView userName;
        TextView lastMessage;
        TextView timestamp;

        public MessageViewHolder(@NonNull View itemView) {
            super(itemView);
            profileImage = itemView.findViewById(R.id.profile_image);
            userName = itemView.findViewById(R.id.user_name);
            lastMessage = itemView.findViewById(R.id.last_message);
            timestamp = itemView.findViewById(R.id.timestamp);
        }

        void bind(final Message message, final OnItemClickListener listener) {
            userName.setText(message.getUserName());
            lastMessage.setText(message.getLastMessage());
            timestamp.setText(message.getTimestamp());

            itemView.setOnClickListener(v -> listener.onItemClick(message));
        }
    }
}

class Message {
    private String userName;
    private String lastMessage;
    private String timestamp;

    public Message(String userName, String lastMessage, String timestamp) {
        this.userName = userName;
        this.lastMessage = lastMessage;
        this.timestamp = timestamp;
    }

    public String getUserName() {
        return userName;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public String getTimestamp() {
        return timestamp;
    }
}