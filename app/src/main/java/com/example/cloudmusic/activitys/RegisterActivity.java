package com.example.cloudmusic.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.cloudmusic.R;
import com.example.cloudmusic.utils.UserUtils;
import com.example.cloudmusic.views.InputView;

public class RegisterActivity extends BaseActivity {
    private InputView phone,password,passwordConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initView();
    }

    /**
     * 初始化
     */
    private void initView() {
        initNavBar(true,"注册",false);

        phone = findViewById(R.id.input_phone);
        password = findViewById(R.id.input_password);
        passwordConfirm = findViewById(R.id.input_password_confirm);
    }

    /**
     * 注册按钮点击事件
     * 1.用户输入合法性验证
     *   1.1 用户输入的手机号合法
     *   1.2 用户是否输入了密码和确定了密码，并且两次输入是否相同
     *   1.3 输入的手机号是否已经被注册
     * 2.保存用户输入手机号和密码（MD5加密密码）
     */
    public void onRegisterClick(View v){
        String mPhone = phone.getInputStr();
        String mPassword = password.getInputStr();
        String mPasswordConfirm = passwordConfirm.getInputStr();

        boolean isSaveSuccess = UserUtils.registerUser(this,mPhone,mPassword,mPasswordConfirm);
        if (isSaveSuccess){
            Toast.makeText(this,"用户注册成功",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this,"注册失败",Toast.LENGTH_SHORT).show();
        }
        onBackPressed();
    }
}