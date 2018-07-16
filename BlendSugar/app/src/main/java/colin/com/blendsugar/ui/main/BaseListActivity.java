package colin.com.blendsugar.ui.main;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import colin.com.blendsugar.R;
import colin.com.blendsugar.ui.base.BaseActivity;

/**
 * @author wanglr
 * @date 2018/7/13
 */
public class BaseListActivity extends BaseActivity {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    public List<String> list;
    public BaseListAdapter mAdapter;

    @Override
    public int getLayout() {
        return R.layout.activity_base_list;
    }

    @Override
    public void setUp() {
        list = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new BaseListAdapter(list);
        recyclerView.setAdapter(mAdapter);
    }


}
