package colin.com.blendsugar.ui.base;

import com.androidnetworking.error.ANError;

/**
 * @author yiche
 * @date 2018/7/4
 */
public interface MvpPresenter<V extends MvpView> {

    /**
     * @param mvpView
     */
    void onAttach(V mvpView);

    /**
     *
     */
    void onDetach();

    /**
     * @param error
     */
    void handleApiError(ANError error);

    /**
     *
     */
    void setUserAsLoggedOut();



}
