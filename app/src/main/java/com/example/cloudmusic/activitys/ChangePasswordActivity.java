package com.example.cloudmusic.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.cloudmusic.R;

public class ChangePasswordActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        init();
    }

    private void init() {
        initNavBar(true,"修改密码",false);
    }
}