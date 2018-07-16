package colin.com.blendsugar.ui.function;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import colin.com.blendsugar.ui.function.touch.TouchActivity;
import colin.com.blendsugar.ui.main.BaseListActivity;
import colin.com.blendsugar.ui.main.BaseListAdapter;

/**
 * @author wanglr
 * @date 2018/7/11
 */
public class FunctionListActivity extends BaseListActivity implements BaseListAdapter.OnItemClickListener {

    @Override
    public void setUp() {
        super.setUp();
        list.add("touch");
        mAdapter.notifyDataSetChanged();
        mAdapter.setOnItemClickListener(this);
    }

    @Override
    public void onItemClickListener(View view, int position) {
        switch (position) {
            case 0:
                TouchActivity.lanuch(this);
                break;

            default:
        }

    }

    public static void lanuch(Activity activity) {
        Intent intent = new Intent(activity, FunctionListActivity.class);
        activity.startActivity(intent);
    }
}
