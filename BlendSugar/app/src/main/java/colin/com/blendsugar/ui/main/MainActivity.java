package colin.com.blendsugar.ui.main;

import android.view.View;
import colin.com.blendsugar.ui.architecture.ArchitectureActivity;
import colin.com.blendsugar.ui.function.FunctionListActivity;
import colin.com.blendsugar.ui.view.ViewListActivity;

/**
 * @author yiche
 */

public class MainActivity extends BaseListActivity implements MainV, BaseListAdapter.OnItemClickListener {

    private MainPresenter presenter;

    @Override
    public void setUp() {
        super.setUp();
        presenter = new MainPresenter(this);
        presenter.onAttach(this);
        presenter.doLogin();
        initData();
    }

    private void initData() {
        list.add("custom");
        list.add("architecture");
        list.add("function");
        mAdapter.notifyDataSetChanged();
        mAdapter.setOnItemClickListener(this);
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
        switch (position) {
            case 0:
                ViewListActivity.lanuch(this);
                break;
            case 1:
                ArchitectureActivity.lanuch(this);
                break;
            case 2:
                FunctionListActivity.lanuch(this);
            default:
        }

    }
}
