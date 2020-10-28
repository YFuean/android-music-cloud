package com.example.cloudmusic.activitys;

import android.os.Bundle;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cloudmusic.R;
import com.example.cloudmusic.adapters.MusicGridAdapter;
import com.example.cloudmusic.adapters.MusicListAdapter;
import com.example.cloudmusic.entity.Song;
import com.example.cloudmusic.utils.SongUtils;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private RecyclerView mRvGrid,mRvList;
    private MusicGridAdapter mGridAdapter;
    private MusicListAdapter mListAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView(){
        initNavBar(false,"云音乐",true);
        addSong();

        //网格
        mRvGrid = findViewById(R.id.rv_grid);
        mRvGrid.setLayoutManager(new GridLayoutManager(this,3));
        mRvGrid.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.HORIZONTAL));    //网格分割线
        mRvGrid.setNestedScrollingEnabled(false);//取消单独滑动
        mGridAdapter = new MusicGridAdapter(this);
        mRvGrid.setAdapter(mGridAdapter);

        //列表
        /**
         * 1.假如已知列表高度，可以直接在布局中把RecycleView的高度定义
         * 2.不知道列表高度，需要手动计算RecycleView的高度
         */
        mRvList = findViewById(R.id.rv_list);
        mRvList.setLayoutManager(new LinearLayoutManager(this));
        mRvList.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL)); //垂直排列分割线
        mRvList.setNestedScrollingEnabled(false);//取消单独滑动
        mListAdapter = new MusicListAdapter(this, mRvList, new ArrayList<Song>());
        mRvList.setAdapter(mListAdapter);
    }

    public void addSong() {
        SongUtils addSong = new SongUtils();
        addSong.insert(this,"空","徐海俏","https://yfuean-student-manager.oss-cn-shanghai.aliyuncs.com/android-project-music/music/song/kong.mp3",
                "https://yfuean-student-manager.oss-cn-shanghai.aliyuncs.com/android-project-music/music/cover/kong.jpg");
        addSong.insert(this,"Dream_It_Possible","Delacey","https://yfuean-student-manager.oss-cn-shanghai.aliyuncs.com/android-project-music/music/song/Dream_It_Possible.mp3",
                "https://yfuean-student-manager.oss-cn-shanghai.aliyuncs.com/android-project-music/music/cover/Dream_It_Possible.jpg");
        addSong.insert(this,"Breathe","Fleurie","https://yfuean-student-manager.oss-cn-shanghai.aliyuncs.com/android-project-music/music/song/Fleurie%20-%20Breathe.mp3",
                "https://yfuean-student-manager.oss-cn-shanghai.aliyuncs.com/android-project-music/music/cover/kong.jpg");
        addSong.insert(this,"借","毛不易","https://yfuean-student-manager.oss-cn-shanghai.aliyuncs.com/android-project-music/music/song/jie.mp3",
                "https://yfuean-student-manager.oss-cn-shanghai.aliyuncs.com/android-project-music/music/cover/jie.jpg");
        addSong.insert(this,"梅香如故","毛不易-周深","https://yfuean-student-manager.oss-cn-shanghai.aliyuncs.com/android-project-music/music/song/meixiangrugu.mp3",
                "https://yfuean-student-manager.oss-cn-shanghai.aliyuncs.com/android-project-music/music/cover/meixiangrugu.jpg");
        addSong.insert(this,"SpongeBob","Various Artists、spongebob","https://yfuean-student-manager.oss-cn-shanghai.aliyuncs.com/android-project-music/music/song/SpongeBob.mp3",
                "https://yfuean-student-manager.oss-cn-shanghai.aliyuncs.com/android-project-music/music/cover/spongeBob.jpg");
        addSong.insert(this,"一纸情书","毛不易-岳云鹏","https://yfuean-student-manager.oss-cn-shanghai.aliyuncs.com/android-project-music/music/song/yizhiqingshu.mp3",
                "https://yfuean-student-manager.oss-cn-shanghai.aliyuncs.com/android-project-music/music/cover/yizhiqingshu.jpg");
        addSong.insert(this,"左手指月","黄霄云","https://yfuean-student-manager.oss-cn-shanghai.aliyuncs.com/android-project-music/music/song/zuoshouzhiyue.mp3",
                "https://yfuean-student-manager.oss-cn-shanghai.aliyuncs.com/android-project-music/music/cover/zuoshouzhiyue.jpg");
    }
}