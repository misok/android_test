package com.misok.helloworld;

import android.app.Activity;
import android.app.SearchManager.OnCancelListener;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.MultiAutoCompleteTextView;

public class MainActivity extends Activity implements OnClickListener {
	private AutoCompleteTextView actv;
	private MultiAutoCompleteTextView mactv;
	private Button loginButton;//第一步：先定义一个button对象
	private ImageButton imgbt;
	private Button bt;
	private String[] res = {"beijing1","beijing2","beijing3","shanghai1","shanghai2"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);//将布局xml文件引入activity中
		
		/*
		 * 1.初始化当前所需要的控件
		 * findviewbyid返回一个view对象(view是所有控件的父类）
		 * 2.设置Button的监听器监听，通过监听器实现我们点击button的操作
		 * 
		 * 
		 */
		loginButton = (Button)findViewById(R.id.button1);//2，把button对象和界面控件关联起来
		imgbt = (ImageButton) findViewById(R.id.imageButton1);
		bt = (Button) findViewById(R.id.button2);
		actv = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);
		mactv = (MultiAutoCompleteTextView) findViewById(R.id.multiAutoCompleteTextView1);
//		loginButton.setOnClickListener(new OnClickListener() {
//			//4，用不同的方法实现监听动作    通过匿名内部类的方法实现）
//			@Override
//			public void onClick(View arg0) {
//				// TODO Auto-generated method stub
//				//在当前方法中监听
//				System.out.println("i was clicked");
//			}
//		});
		/*
		 * 
		 *2.用独立类实现监听
		 */
		loginButton.setOnClickListener(listener);//3.给button设置监听对象
		imgbt.setOnClickListener(this);//访问类的接口的对象
		bt.setOnClickListener(listener2);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,res);
        actv.setAdapter(adapter);
        mactv.setAdapter(adapter);
        //设置分隔符
        mactv.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
		}
	OnClickListener listener2 = new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			bt.setText("press");
		}
	};
	OnClickListener listener = new OnClickListener() {
		//4.用不同方法实现监听事件   独立类的方法
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			//System.out.println("i was implement by idenpendent class");
			Log.i("tag","i was implement by indenpendent class");
		}
	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		//4.用不同方法实现监听事件  用接口的方法
		Log.i("tag","the thied methd ");
		//imgbt.setBackgroundColor(TRIM_MEMORY_COMPLETE);
	}
}
