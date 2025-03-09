package com.rudeusgrey.vibechat;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MessagesFragment extends Fragment implements MessagesAdapter.OnItemClickListener {

    private RecyclerView recyclerView;
    private MessagesAdapter adapter;

    public MessagesFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_messages, container, false);

        recyclerView = view.findViewById(R.id.recyclerViewMessages);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        adapter = new MessagesAdapter(this);
        recyclerView.setAdapter(adapter);

        List<Message> sampleMessages = new ArrayList<>();
        sampleMessages.add(new Message("Ngô Trần Nguyên Quân", "Xin chào!", "10:54 PM"));
        sampleMessages.add(new Message("Ngô Trần Nguyên Quân 2", "Hello!", "10:30 PM"));
        sampleMessages.add(new Message("Nguyễn Văn A", "Hello!", "10:30 PM"));
        adapter.setMessageList(sampleMessages);

        return view;
    }

    @Override
    public void onItemClick(Message message) {
        Intent intent = new Intent(getActivity(), DetailMessageActivity.class);
        intent.putExtra("user_name", message.getUserName());
        intent.putExtra("last_message", message.getLastMessage());
        startActivity(intent);
    }
}