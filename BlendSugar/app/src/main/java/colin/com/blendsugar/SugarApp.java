package colin.com.blendsugar;

import android.app.Application;

import com.androidnetworking.AndroidNetworking;

import java.io.IOException;

import colin.com.blendsugar.data.DataManager;
import colin.com.blendsugar.data.IDataManager;
import colin.com.blendsugar.data.net.NetHelper;
import colin.com.blendsugar.data.prefs.PreferencesHelper;
import colin.com.blendsugar.utils.ActivityStack;
import colin.com.blendsugar.utils.rx.AppSchedulerProvider;
import colin.com.blendsugar.utils.rx.SchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;

/**
 * Created by wanglirong on 2018/7/3.
 */
public class SugarApp extends Application {
    public static SugarApp instance;
    private IDataManager iDataManager;
    private SchedulerProvider schedulerProvider;
    private CompositeDisposable mCompositeDisposable;


    public ActivityStack stack;

    public static SugarApp getInstance() {
        return instance;
    }

    public ActivityStack getStack() {
        return stack;
    }
    public IDataManager getDataManager() {
        return iDataManager;
    }

    public SchedulerProvider getSchedulerProvider(){
        return schedulerProvider;
    }

    public CompositeDisposable getCompositeDisposable(){
        return mCompositeDisposable;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        iDataManager=new DataManager(this,new PreferencesHelper(),new NetHelper());
        schedulerProvider=new AppSchedulerProvider();
        mCompositeDisposable=new CompositeDisposable();
        AndroidNetworking.initialize(this, new OkHttpClient() .newBuilder()
                .addNetworkInterceptor(new StethoInterceptor())
                .build());
    }

    private static class StethoInterceptor implements Interceptor {
        @Override
        public okhttp3.Response intercept(Chain chain) throws IOException {
            okhttp3.Response response = chain.proceed(chain.request());
            okhttp3.MediaType mediaType = response.body().contentType();
            String content = response.body().string();
            if (response.body() != null) {
                ResponseBody body = ResponseBody.create(mediaType, content);
                return response.newBuilder().body(body).build();
            } else {
                return response;
            }
        }
    }

}
