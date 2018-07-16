package colin.com.blendsugar.ui.view;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import java.util.ArrayList;

import colin.com.blendsugar.ui.main.BaseListActivity;
import colin.com.blendsugar.ui.main.BaseListAdapter;
import colin.com.blendsugar.ui.view.pupop.PupopActivity;

/**
 * @author wanglr
 * @date 2018/7/11
 */
public class ViewListActivity extends BaseListActivity implements BaseListAdapter.OnItemClickListener{

    @Override
    public void setUp() {
        super.setUp();
        list=new ArrayList<>();
        list.add("pupop");
        mAdapter.notifyDataSetChanged();
        mAdapter.setOnItemClickListener(this);
    }

    @Override
    public void onItemClickListener(View view, int position) {
        switch (position){
            case 0:
                PupopActivity.lanuch(this);
                break;
            case 1:

                break;
            default:
        }

    }
    public static void lanuch(Activity activity) {
        Intent intent=new Intent(activity, ViewListActivity.class);
        activity.startActivity(intent);
    }
}
