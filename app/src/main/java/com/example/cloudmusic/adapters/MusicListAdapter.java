package com.example.cloudmusic.adapters;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.cloudmusic.R;
import com.example.cloudmusic.activitys.PlayMusicActivity;
import com.example.cloudmusic.entity.Song;
import com.example.cloudmusic.utils.SongUtils;

import java.util.ArrayList;
import java.util.List;

public class MusicListAdapter extends RecyclerView.Adapter<MusicListAdapter.ViewHolder> {

    private Context mContext;
    private View mItemView;
    private RecyclerView mRv;
    private boolean isCalcaulationRvHeight;
    private ArrayList<Song> mSongList;
    private String song_name,song_url,song_cover,author;
    private Integer song_id;


    public MusicListAdapter(Context context,RecyclerView recyclerView,ArrayList<Song> songList){
        mContext = context;
        mRv = recyclerView;
        mSongList = songList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        mItemView = LayoutInflater.from(mContext).inflate(R.layout.item_list_music,viewGroup,false);
        return new ViewHolder(mItemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        setRecyclerViewHeight();

        SongUtils songUtils = new SongUtils();
        Cursor cursor = songUtils.findAll(mContext);
        while (cursor.moveToNext()){
            song_id = cursor.getInt(cursor.getColumnIndex("song_id"));
            song_name = cursor.getString(cursor.getColumnIndex("song_name"));
            author = cursor.getString(cursor.getColumnIndex("author"));
            song_cover = cursor.getString(cursor.getColumnIndex("song_cover"));
            song_url = cursor.getString(cursor.getColumnIndex("song_url"));
            Song song = new Song(song_id,song_name,author,song_url,song_cover);
            mSongList.add(song);
        }
        cursor.close();

        for (Song song:mSongList){
            Glide.with(mContext)
                    .load(song.getSongCover())
                    .into(viewHolder.ivIcon);
            viewHolder.tvSongName.setText(song.getSongName());
            viewHolder.author.setText(song.getAuthor());
        }

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, PlayMusicActivity.class);
                Bundle bundle = new Bundle();

                Song song = new Song();
                song.setSongId(song_id);
                song.setSongName(song_name);
                song.setAuthor(author);
                song.setSongCover(song_cover);
                song.setSongUrl(song_url);

                bundle.putSerializable("song",song);
                intent.putExtra("mySong","mySong");
                intent.putExtras(bundle);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 8;
    }

    /**
     * 1.获取ItemView的高度
     * 2.获取ItemView的数量
     * 3.ItemView的高 * ItemView的数量 = RecyclerViewHeight
     */
    private void setRecyclerViewHeight(){
        if (isCalcaulationRvHeight || mRv == null) return;
        isCalcaulationRvHeight = true;

        //获取ItemView的高度
        RecyclerView.LayoutParams itemViewLp = (RecyclerView.LayoutParams) mItemView.getLayoutParams();
        //获取ItemView的数量
        int itemCount = getItemCount();
        //ItemView的高 * ItemView的数量 = RecyclerViewHeight
        int recyclerViewHeight = itemViewLp.height * itemCount;
        //设置RecyclerView高度
        LinearLayout.LayoutParams rvlp = (LinearLayout.LayoutParams) mRv.getLayoutParams();
        rvlp.height = recyclerViewHeight;
        mRv.setLayoutParams(rvlp);
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        View itemView;
        ImageView ivIcon;
        TextView tvSongName,author;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivIcon = itemView.findViewById(R.id.iv_icon);
            tvSongName = itemView.findViewById(R.id.tv_songName);
            author = itemView.findViewById(R.id.tv_author);
            this.itemView = itemView;
        }
    }
}
