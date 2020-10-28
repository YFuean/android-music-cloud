package com.example.cloudmusic.utils;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;

import com.blankj.utilcode.util.RegexUtils;
import com.blankj.utilcode.util.StringUtils;
import com.example.cloudmusic.activitys.LoginActivity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UserUtils {
    /**
     * 验证用户输入合法性
     */
    public static boolean validateLogin(Context context,String phone,String password){
        //精确的手机号
        if(!RegexUtils.isMobileExact(phone)){
            Toast.makeText(context,"无效手机号",Toast.LENGTH_SHORT).show();
            return false;
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(context,"请输入密码",Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    /**
     * 退出登录
     */
    public static void logout(Context context){
        Intent intent =  new Intent(context, LoginActivity.class);
        //添加intent标志符，清理task栈，并且新生成一个task栈
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    /**
     * 注册用户，保存手机号和密码到data.txt文件
     */
    public static boolean registerUser(Context context,String phone,String password, String passwordConfirm){
        if(!RegexUtils.isMobileExact(phone)){
            Toast.makeText(context,"无效手机号",Toast.LENGTH_SHORT).show();
            return false;
        }
        if (StringUtils.isEmpty(password) || !password.equals(passwordConfirm)){
            Toast.makeText(context,"请确认密码",Toast.LENGTH_SHORT).show();
            return false;
        }
        //用户当前输入的手机号是否被注册
        FileOutputStream fos = null;
        try {
            //获取文件的输出对象
            fos = context.openFileOutput("data.txt",Context.MODE_PRIVATE);
            //将数据转换为字节码的形式写入data.txt
            fos.write((phone + ":" + password).getBytes());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally {
            try {
                if (fos != null){
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 从data.txt中获取存储的手机和密码
     */
    public static Map<String,String> getUserInfo(Context context){
        String content = "";
        FileInputStream fis = null;
        try {
            //获取文件输入对象
            fis = context.openFileInput("data.txt");
            //将输入流对象中的数据转换为字节码形式
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            content = new String(buffer);
            Map<String,String> userMap = new HashMap<>();
            //将字符串以“：”分割形成一个数组
            String[] infos = content.split(":");
            userMap.put("phone",infos[0]);
            userMap.put("password",infos[1]);
            return userMap;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally {
            try{
                if (fis != null){
                    fis.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

}
