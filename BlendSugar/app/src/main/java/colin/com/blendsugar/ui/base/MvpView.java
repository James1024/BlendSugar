package colin.com.blendsugar.ui.base;

import android.support.annotation.StringRes;

/**
 * @author yiche
 * @date 2018/7/4
 */
public interface MvpView {

    /**
     * 展示dialog
     */
    void showLoading();

    /**
     * 隐藏dialog
     */
    void hideLoading();

    /**
     * @param resId
     */
    void onError(@StringRes int resId);
    /**
     *
     */
    void onError(String message);
    /**
     *
     */
    void showMessage(String message);

    /**
     * @param resId
     */
    void showMessage(@StringRes int resId);
    /**
     *
     */
    boolean isNetworkConnected();
    /**
     *
     */
    void hideKeyboard();

}
