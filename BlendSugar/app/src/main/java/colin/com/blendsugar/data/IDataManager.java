package colin.com.blendsugar.data;

import colin.com.blendsugar.data.db.IDBHelper;
import colin.com.blendsugar.data.net.INetHelper;
import colin.com.blendsugar.data.prefs.IPreferencesHelper;

/**
 * Created by wanglirong on 2018/7/3.
 */
public interface IDataManager extends INetHelper,IPreferencesHelper,IDBHelper {

}
