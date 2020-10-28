package com.example.cloudmusic.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.cloudmusic.R;
import com.example.cloudmusic.entity.Song;
import com.example.cloudmusic.views.PlayMusicView;

import jp.wasabeef.glide.transformations.BlurTransformation;

public class PlayMusicActivity extends BaseActivity {
    private ImageView mIvBg;
    private PlayMusicView playMusicView;
    private TextView tvSongName,tvAuthor;
    private String songName,songCover,author,songUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_music);
        //隐藏statusBar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        String type = getIntent().getStringExtra("mySong");
        if (type.equals("mySong")){
            Song song = (Song) getIntent().getSerializableExtra("song");
            songName = song.getSongName();
            songCover = song.getSongCover();
            author = song.getAuthor();
            songUrl = song.getSongUrl();
        }

        init();
    }

    private void init(){
        mIvBg = findViewById(R.id.iv_bg);
        //glide-transformations
        Glide.with(this)
                .load(songCover)
                //radius:处理后的模糊程度；sampling:生成的图片为原图的十分之一
                .apply(RequestOptions.bitmapTransform(new BlurTransformation(25,10)))
                .into(mIvBg);
        playMusicView = findViewById(R.id.play_music_view);
        tvSongName = findViewById(R.id.tv_songName);
        tvAuthor = findViewById(R.id.tv_author);

        playMusicView.setMusicIcon(songCover);
        tvSongName.setText(songName);
        tvAuthor.setText(author);
        playMusicView.playMusic(songUrl);
    }

    /**
     * 后退按钮点击事件
     */
    public void onBackClick(View view){
        onBackPressed();
    }
}