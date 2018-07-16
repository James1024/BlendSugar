package colin.com.blendsugar.ui.function.touch;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import colin.com.blendsugar.R;
import colin.com.blendsugar.ui.base.BaseActivity;
import hugo.weaving.DebugLog;

/**
 * @author wanglr
 * @date 2018/7/13
 */
public class TouchActivity extends BaseActivity {
    @Override
    public int getLayout() {
        return R.layout.activity_touch;
    }

    @Override
    public void setUp() {

    }

    @DebugLog
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("⇠","TouchActivity--onTouchEvent");
        return super.onTouchEvent(event);
    }

    @DebugLog
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e("⇠","TouchActivity--dispatchTouchEvent");
        return super.dispatchTouchEvent(ev);
    }

    public static void lanuch(Activity activity) {
        Intent intent=new Intent(activity, TouchActivity.class);
        activity.startActivity(intent);
    }

    public void  TClick(View view){
        showMessage("ttt");
    }

}
