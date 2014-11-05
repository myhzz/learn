package cn.yu.app;

import cn.yu.app.server.LoginServer;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity{
	private EditText login_ed_count,login_ed_pass;
	private Button login_button,login_visitor;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.activity_login);
		getView();
		login_button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				new Thread(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
////						if(login_ed_count.getText().toString().equals("")||login_ed_pass.getText().equals(""))
//						{
//							runOnUiThread(new Runnable() {
//								
//								@Override
//								public void run() {
//									// TODO Auto-generated method stub
//									Toast.makeText(LoginActivity.this, "请核实信息", 0).show();
//								}
//							});
//							
//						}
//						else
//						{
//						String resulst=LoginServer.LoginbyGet(login_ed_count.getText().toString(), login_ed_pass.getText().toString());
//				         
//						if(resulst.equals("login success"))
//						{
//							runOnUiThread(new Runnable() {
//								
//								@Override
//								public void run() {
									// TODO Auto-generated method stub
									startActivity(new Intent(LoginActivity.this,VideoPlay.class));//登陆成功跳转到下一个界面
									
//								}
//							});
//						}
//						else {
//							runOnUiThread(new  Runnable() {
//								public void run() {
//									Toast.makeText(LoginActivity.this, "密码或账号错误", 0).show();
//								}
//							});
//						}
						}
//					}
				}).start();
			}
		});
		login_visitor.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
		         //跳转到下一个界面
				
			}
		});
	}
	
	private void getView()
	{
		login_ed_pass=(EditText) findViewById(R.id.login_ed_pass);
		login_ed_count=(EditText) findViewById(R.id.login_ed_count);
		login_button=(Button) findViewById(R.id.login_button);
		login_visitor=(Button) findViewById(R.id.login_visitor);
	}
	
}
