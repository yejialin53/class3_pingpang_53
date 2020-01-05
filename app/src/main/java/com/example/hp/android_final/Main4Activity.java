package com.example.hp.android_final;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class Main4Activity extends AppCompatActivity  implements View.OnClickListener {
    private VideoView videoView;
    private Button btn_start;
    private Button btn_pause;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        bindViews();
        if (ContextCompat.checkSelfPermission(Main4Activity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(Main4Activity.this, new String[]{
                    Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        }
    }
    private void bindViews() {
        videoView = (VideoView) findViewById(R.id.videoView);
        btn_start = (Button) findViewById(R.id.btn_start);
        btn_pause = (Button) findViewById(R.id.btn_pause);


        btn_start.setOnClickListener(this);
        btn_pause.setOnClickListener(this);


        //根据文件路径播放
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            videoView.setVideoPath(Environment.getExternalStorageDirectory() + "/vedio_b.mp4");
        }

        //读取放在raw目录下的文件
        //videoView.setVideoURI(Uri.parse("android.resource://com.jay.videoviewdemo/" + R.raw.lesson));
        videoView.setMediaController(new MediaController(this));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_start:
                videoView.start();
                break;
            case R.id.btn_pause:
                videoView.pause();
                break;

        }
    }
}
