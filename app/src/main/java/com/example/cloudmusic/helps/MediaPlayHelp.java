package com.example.cloudmusic.helps;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;

import java.io.IOException;

public class MediaPlayHelp {

    private static MediaPlayHelp instance;
    private Context mContext;
    private MediaPlayer mediaPlayer;
    private String mPath;
    private OnMediaPlayHelperListener onMediaPlayHelperListener;

    public void setOnMediaPlayHelperListener(OnMediaPlayHelperListener onMediaPlayHelperListener) {
        this.onMediaPlayHelperListener = onMediaPlayHelperListener;
    }

    public static MediaPlayHelp getInstance(Context context){
        if (instance == null){
            synchronized (MediaPlayHelp.class){
                if (instance == null){
                    instance = new MediaPlayHelp(context);
                }
            }
        }
        return  instance;
    }

    private MediaPlayHelp(Context context){
        mContext = context;
        mediaPlayer = new MediaPlayer();
    }

    /**
     * 1.setPath:当前需要播放的音乐
     * 2.start:播放音乐
     * 3.pause:暂停播放
     */

    public void setPath(String path){
        mPath = path;
        //1.音乐正在播放，重置音乐播放状态
        if (mediaPlayer.isPlaying()){
            mediaPlayer.reset();
        }
        //2.设置音乐播放路径
        try {
            mediaPlayer.setDataSource(mContext, Uri.parse(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //3.准备播放
        mediaPlayer.prepareAsync(); //异步加载
        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                if (onMediaPlayHelperListener != null){
                    onMediaPlayHelperListener.onPrepared(mp);
                }
            }
        });
    }

    public String getPath(){
        return mPath;
    }

    public void start(){
        if (mediaPlayer.isPlaying()) return;
        mediaPlayer.start();
    }

    public void pause(){
        mediaPlayer.pause();
    }

    public interface OnMediaPlayHelperListener{
        void onPrepared(MediaPlayer mp);
    }
}
