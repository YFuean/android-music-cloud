package com.example.cloudmusic.views;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.bumptech.glide.Glide;
import com.example.cloudmusic.R;
import com.example.cloudmusic.helps.MediaPlayHelp;

public class PlayMusicView extends FrameLayout {
    private Context mContext;
    private MediaPlayHelp mediaPlayHelp;
    private boolean isPlaying;
    private String mPath;
    private View mView;
    private FrameLayout mFlPlayMusic;
    private ImageView mIvIcon,mIvPlay;
    private Animation mPlayMusicAnim;

    @Override
    protected void removeDetachedView(View child, boolean animate) {
    }

    public PlayMusicView(@NonNull Context context) {
        super(context);
        init(context);
    }

    public PlayMusicView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public PlayMusicView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public PlayMusicView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context){
        mContext = context;
        mView = LayoutInflater.from(mContext).inflate(R.layout.play_music,this,false);
        mFlPlayMusic = mView.findViewById(R.id.fl_play_music);
        mFlPlayMusic.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                trigger();
            }
        });
        mIvIcon = mView.findViewById(R.id.iv_icon);
        mIvPlay = mView.findViewById(R.id.iv_play);
        addView(mView);

        mediaPlayHelp = MediaPlayHelp.getInstance(mContext);

        /**
         * 1.定义要执行的动画
         *   1.1光盘转动的动画
         * 2.startAnimation
         */
        mPlayMusicAnim = AnimationUtils.loadAnimation(mContext,R.anim.play_music_anim);

    }
    /**
     * 切换播放状态
     */
    private void trigger(){
        if (isPlaying){
            stopMusic();
        }else {
            playMusic(mPath);
        }
    }

    /**
     * 播放音乐
     */
    public void playMusic(String path){
        mPath = path;
        isPlaying = true;
        mIvPlay.setVisibility(View.GONE);
        mFlPlayMusic.startAnimation(mPlayMusicAnim);

        /**
         * 1.判断当前播放的音乐是否是已经在播放的音乐
         * 2.如果当前音乐是已经在播放的音乐，那么直接执行start方法
         * 3.如果当前播放音乐不是需要播放的音乐，那么调用setPath
         */
        if (mediaPlayHelp.getPath() !=null && mediaPlayHelp.getPath().equals(path)){
            mediaPlayHelp.start();
        }else {
            mediaPlayHelp.setPath(path);
            mediaPlayHelp.setOnMediaPlayHelperListener(new MediaPlayHelp.OnMediaPlayHelperListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mediaPlayHelp.start();
                }
            });
        }
    }
    /**
     * 停止播放
     */
    public void stopMusic(){
        isPlaying = false;
        mIvPlay.setVisibility(View.VISIBLE);
        mFlPlayMusic.clearAnimation();

        mediaPlayHelp.pause();
    }

    /**
     * 设置光盘中显示的音乐封面图片
     */
    public void setMusicIcon(String icon){
        Glide.with(mContext)
                .load(icon)
                .into(mIvIcon);
    }
}
