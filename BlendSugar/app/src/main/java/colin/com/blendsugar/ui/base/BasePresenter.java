package colin.com.blendsugar.ui.base;

import com.androidnetworking.error.ANError;
import colin.com.blendsugar.SugarApp;
import colin.com.blendsugar.data.IDataManager;
import colin.com.blendsugar.utils.rx.SchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;

/**
 * @author yiche
 * @date 2018/7/4
 */
public class BasePresenter<V extends MvpView> implements MvpPresenter<V> {
    private  IDataManager mDataManager;
    private  SchedulerProvider mSchedulerProvider;
    private  CompositeDisposable mCompositeDisposable;
    private V mMvpView;

    public BasePresenter() {
        this.mDataManager = SugarApp.getInstance().getDataManager();
        this.mSchedulerProvider = SugarApp.getInstance().getSchedulerProvider();
        this.mCompositeDisposable = SugarApp.getInstance().getCompositeDisposable();
    }

    @Override
    public void onAttach(V mvpView) {
        this.mMvpView = mvpView;

    }

    @Override
    public void onDetach() {
        mCompositeDisposable.dispose();
        mMvpView = null;
    }

    @Override
    public void handleApiError(ANError error) {

    }

    @Override
    public void setUserAsLoggedOut() {

    }
    /**
     * @return
     */
    public boolean isViewAttached() {
        return mMvpView != null;
    }

    public V getMvpView() {
        return mMvpView;
    }


    public IDataManager getDataManager() {
        return mDataManager;
    }

    public SchedulerProvider getSchedulerProvider() {
        return mSchedulerProvider;
    }

    public CompositeDisposable getCompositeDisposable() {
        return mCompositeDisposable;
    }
}
