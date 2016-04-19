package com.example.aigou2;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;

public class CollectActivity extends Activity
{
	private Button collectProduct, collectShop;
	private FrameLayout collectProductfl, collectShopfl;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.collect_activity);
		
		collectProduct = (Button) findViewById(R.id.collect_product);
		collectShop = (Button) findViewById(R.id.collect_shop);
		collectProductfl = (FrameLayout) findViewById(R.id.collect_product_fl);
		collectShopfl = (FrameLayout) findViewById(R.id.collect_shop_fl);
		
		collectProduct.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				collectProduct.setBackgroundResource(R.drawable.collect_butbg_sel);
				collectProduct.setTextColor(Color.parseColor("#FF0000"));
				collectShop.setTextColor(Color.parseColor("#ffc5c5c5"));
				collectShop.setBackgroundResource(R.drawable.collect_butbg_nosel);
				collectProductfl.setVisibility(View.VISIBLE);
				collectShopfl.setVisibility(View.INVISIBLE);
			}
		});
		collectShop.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				collectShop.setBackgroundResource(R.drawable.collect_butbg_sel);
				collectShop.setTextColor(Color.parseColor("#FF0000"));
				collectProduct.setTextColor(Color.parseColor("#ffc5c5c5"));
				collectProduct.setBackgroundResource(R.drawable.collect_butbg_nosel);
				collectShopfl.setVisibility(View.VISIBLE);
				collectProductfl.setVisibility(View.INVISIBLE);
			}
		});
	}
}











