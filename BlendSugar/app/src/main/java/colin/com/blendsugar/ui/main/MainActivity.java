package colin.com.blendsugar.ui.main;


import android.support.annotation.NonNull;

import colin.com.blendsugar.R;
import colin.com.blendsugar.ui.base.BaseActivity;

public class MainActivity extends BaseActivity implements MainV{
    private MainPresenter presenter;
    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void setUp() {
        presenter=new MainPresenter();
        presenter.onAttach(this);
        presenter.doLogin();
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

    }

    @Override
    public void showData() {

    }
}
