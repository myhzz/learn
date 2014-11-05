package fragement;


import cn.yu.app.R;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.ImageView;
import android.widget.TextView;

public class FragmentA extends Fragment{
	private View view;
	private ImageView im1,im2,im3,im4,im5,im6,im7;
	private ImageView im8,im9,im10,im11,im12,im13,im14;
	private String path1,path2,path3,path4,path5,path6,path7;
	private String path8,path9,path10,path11,path12,path13,path14;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		view = inflater.inflate(R.layout.fragmenta, null);
		im1=(ImageView)view.findViewById(R.id.im1);
		im2=(ImageView)view.findViewById(R.id.im22);
		im3=(ImageView)view.findViewById(R.id.im3);
		im4=(ImageView)view.findViewById(R.id.im4);
		im5=(ImageView)view.findViewById(R.id.im5);
		im6=(ImageView)view.findViewById(R.id.im6);
		im7=(ImageView)view.findViewById(R.id.im7);
		im8=(ImageView)view.findViewById(R.id.im8);
		im9=(ImageView)view.findViewById(R.id.im9);
		im10=(ImageView)view.findViewById(R.id.im10);
		im11=(ImageView)view.findViewById(R.id.im11);
		im12=(ImageView)view.findViewById(R.id.im12);
		im13=(ImageView)view.findViewById(R.id.im13);
		im14=(ImageView)view.findViewById(R.id.im14);
		return view;
	}
}
