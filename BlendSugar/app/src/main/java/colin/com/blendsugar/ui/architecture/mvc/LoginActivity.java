package colin.com.blendsugar.ui.architecture.mvc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import colin.com.blendsugar.R;

/**
 * @author wanglr
 * @date 2018/7/11
 */
public class LoginActivity extends Activity implements LoginView {
    public static void lanuch(Activity activity) {
        Intent intent = new Intent(activity, LoginActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    @Override
    public void onSuccess(String str) {
        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFiled() {

    }

    public void LoginClick(View view) {
        LoginModle loginModle = new LoginModelImpl();
        loginModle.doLogin("", "", this);
    }
}
