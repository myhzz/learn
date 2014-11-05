/*
 * Copyright (C) 2013 yixia.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.yu.app;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import io.vov.vitamio.LibsChecker;
import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.MediaPlayer.OnBufferingUpdateListener;
import io.vov.vitamio.MediaPlayer.OnInfoListener;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;

public class VideoPlay extends Activity implements OnInfoListener, OnBufferingUpdateListener {

  /**
   * TODO: Set the path variable to a streaming video URL or a local media file
   * path.
   */
  private String path = "http://devimages.apple.com/iphone/samples/bipbop/bipbopall.m3u8";
  private Uri uri;
  private VideoView mVideoView;
  private ProgressBar pb;
  private TextView downloadRateView, loadRateView;
  @Override
  public void onCreate(Bundle icicle) {
    super.onCreate(icicle);
    
    if (!LibsChecker.checkVitamioLibs(this))
      return;
//    if("10%".equals(mVideoView.getBufferPercentage()))
//    {
//    	Dialog dialog = new AlertDialog.Builder(this).setIcon(
//    		     android.R.drawable.btn_star).setTitle("喜好调查").setMessage(
//    		     "你喜欢李连杰的电影吗？").setPositiveButton("很喜欢",
//    		     new OnClickListener() {
//    		 
//    		      @Override
//    		      public void onClick(DialogInterface dialog, int which) {
//    		       // TODO Auto-generated method stub
//    		       Toast.makeText(VideoPlay.this, "我很喜欢他的电影。",
//    		         Toast.LENGTH_LONG).show();
//    		      }
//    		     }).setNegativeButton("不喜欢", new OnClickListener() {
//    		 
//    		    @Override
//    		    public void onClick(DialogInterface dialog, int which) {
//    		     // TODO Auto-generated method stub
//    		     Toast.makeText(VideoPlay.this, "我不喜欢他的电影。", Toast.LENGTH_LONG)
//    		       .show();
//    		    }
//    		   }).setNeutralButton("一般", new OnClickListener() {
//    		 
//    		    @Override
//    		    public void onClick(DialogInterface dialog, int which) {
//    		     // TODO Auto-generated method stub
//    		     Toast.makeText(VideoPlay.this, "谈不上喜欢不喜欢。", Toast.LENGTH_LONG)
//    		       .show();
//    		    }
//    		   }).create();
//    		 
//    		   dialog.show();
//
//    }
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    setContentView(R.layout.activity_video_play);
    mVideoView = (VideoView) findViewById(R.id.buffer);
    pb = (ProgressBar) findViewById(R.id.probar);
    downloadRateView = (TextView) findViewById(R.id.download_rate);
    loadRateView = (TextView) findViewById(R.id.load_rate);
    if (path == "") {
      // Tell the user to provide a media file URL/path.
      Toast.makeText(
          VideoPlay.this,
          "Please edit VideoBuffer Activity, and set path"
              + " variable to your media file URL/path", Toast.LENGTH_LONG).show();
      return;
    } else {
      /*
       * Alternatively,for streaming media you can use
       * mVideoView.setVideoURI(Uri.parse(URLstring));
       */
      uri = Uri.parse(path);
      mVideoView.setVideoURI(uri);
      mVideoView.setMediaController(new MediaController(this));
      mVideoView.requestFocus();
      mVideoView.setOnInfoListener(this);
      mVideoView.setOnBufferingUpdateListener(this);
      mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
        @Override
        public void onPrepared(MediaPlayer mediaPlayer) {
          // optional need Vitamio 4.0
          mediaPlayer.setPlaybackSpeed(1.0f);
        }
      });
    }

  }

  @Override
  public boolean onInfo(MediaPlayer mp, int what, int extra) {
    switch (what) {
    case MediaPlayer.MEDIA_INFO_BUFFERING_START:
      if (mVideoView.isPlaying()) {
        mVideoView.pause();
        pb.setVisibility(View.VISIBLE);
        downloadRateView.setText("");
        loadRateView.setText("");
        downloadRateView.setVisibility(View.VISIBLE);
        loadRateView.setVisibility(View.VISIBLE);

      }
      break;
    case MediaPlayer.MEDIA_INFO_BUFFERING_END:
      mVideoView.start();
      pb.setVisibility(View.GONE);
      
      downloadRateView.setVisibility(View.GONE);
      loadRateView.setVisibility(View.GONE);
      break;
    case MediaPlayer.MEDIA_INFO_DOWNLOAD_RATE_CHANGED:
      downloadRateView.setText("" + extra + "kb/s" + "  ");
      break;
    }
    return true;
  }

  @Override
  public void onBufferingUpdate(MediaPlayer mp, int percent) {
    loadRateView.setText(percent + "%");
  }

}
