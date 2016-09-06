package mtk.kelompok.util;

/**
 * Pratama Nur Wijaya (c) 2013 
 * 
 * Project       : ExampleAndroidQuiz
 * Filename      : Utils.java
 * Creation Date : Jul 30, 2013 time : 12:51:08 PM
 *
 */



import android.util.Log;
import mtk.arifandy.com.BuildConfig;

public class Utils
{
	/**
	 * Method untuk debugging apps
	 * 
	 * @param TAG
	 *            TAG class
	 * @param message
	 *            Pesan
	 */
	public static void TRACE(String TAG, String message)
	{
		if (BuildConfig.DEBUG)
		{
			Log.d(TAG, message);
		}
	}

}
