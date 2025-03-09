package com.rudeusgrey.vibechat;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class DetailMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_message);

        // Thiết lập Toolbar
        Toolbar toolbar = findViewById(R.id.toolbarChat);
        setSupportActionBar(toolbar);

        // Xử lý nút Back
        ImageButton backButton = toolbar.findViewById(android.R.id.home);
        if (backButton != null) {
            backButton.setOnClickListener(v -> finish());
        } else {
            // Nếu không tìm thấy ImageButton, thêm nút back mặc định của Toolbar
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            toolbar.setNavigationOnClickListener(v -> finish());
        }

        // Nhận dữ liệu từ Intent và cập nhật Toolbar
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String userName = extras.getString("user_name");
            TextView toolbarTitle = toolbar.findViewById(android.R.id.title);
            if (toolbarTitle != null) {
                toolbarTitle.setText(userName);
            } else {
                // Nếu không tìm thấy TextView, đặt tiêu đề mặc định
                getSupportActionBar().setTitle(userName);
            }
        }
    }
}