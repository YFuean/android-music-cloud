package com.example.cloudmusic.activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.cloudmusic.R;
import com.example.cloudmusic.adapters.MusicListAdapter;
import com.example.cloudmusic.entity.Song;

import java.util.ArrayList;

public class AlbumActivity extends BaseActivity {
    private RecyclerView mRvList;
    private MusicListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);
        init();
    }

    private void init() {
        initNavBar(true,"专辑列表",false);

        mRvList = findViewById(R.id.rv_list);
        mRvList.setLayoutManager(new LinearLayoutManager(this));
        mRvList.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        mAdapter = new MusicListAdapter(this,null,new ArrayList<Song>());
        mRvList.setAdapter(mAdapter);
    }
}