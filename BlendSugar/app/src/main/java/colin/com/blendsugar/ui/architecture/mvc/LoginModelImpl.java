package colin.com.blendsugar.ui.architecture.mvc;

import colin.com.blendsugar.SugarApp;

/**
 * @author wanglr
 * @date 2018/7/13
 */
public class LoginModelImpl implements LoginModle{
    @Override
    public void doLogin(String user, String name,LoginView loginView) {
        loginView.onSuccess("success");
        SugarApp.getInstance().getDataManager().getData(1);
    }
}
