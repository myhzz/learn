package cn.yu.app.server;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import cn.yu.app.server.tool.StreamOut;

import android.util.Log;



public class LoginServer {
	public static String LOGIN="personlogin";
	public static String BUFFER="gettenvideo";
	public static String PROBLEM="theawserofthequestion";
	public static String LoginbyGet(String id ,String passwrod){
		try {
		String path="http://172.21.28.1:8080/projectfile/servlet/Do";
		URL url=new URL(path);
		HttpURLConnection conn=(HttpURLConnection) url.openConnection();
		conn.setConnectTimeout(5000);
		conn.setRequestMethod("POST");
		String data="id="+id+"&password="+passwrod+"&select="+LOGIN;
		conn.setRequestProperty("Content-tpye", "application/x-www-form-urlencoded");
		conn.setRequestProperty("Content-Length", data.length()+"");
		conn.setDoOutput(true);
		OutputStream  os=conn.getOutputStream();
		os.write(data.getBytes());
		int code=conn.getResponseCode();
		if(code==200)
		{
			InputStream is=conn.getInputStream();
			String text=StreamOut.readInputStream(is);
			Log.d("Tag", text);
			return text;
		}
		else
		{
			return "1";
		}
		} catch (Exception e) {
			// TODO: handle exception
			return "1";
		}
		

	} 
}
