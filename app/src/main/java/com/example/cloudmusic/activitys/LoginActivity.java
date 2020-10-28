package com.example.cloudmusic.activitys;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.cloudmusic.R;
import com.example.cloudmusic.utils.UserUtils;
import com.example.cloudmusic.views.InputView;

import java.util.Map;

public class LoginActivity extends BaseActivity {
    private InputView myInputPhone,myInputPassword;
    String truePhone,truePassword;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();

        //通过工具类UserUtils中的getUserInfo()获取手机和密码
        Map<String,String> userInfo = UserUtils.getUserInfo(this);
        if (userInfo != null){
            truePhone = userInfo.get("phone");
            truePassword = userInfo.get("password");
        }
    }

    /**
     *初始化View
     */
    private void initView() {
        initNavBar(false,"登录",false);

        myInputPhone = findViewById(R.id.input_phone);
        myInputPassword = findViewById(R.id.input_password);
    }

    /**
     * 跳转注册点击事件
     */
    public void goRegisterClick(View v){
        Intent intent = new Intent(this,RegisterActivity.class);
        startActivity(intent);
        finish();
    }

    /**
     * 登录事件
     */
    public void onCommitClick(View v){
        String phone = myInputPhone.getInputStr();
        String password = myInputPassword.getInputStr();
        //验证用户输入是否合法
        if(!UserUtils.validateLogin(this,phone,password)){
            return;
        }
        if (phone.equals(truePhone) && password.equals(truePassword) ){
            Toast.makeText(this,"登录成功",Toast.LENGTH_SHORT).show();
            //跳转到主页
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
            finish();
        }if (!phone.equals(truePhone)){
            Toast.makeText(this,"手机号不正确",Toast.LENGTH_SHORT).show();
        }if (!password.equals(truePassword)){
            Toast.makeText(this,"密码不正确",Toast.LENGTH_SHORT).show();
        }
    }
}