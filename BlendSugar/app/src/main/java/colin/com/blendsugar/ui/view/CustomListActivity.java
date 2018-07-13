package colin.com.blendsugar.ui.view;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import colin.com.blendsugar.R;
import colin.com.blendsugar.ui.base.BaseActivity;
import colin.com.blendsugar.ui.view.pupop.PupopActivity;

/**
 * @author wanglr
 * @date 2018/7/11
 */
public class CustomListActivity extends BaseActivity implements CustomAdapter.OnItemClickListener{
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private List<String> list;
    private CustomAdapter customAdapter;
    @Override
    public int getLayout() {
        return R.layout.activity_custom_list;
    }

    @Override
    public void setUp() {
        list=new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        customAdapter =new CustomAdapter(list);
        recyclerView.setAdapter(customAdapter);
        customAdapter.setOnItemClickListener(this);

        list.add("pupop");
        list.add("111");
        list.add("222");
        list.add("333");
        customAdapter.notifyDataSetChanged();
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
        Intent intent=new Intent(activity, CustomListActivity.class);
        activity.startActivity(intent);
    }
}
