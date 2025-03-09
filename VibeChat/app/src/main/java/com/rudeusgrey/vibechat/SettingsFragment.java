package com.rudeusgrey.vibechat;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

public class SettingsFragment extends Fragment {

    public SettingsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate layout setting_main.xml
        View view = inflater.inflate(R.layout.setting_main, container, false);

        // Xử lý click vào changeAccount (đăng xuất)
        ImageView changeAccount = view.findViewById(R.id.changeAccount);
        changeAccount.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), LoginActivity.class);
            startActivity(intent);
            getActivity().finish();
        });

        // Xử lý click vào profile_change để chuyển sang ProfileActivity
        LinearLayout profileChange = view.findViewById(R.id.profile_change);
        profileChange.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), ProfileActivity.class);
            startActivity(intent);
        });

        return view;
    }
}