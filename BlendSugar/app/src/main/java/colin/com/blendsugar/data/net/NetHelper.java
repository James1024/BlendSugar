package colin.com.blendsugar.data.net;

import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.ResponseBody;
/**
 * Created by wanglirong on 2018/7/3.
 */
public class NetHelper implements INetHelper {

    public NetHelper() {

    }

    @Override
    public void getData(int i) {


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
