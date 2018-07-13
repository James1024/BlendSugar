package colin.com.blendsugar.ui.architecture.mvp;

/**
 * @author wanglr
 * @date 2018/7/11
 */
public class TabPresenter implements TabP{

    TabV tabV;

    public TabPresenter(TabV tabV) {
        this.tabV = tabV;
    }

    @Override
    public void doLogin(int i) {
        tabV.setData("返回："+i);
    }

}
