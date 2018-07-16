package colin.com.blendsugar.ui.function.touch;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

import hugo.weaving.DebugLog;

/**
 * @author wanglr
 * @date 2018/7/13
 */
public class TButton extends android.support.v7.widget.AppCompatButton {
    public TButton(Context context) {
        super(context);
    }

    public TButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @DebugLog
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("⇠","TButton--onTouchEvent");

        return super.onTouchEvent(event);
    }
    @DebugLog
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e("⇠","TButton--dispatchTouchEvent");
        return super.dispatchTouchEvent(ev);
    }

}
