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
	private Button loginButton;//��һ�����ȶ���һ��button����
	private ImageButton imgbt;
	private Button bt;
	private String[] res = {"beijing1","beijing2","beijing3","shanghai1","shanghai2"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);//������xml�ļ�����activity��
		
		/*
		 * 1.��ʼ����ǰ����Ҫ�Ŀؼ�
		 * findviewbyid����һ��view����(view�����пؼ��ĸ��ࣩ
		 * 2.����Button�ļ�����������ͨ��������ʵ�����ǵ��button�Ĳ���
		 * 
		 * 
		 */
		loginButton = (Button)findViewById(R.id.button1);//2����button����ͽ���ؼ���������
		imgbt = (ImageButton) findViewById(R.id.imageButton1);
		bt = (Button) findViewById(R.id.button2);
		actv = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);
		mactv = (MultiAutoCompleteTextView) findViewById(R.id.multiAutoCompleteTextView1);
//		loginButton.setOnClickListener(new OnClickListener() {
//			//4���ò�ͬ�ķ���ʵ�ּ�������    ͨ�������ڲ���ķ���ʵ�֣�
//			@Override
//			public void onClick(View arg0) {
//				// TODO Auto-generated method stub
//				//�ڵ�ǰ�����м���
//				System.out.println("i was clicked");
//			}
//		});
		/*
		 * 
		 *2.�ö�����ʵ�ּ���
		 */
		loginButton.setOnClickListener(listener);//3.��button���ü�������
		imgbt.setOnClickListener(this);//������ĽӿڵĶ���
		bt.setOnClickListener(listener2);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,res);
        actv.setAdapter(adapter);
        mactv.setAdapter(adapter);
        //���÷ָ���
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
		//4.�ò�ͬ����ʵ�ּ����¼�   ������ķ���
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
		//4.�ò�ͬ����ʵ�ּ����¼�  �ýӿڵķ���
		Log.i("tag","the thied methd ");
		//imgbt.setBackgroundColor(TRIM_MEMORY_COMPLETE);
	}
}
