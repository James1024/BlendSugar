package colin.com.blendsugar.utils.log;


import android.util.Log;
import colin.com.blendsugar.BuildConfig;

public class AppLogger {
    private static boolean logDebug=true;
    private static boolean debug= BuildConfig.DEBUG&&logDebug;


    public static void d(String tag,String string) {
        if(debug){
            Log.d(tag,string);
        }
    }

    public static void e(String tag,String string) {
        if(debug){
            Log.e(tag,string);
        }
    }

    public static void w(String tag,String string) {
        if(debug){
            Log.w(tag,string);
        }
    }

    public static void i(String tag,String string) {
        if(debug){
            Log.i(tag,string);
        }
    }
    public static void v(String tag,String string) {
        if(debug){
            Log.v(tag,string);
        }
    }




}