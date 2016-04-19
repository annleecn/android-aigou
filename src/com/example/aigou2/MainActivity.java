package com.example.aigou2;

import android.annotation.SuppressLint;
import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Window;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TabHost;

@SuppressLint("ResourceAsColor")
@SuppressWarnings("deprecation")
public class MainActivity extends TabActivity implements OnCheckedChangeListener
{
	private TabHost mHost;  
    private RadioGroup radioderGroup; 
    private RadioButton radioBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_tabhost);
		
		//实例化TabHost  
        mHost=this.getTabHost();    
        //添加选项卡  
        mHost.addTab(mHost.newTabSpec("ONE").setIndicator("ONE")  
                    .setContent(new Intent(this,CommendActivity.class)));  
        mHost.addTab(mHost.newTabSpec("TWO").setIndicator("TWO")  
                .setContent(new Intent(this,TypeActivity.class)));  
        mHost.addTab(mHost.newTabSpec("THREE").setIndicator("THREE")  
                .setContent(new Intent(this,CollectActivity.class)));  
        mHost.addTab(mHost.newTabSpec("FOUR").setIndicator("FOUR")  
                .setContent(new Intent(this,MineActivity.class)));  
        
        radioderGroup = (RadioGroup) findViewById(R.id.main_radio);  
        radioderGroup.setOnCheckedChangeListener(this);  		
	}
	
	@Override  
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		Resources res = MainActivity.this.getResources();
		Drawable myImage;
		int[] radioBtns = {R.id.radio_button0,R.id.radio_button1,R.id.radio_button2,R.id.radio_button3};
		int[] imgs = {R.drawable.but_commend,R.drawable.but_type,R.drawable.but_collect,R.drawable.but_mine};
		for(int i = 0; i < radioBtns.length; i++){
			radioBtn = (RadioButton) findViewById(radioBtns[i]);
			myImage = res.getDrawable(imgs[i]);
			radioBtn.setCompoundDrawablesWithIntrinsicBounds(null, myImage,	null, null);
			radioBtn.setTextColor(Color.parseColor("#000000"));
		}
		switch (checkedId) {
		case R.id.radio_button0:
			radioBtn = (RadioButton) findViewById(R.id.radio_button0);
			myImage = res.getDrawable(R.drawable.but_commend_sel);
			radioBtn.setCompoundDrawablesWithIntrinsicBounds(null, myImage,	null, null);
			radioBtn.setTextColor(Color.parseColor("#ffffffff"));
			mHost.setCurrentTabByTag("ONE");
			break;
		case R.id.radio_button1:
			radioBtn = (RadioButton) findViewById(R.id.radio_button1);
			myImage = res.getDrawable(R.drawable.but_type_sel);
			radioBtn.setCompoundDrawablesWithIntrinsicBounds(null, myImage,	null, null);
			radioBtn.setTextColor(Color.parseColor("#ffffffff"));
			mHost.setCurrentTabByTag("TWO");
			break;
		case R.id.radio_button2:
			radioBtn = (RadioButton) findViewById(R.id.radio_button2);
			myImage = res.getDrawable(R.drawable.but_collect_sel);
			radioBtn.setCompoundDrawablesWithIntrinsicBounds(null, myImage,	null, null);
			radioBtn.setTextColor(Color.parseColor("#ffffffff"));
			mHost.setCurrentTabByTag("THREE");
			break;
		case R.id.radio_button3:
			radioBtn = (RadioButton) findViewById(R.id.radio_button3);
			myImage = res.getDrawable(R.drawable.but_mine_sel);
			radioBtn.setCompoundDrawablesWithIntrinsicBounds(null, myImage,	null, null);
			radioBtn.setTextColor(Color.parseColor("#ffffffff"));
			mHost.setCurrentTabByTag("FOUR");
			break;
		}        
	} 		
}

























