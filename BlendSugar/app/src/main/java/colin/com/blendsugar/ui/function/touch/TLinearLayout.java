package colin.com.blendsugar.ui.function.touch;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import hugo.weaving.DebugLog;

/**
 * @author wanglr
 * @date 2018/7/13
 */
public class TLinearLayout extends LinearLayout {
    public TLinearLayout(Context context) {
        super(context);
    }

    public TLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @DebugLog
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("⇠","TLinearLayout--onTouchEvent");
        return super.onTouchEvent(event);
    }
    @DebugLog
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {//
        Log.e("⇠","TLinearLayout--dispatchTouchEvent");
        return false;
    }
    @DebugLog
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.e("⇠","TLinearLayout--onInterceptTouchEvent");
        return true;
    }
}
