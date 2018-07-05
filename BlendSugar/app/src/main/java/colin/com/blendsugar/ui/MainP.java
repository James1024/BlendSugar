package colin.com.blendsugar.ui;

import colin.com.blendsugar.ui.base.MvpPresenter;

/**
 * @author yiche
 * @date 2018/7/4
 */
public interface MainP <V extends MainV>extends MvpPresenter<V>{
    void doLogin();
}
