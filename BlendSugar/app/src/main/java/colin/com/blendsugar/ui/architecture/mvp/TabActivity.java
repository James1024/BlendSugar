package colin.com.blendsugar.ui.architecture.mvp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import colin.com.blendsugar.R;

/**
 * @author wanglr
 * @date 2018/7/11
 */
public class TabActivity extends Activity implements TabV{

    public static void lanuch(Activity activity) {
        Intent intent=new Intent(activity,TabActivity.class);
        activity.startActivity(intent);
    }


    @BindView(R.id.textView)
    TextView textView;
    TabPresenter presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        ButterKnife.bind(this);
        presenter=new TabPresenter(this);
        presenter.doLogin(1000);
    }

    @Override
    public void setData(String s) {
        textView.setText(s);
    }

    public void Click(View view) {

    }
}
