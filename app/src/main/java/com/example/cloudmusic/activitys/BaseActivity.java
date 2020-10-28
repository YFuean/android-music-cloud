package com.example.cloudmusic.activitys;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.IdRes;

import com.example.cloudmusic.R;

public class BaseActivity extends Activity {

    private ImageView back,me;
    private TextView myTitle;

    /**
     * 初始化NavigationBar
     * @param isShowBack
     * @param title
     * @param isShowMe
     */
    protected void initNavBar(boolean isShowBack,String title ,boolean isShowMe){
        back =  findViewById(R.id.iv_back);
        myTitle = findViewById(R.id.tv_title);
        me = findViewById(R.id.iv_me);

        back.setVisibility(isShowBack ? View.VISIBLE : View.GONE);
        me.setVisibility(isShowMe ? View.VISIBLE : View.GONE);
        myTitle.setText(title);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        me.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BaseActivity.this,MeActivity.class));
            }
        });
    }
}
