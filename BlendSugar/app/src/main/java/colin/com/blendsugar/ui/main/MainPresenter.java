package colin.com.blendsugar.ui.main;

import colin.com.blendsugar.ui.base.BasePresenter;

/**
 * @author yiche
 * @date 2018/7/4
 */
public class MainPresenter <V extends MainV>extends BasePresenter<V> implements MainP<V>{
    MainV mainV;

    public MainPresenter(MainV mainV) {
        this.mainV=mainV;
    }


    @Override
    public void doLogin() {
        mainV.showData();
    }
}
