package cn.yu.app;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.ImageView;

import cn.yu.app.R;
import cn.yu.app.R.id;
import cn.yu.app.R.layout;
import fragement.MainActivity;
public class GoodA extends Activity {
//	private FragmentManager fm = getSupportFragmentManager();
//	private FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.activity_main_page);
//		fragmentTransaction.replace(R.id.fragmentmain, new MainActivity());
//		fragmentTransaction.commit();
	}

}