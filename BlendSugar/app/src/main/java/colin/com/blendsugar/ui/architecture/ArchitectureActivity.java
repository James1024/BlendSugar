package colin.com.blendsugar.ui.architecture;

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
import colin.com.blendsugar.ui.architecture.mvp.TabActivity;

/**
 * @author wanglr
 * @date 2018/7/11
 */
public class ArchitectureActivity extends BaseActivity implements ArchitectureAdapter.OnItemClickListener{
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private List<String> list;
    private ArchitectureAdapter mainAdapter;
    @Override
    public int getLayout() {
        return R.layout.activity_architecture;
    }

    @Override
    public void setUp() {
        list=new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mainAdapter=new ArchitectureAdapter(list);
        recyclerView.setAdapter(mainAdapter);
        mainAdapter.setOnItemClickListener(this);

        list.add("mvp");
        list.add("mvvm");
        list.add("mvc");
        list.add("fluter");
        mainAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClickListener(View view, int position) {
        switch (position){
            case 0:
                TabActivity.lanuch(this);
                break;
            case 1:

                break;
            default:
        }

    }
    public static void lanuch(Activity activity) {
        Intent intent=new Intent(activity,ArchitectureActivity.class);
        activity.startActivity(intent);
    }
}
