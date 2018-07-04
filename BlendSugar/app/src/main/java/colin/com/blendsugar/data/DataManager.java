package colin.com.blendsugar.data;

import android.content.Context;

import colin.com.blendsugar.data.net.INetHelper;
import colin.com.blendsugar.data.prefs.IPreferencesHelper;

/**
 * Created by wanglirong on 2018/7/3.
 */
public class DataManager implements IDataManager {
    private final Context mContext;
    private final IPreferencesHelper mPreferencesHelper;
    private final INetHelper mNetHelper;

    public DataManager(Context context,IPreferencesHelper preferencesHelper,
                          INetHelper netHelper) {
        mContext = context;
        mPreferencesHelper = preferencesHelper;
        mNetHelper = netHelper;
    }

    @Override
    public void getData(int i) {
        mNetHelper.getData(i);
    }
}
