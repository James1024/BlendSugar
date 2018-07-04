package colin.com.blendsugar;

import android.app.Application;

import com.androidnetworking.AndroidNetworking;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;

/**
 * Created by wanglirong on 2018/7/3.
 */
public class SugarApp extends Application {
    OkHttpClient okHttpClient = new OkHttpClient() .newBuilder()
            .addNetworkInterceptor(new StethoInterceptor())
            .build();


    @Override
    public void onCreate() {
        super.onCreate();
        AndroidNetworking.initialize(this,okHttpClient);
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
