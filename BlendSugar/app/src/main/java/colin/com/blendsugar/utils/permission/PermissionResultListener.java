package colin.com.blendsugar.utils.permission;

import java.util.List;

/**
 * Created by nieyunlong on 16/12/12.
 */
public interface PermissionResultListener {
    void exeSuccessPermission();

    void exeFailed(List<String> failedPermissionsResult);

    void exeAskNeverPermission(String askNeverResultToast);
}
