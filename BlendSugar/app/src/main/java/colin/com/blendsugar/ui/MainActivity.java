package colin.com.blendsugar.ui;


import android.support.annotation.NonNull;

import com.androidnetworking.error.ANError;

import colin.com.blendsugar.R;
import colin.com.blendsugar.SugarApp;
import colin.com.blendsugar.data.DataManager;
import colin.com.blendsugar.data.IDataManager;
import colin.com.blendsugar.ui.base.BaseActivity;
import colin.com.blendsugar.ui.base.MvpView;
import colin.com.blendsugar.utils.rx.AppSchedulerProvider;
import colin.com.blendsugar.utils.rx.SchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;

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
