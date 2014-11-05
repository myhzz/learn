package cn.yu.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import cn.yu.app.util.NetworkUtil;
import cn.yu.app.util.ToastUtil;

/**
 * 启动微博界面
 * @author yu.lin
 *
 */
public class AppStartActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_app_start);
		
		new Handler().postDelayed(new Runnable() {
			
			@Override
			public void run() {
//				if(NetworkUtil.getNetworkState(AppStartActivity.this) != NetworkUtil.NONE) {
					Intent intent = null;
					intent = new Intent(AppStartActivity.this, LoginActivity.class);
					startActivity(intent);
					AppStartActivity.this.finish();
//				} else
//					ToastUtil.showShortToast(AppStartActivity.this, "没有网络");
			}
		}, 2000);
	}

}
