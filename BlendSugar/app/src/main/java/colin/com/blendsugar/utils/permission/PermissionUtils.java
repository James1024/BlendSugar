package colin.com.blendsugar.utils.permission;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.Fragment;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import colin.com.blendsugar.R;

/**
 * Created by nieyunlong on 16/12/12.
 * 授权权限
 * 6.0 以上 判断权限管理 6.0一下不需判断
 *
 * 在 Android O 之前，如果应用在运行时请求权限并且被授予该权限，系统会错误地将属于同一权限组并且在清单中注册的其他权限也一起授予应用。

 对于针对Android O的应用，此行为已被纠正。系统只会授予应用明确请求的权限。然而一旦用户为应用授予某个权限，则所有后续对该权限组中权限的请求都将被自动批准

    也就是说 如果你申请了 写权限 再次请求读权限的时候不会再次弹窗提示 但是你在使用读权限的时候 实际是没有赋予这个权限的
 */
public class PermissionUtils {

    private Object object;
    private PermissionResultListener permissonResultListener;

    public PermissionUtils(Object object) {
        this.object = object;
    }

    public static boolean isOverMarshmallow() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.M;
    }

    public PermissionUtils setPermissonResult(PermissionResultListener permissonResult) {
        this.permissonResultListener = permissonResult;
        return this;
    }

    /**
     * 请求权限
     *
     * @param requestCode 请求码
     * @param permissions 权限集合
     */
    @Deprecated
    @TargetApi(Build.VERSION_CODES.M)
    public void requestPermisson(int requestCode, String... permissions) {
        if (!isOverMarshmallow()) {
            if (permissonResultListener != null) {
                permissonResultListener.exeSuccessPermission();
            }
            return;
        }
        //没有同意的集合
        List<String> deniedPermissions = PermissionListUtils.findDeniedPermissions(getActivity(object), permissions);
        if (deniedPermissions.size() > 0) {
            if (object instanceof Activity) {
                ((Activity) object).requestPermissions(deniedPermissions.toArray(new String[deniedPermissions.size()]), requestCode);
            } else if (object instanceof Fragment) {
                ((Fragment) object).requestPermissions(deniedPermissions.toArray(new String[deniedPermissions.size()]), requestCode);
            } else {
                throw new IllegalArgumentException(object.getClass().getName() + " is not supported");
            }
        } else {
            if (permissonResultListener != null) {
                permissonResultListener.exeSuccessPermission();
            }
        }

    }

    /**
     * 请求权限
     *
     * @param requestCode      请求码
     * @param permissionsGroup 权限组
     * 适配8.0
     */
    @TargetApi(Build.VERSION_CODES.M)
    public void requestPermission(int requestCode, String[]... permissionsGroup) {
        List<String> permissionList = new ArrayList<>();
        for (String[] group : permissionsGroup) {
            permissionList.addAll(Arrays.asList(group));
        }
        String[] permissions = permissionList.toArray(new String[permissionList.size()]);
        this.requestPermisson(requestCode, permissions);
    }

    /**
     * 请求获取请求权限结果
     */
    public void onRequestPermissionsResult(Activity activity, int requestCode, String[] permissions, int[] grantResults) {
        requestResult(activity, requestCode, permissions, grantResults);
    }

    private void requestResult(Activity activity, int requestCode, String[] permissions, int[] grantResults) {
        List<String> deniedPermissions = new ArrayList<>();
        for (int i = 0; i < grantResults.length; i++) {
            if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                deniedPermissions.add(permissions[i]);
            }
        }

        if (deniedPermissions.size() > 0) {
            if (PermissionListUtils.hasNeverAskAgainPermission(getActivity(activity), deniedPermissions)) {
                List<String> nevenAskAginPermissions = PermissionListUtils.findNeverAskAgainPermissions(activity, permissions);
                List<String> deniedWithoutNevenAskAginPermission = PermissionListUtils.findDeniedPermissionWithoutNeverAskAgain(activity, permissions);
                StringBuilder sb = new StringBuilder();
                sb.append(activity.getString(R.string.refuse_permission_start_setting));
                sb.append(PermissionListUtils.toString(nevenAskAginPermissions));
                if (deniedWithoutNevenAskAginPermission != null && !deniedWithoutNevenAskAginPermission.isEmpty()) {
                    sb.append(activity.getString(R.string.refuse_permission_next_ask));
                    sb.append(PermissionListUtils.toString(deniedWithoutNevenAskAginPermission));
                }
                exePermissionFailAsNeverAskAgain(sb.toString());
            } else {
                if (permissions.length > 0) {
                    List<String> deniedPermissionsResult = PermissionListUtils.findDeniedPermissions(activity, permissions);
                    exePermissionFailed(deniedPermissionsResult);
                }
            }
        } else {
            exePermissionSuccess();
        }
    }

    public void exePermissionSuccess() {
        if (permissonResultListener != null) {
            permissonResultListener.exeSuccessPermission();
        }
    }

    public void exePermissionFailed(List<String> permissions) {
        if (permissonResultListener != null) {
            permissonResultListener.exeFailed(permissions);
        }
    }

    public void exePermissionFailAsNeverAskAgain(String askNeverPermissionsResult) {
        if (permissonResultListener != null) {
            permissonResultListener.exeAskNeverPermission(askNeverPermissionsResult);
        }
    }

    public static Activity getActivity(Object object) {
        if (object instanceof Fragment) {
            return ((Fragment) object).getActivity();
        } else if (object instanceof Activity) {
            return (Activity) object;
        }
        return null;
    }

}
