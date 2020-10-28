package com.example.cloudmusic.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.cloudmusic.R;
import com.example.cloudmusic.utils.UserUtils;

public class MeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me);

        init();
    }

    private void init() {
        initNavBar(true,"个人中心",false);
    }

    /**
     * 修改密码
     */
    public void onChangeClick(View v){
        startActivity(new Intent(this,ChangePasswordActivity.class));
    }


    /**
     * 退出登录
     */
    public void onLogoutClick(View v){
        UserUtils.logout(this);
    }
}