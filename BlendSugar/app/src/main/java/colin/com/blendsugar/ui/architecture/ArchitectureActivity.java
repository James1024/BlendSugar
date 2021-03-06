package colin.com.blendsugar.ui.architecture;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import colin.com.blendsugar.ui.architecture.mvc.LoginActivity;
import colin.com.blendsugar.ui.architecture.mvp.TabActivity;
import colin.com.blendsugar.ui.main.BaseListActivity;
import colin.com.blendsugar.ui.main.BaseListAdapter;

/**
 * @author wanglr
 * @date 2018/7/11
 */
public class ArchitectureActivity extends BaseListActivity implements BaseListAdapter.OnItemClickListener {


    @Override
    public void setUp() {
        super.setUp();
        list.add("mvp");
        list.add("mvc");
        list.add("mvvm");
        list.add("fluter");
        mAdapter.notifyDataSetChanged();
        mAdapter.setOnItemClickListener(this);

    }

    @Override
    public void onItemClickListener(View view, int position) {
        switch (position) {
            case 0:
                TabActivity.lanuch(this);
                break;
            case 1:
                LoginActivity.lanuch(this);
                break;
            default:
        }

    }

    public static void lanuch(Activity activity) {
        Intent intent = new Intent(activity, ArchitectureActivity.class);
        activity.startActivity(intent);
    }
}
