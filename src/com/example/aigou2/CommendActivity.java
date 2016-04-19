package com.example.aigou2;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Window;
import android.widget.ImageView;

public class CommendActivity extends Activity
{
	private ImageView turnImage = null;  
    private int index = 0;  
    //图片id
    private int[] images = {R.drawable.commend_theme1,R.drawable.commend_theme2,R.drawable.commend_theme3}; 
    
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		turnImage = (ImageView) this.findViewById(R.id.commend_turn_img);  
        turnImage.setBackgroundResource(R.drawable.commend_theme1);  
        autoShowImage();  
	}
	
	//自动播放图片  每两秒刷新次图片  
	public void autoShowImage() {new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					Message msg = new Message();
					msg.obj = index;
					handler.sendMessage(msg);
					index++;
					if (index >= images.length) {
						index = 0;
					}
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}
  
    public Handler handler = new Handler(){  
        public void handleMessage(android.os.Message msg) {  
        	turnImage.setBackgroundResource(images[(Integer) msg.obj]);  
        };  
    };  
}

























