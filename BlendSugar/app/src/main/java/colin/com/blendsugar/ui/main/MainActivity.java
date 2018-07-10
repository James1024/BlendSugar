package colin.com.blendsugar.ui.main;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.OnClick;
import colin.com.blendsugar.R;
import colin.com.blendsugar.ui.base.BaseActivity;
import colin.com.blendsugar.ui.view.CustomActivity;
import hugo.weaving.DebugLog;

/**
 * @author yiche
 */
@DebugLog
public class MainActivity extends BaseActivity implements MainV ,MainAdapter.OnItemClickListener{
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private MainPresenter presenter;
    private List<String> list;
    private  MainAdapter mainAdapter;
    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void setUp() {
        presenter = new MainPresenter();
        presenter.onAttach(this);
        presenter.doLogin();
        initData();


    }

    private void initData() {
        list=new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mainAdapter=new MainAdapter(list);
        recyclerView.setAdapter(mainAdapter);
        mainAdapter.setOnItemClickListener(this);

        list.add("111");
        list.add("112");
        list.add("113");
        mainAdapter.notifyDataSetChanged();

    }

    @Override
    public void showData() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDetach();
    }



    @Override
    public void onItemClickListener(View view, int position) {
        switch (position){
            case 0:
                CustomActivity.lanuch(this);
                break;
            case 1:

                break;
                default:
        }

    }
}
