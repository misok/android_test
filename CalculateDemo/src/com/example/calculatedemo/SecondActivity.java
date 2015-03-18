package com.example.calculatedemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SecondActivity extends Activity {
	private Button bt2;
	private String content = "你好，我是回传数据";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		bt2 = (Button) findViewById(R.id.button2);
		
		bt2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				//回传了一个intent对象
				Intent data = new Intent();//不需要指定目标因为不需要跳转只是信息
				data.putExtra("data", content);//把数据放入data中
				setResult(2,data);
				System.out.println(content);
				finish();//结束我当前这个页面
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.second, menu);
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
}
