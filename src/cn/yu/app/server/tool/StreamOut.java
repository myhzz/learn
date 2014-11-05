
package cn.yu.app.server.tool;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import android.util.Log;

public class StreamOut {

//	public class StreamTools {
//		public static String readInputStream(InputStream is){
//			Log.d("Tag", "------------readInputStream");
//			try {
//				ByteArrayOutputStream baos=new ByteArrayOutputStream();
//				int len=0;
//				byte[] buffer=new byte[1024];
//				while((len=is.read(buffer))!=-1)
//				{
//					baos.write(buffer,0,len);
//				}
//				is.close();
//				baos.close();
//				byte[] result=baos.toByteArray();
//				String tmep=new String(result);
//				return tmep;
//				
//				
//				
//			} catch (Exception e) {
//				// TODO: handle exception
//				e.printStackTrace();
//				return "获取失败";
//			}
//		}
//	}
       public static String readInputStream(InputStream is){
    		Log.d("Tag", "------------readInputStream");
    		try {
				ByteArrayOutputStream baos=new ByteArrayOutputStream();
				int len=0;
				byte[] buffer=new byte[1024];
				while((len=is.read(buffer))!=-1)
				{
					baos.write(buffer, 0, len);
				}
				is.close();
				baos.close();
				byte []result=baos.toByteArray();
				String tmep=new String(result);
				return tmep;
			} catch (Exception e) {
				e.printStackTrace();
				return "获取失败";
			}

       }

}
