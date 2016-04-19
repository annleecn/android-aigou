package com.example.aigou2;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

public class StartActivity extends Activity
{
	//private ImageView image;
	private ImageView image_bg;
	//private Animation operatingAnim;
	private final String T = "test";
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.start_activity);
		image_bg = (ImageView)findViewById(R.id.start_image_bg);
		AlphaAnimation alpaAnimaiton  = new AlphaAnimation(0.0f, 1.0f);
		alpaAnimaiton.setDuration(3000);
		alpaAnimaiton.setAnimationListener(new AnimationListener()
		{
			@Override
			public void onAnimationStart(Animation animation)
			{
			}
			@Override
			public void onAnimationRepeat(Animation animation)
			{
			}
			@Override
			public void onAnimationEnd(Animation animation)
			{
				//跳转界面
				StartActivity.this.startActivity(new Intent(StartActivity.this, MainActivity.class));
				StartActivity.this.finish();
			}
		});
		
		image_bg.setAnimation(alpaAnimaiton);
		/*image = (ImageView) findViewById(R.id.start_image_turn);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		// 对一个image设置旋转动画，并由当前的界面跳到指定的页面
		operatingAnim = AnimationUtils.loadAnimation(this, R.anim.tip);
		LinearInterpolator lin = new LinearInterpolator();
		operatingAnim.setInterpolator(lin);
		operatingAnim.setDuration(2000);
		Log.i(T, "start-1");
		/*operatingAnim.setAnimationListener(new AnimationListener()
		{
			@Override
			public void onAnimationStart(Animation arg0){
				Log.i(T, "start-2");
			}
			
			@Override
			public void onAnimationRepeat(Animation arg0){}
			
			@Override
			public void onAnimationEnd(Animation arg0)
			{   Log.i(T, "start-3");
				StartActivity.this.startActivity(new Intent(StartActivity.this, MainActivity.class));
				StartActivity.this.finish();
			}
		});
		
		image.startAnimation(operatingAnim);
		
		image_bg = (ImageView) findViewById(R.id.start_image_bg);
		image_bg.setOnTouchListener(new OnTouchListener()
		{
			@Override
			public boolean onTouch(View v, MotionEvent event)
			{Log.i(T, "---touch---");
				StartActivity.this.startActivity(new Intent(StartActivity.this, MainActivity.class));
				StartActivity.this.finish();
				return false;
			}
		});*/
	}

}













