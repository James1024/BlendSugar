package colin.com.blendsugar.ui;

import android.app.Activity;
import android.support.annotation.NonNull;
import colin.com.blendsugar.R;
import colin.com.blendsugar.ui.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void setUp() {

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

    }
}
