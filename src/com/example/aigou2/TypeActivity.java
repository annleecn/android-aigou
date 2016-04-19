package com.example.aigou2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class TypeActivity extends Activity {
	
	private MyAdapter adapter;
	private List<String> data;
	int size = 1;
	private ListView typeList;
	private RelativeLayout smallTypeLayout;
	private GridView gridContent;
	private ImageButton smallBtnClose;
	private LinearLayout smallTypeLin;
	public static int flag = 0;
	
	//定义图片整型数组  
    private int[] mImages={  
            R.drawable.nv02,  
            R.drawable.nv03,  
            R.drawable.nv04,  
            R.drawable.nv05,  
            R.drawable.nv06,  
            R.drawable.nv07,  
            R.drawable.nv08,  
            R.drawable.nv09  
    }; 
    //定义图片文本数组  
    private String[] mTexts={"雪纺衫","打底衫","外套","衬衫","吊带","空调衫","针织衫","小西装"}; 
    
	protected void onCreate(Bundle paramBundle) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(paramBundle);
		setContentView(R.layout.type_activity);

		typeList = (ListView) findViewById(R.id.type_list);
		smallTypeLayout = (RelativeLayout) findViewById(R.id.small_type_layout);
		gridContent = (GridView) findViewById(R.id.small_type_content);
		smallBtnClose = (ImageButton) findViewById(R.id.small_type_close);
		smallTypeLin = (LinearLayout) findViewById(R.id.small_type_lin);
		
		initData();
		typeList.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				smallTypeLayout.setVisibility(View.VISIBLE);
			}
		});
		
		smallBtnClose.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				smallTypeLayout.setVisibility(View.INVISIBLE);
			}
		});
		// 点击两次关闭类型界面
		smallTypeLin.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (flag == 0) {
					flag = 1;
				} else {
					smallTypeLayout.setVisibility(View.INVISIBLE);
					flag = 0;
				}
			}
		});
		
        ArrayList<HashMap<String, Object>> lstImageItem = new ArrayList<HashMap<String, Object>>();  
          
        for (int i = 0; i < 8; i++) {  
            HashMap<String, Object> map = new HashMap<String, Object>();  
            map.put("ItemImage", mImages[i]);
            map.put("ItemText", mTexts[i]);
            lstImageItem.add(map);  
        }  
        //构建一个适配器  
        SimpleAdapter simple = new SimpleAdapter(this, lstImageItem,  
                R.layout.main_type_small_item,  
                new String[] { "ItemImage", "ItemText" }, new int[] {  
                        R.id.ItemImage, R.id.ItemText });  
        gridContent.setAdapter(simple);  
        //添加选择项监听事件  
        gridContent.setOnItemClickListener(new GridView.OnItemClickListener(){  
            @Override  
            public void onItemClick(AdapterView<?> parent, View view,  
                    int position, long id) {  
                Intent intent = new Intent(TypeActivity.this, MainActivity.class);
                startActivity(intent);
                TypeActivity.this.finish();
            }  
        }); 
	}
	//初始化数据
	private void initData() {
		if (this.typeList == null)
		return;
		this.data = new ArrayList();
		appendData();
		adapter = new MyAdapter();
		typeList.setAdapter(this.adapter);
	}

	private void appendData() {
		if (this.data == null)
		return;
		data.add("女装");
		data.add("女鞋");
		data.add("美妆");
		data.add("配饰");
		data.add("箱包");
		data.add("内衣");
		data.add("男装");
		data.add("男鞋");
		data.add("科技数码");
		data.add("汽车用品");
		data.add("零食");
		data.add("母婴");
	}

    //自定义基础适配器
	private class MyAdapter extends BaseAdapter {
		@Override
		public int getCount() {
			return data.size();
		}

		@Override
		public Object getItem(int position) {
			return data.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View view;
			if (convertView == null) {
				view = getLayoutInflater().inflate(R.layout.type_list, null);
			} else {
				view = convertView;
			}
			FrameLayout fl = (FrameLayout) view.findViewById(R.id.type_details);
			TextView tv = (TextView) view.findViewById(R.id.type_details_text);
			ImageView imageView = (ImageView) view.findViewById(R.id.type_details_img);
			tv.setText(data.get(position));
			switch (position) {
			case 0:
				imageView.setBackgroundResource(R.drawable.type1);
				break;
			case 1:
				imageView.setBackgroundResource(R.drawable.type2);
				break;
			case 2:
				imageView.setBackgroundResource(R.drawable.type3);
				break;
			case 3:
				imageView.setBackgroundResource(R.drawable.type4);
				break;
			case 4:
				imageView.setBackgroundResource(R.drawable.type5);
				break;
			case 5:
				imageView.setBackgroundResource(R.drawable.type6);
				break;
			case 6:
				imageView.setBackgroundResource(R.drawable.type7);
				break;
			case 7:
				imageView.setBackgroundResource(R.drawable.type8);
				break;
			case 8:
				imageView.setBackgroundResource(R.drawable.type9);
				break;
			case 9:
				imageView.setBackgroundResource(R.drawable.type10);
				break;
			case 10:
				imageView.setBackgroundResource(R.drawable.type11);
				break;
			case 11:
				imageView.setBackgroundResource(R.drawable.type12);
				break;
			}
			return view;
		}
	}
}