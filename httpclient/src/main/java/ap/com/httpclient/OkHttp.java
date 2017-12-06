package ap.com.httpclient;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;

import com.alibaba.fastjson.JSON;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.MultipartBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.FileNameMap;
import java.net.URLConnection;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 类描述：OkHttp工具类
 * 创建人：swallow.li
 * 创建时间：
 * Email: swallow.li@kemai.cn
 * 修改备注：
 */
public class OkHttp implements ICallBack {

    //_get() _post()：同步

    private static OkHttp mInstance;
    private static OkHttpClient mOkHttpClient;
    private Handler mHandler;//主线程的handler
    protected static final String VERSION = "1.0.1";//版本
    private static final long ConnectTimeout = 10;//设置连接的超时时间
    private static final long WriteTimeout = 10;//设置响应的超时时间
    private static final long ReadTimeout = 30;//请求的超时时间

    private OkHttp() {
        /**
         * 构建OkHttpClient
         */
        mOkHttpClient = new OkHttpClient();
        mOkHttpClient.setConnectTimeout(ConnectTimeout, TimeUnit.SECONDS);
        mOkHttpClient.setWriteTimeout(WriteTimeout, TimeUnit.SECONDS);
        mOkHttpClient.setReadTimeout(ReadTimeout, TimeUnit.SECONDS);
        //允许使用Cookie
        mOkHttpClient.setCookieHandler(new CookieManager(null, CookiePolicy.ACCEPT_ORIGINAL_SERVER));
        mHandler = new Handler(Looper.getMainLooper());
    }

    /**
     * 通过单例模式构造对象
     *
     * @return OkHttpUtils
     */
    private synchronized static OkHttp getmInstance() {
        if (mInstance == null) {
            synchronized (VERSION) {
                if (mInstance == null)
                    mInstance = new OkHttp();
            }
        }
        return mInstance;
    }

    /**
     * 构造Get请求
     *
     * @param url      请求的url
     * @param callback 结果回调的方法
     */
    private void _getRequest(String url, final ResultCallback callback, Class<?> aClass) {
        final Request request = new Request
                .Builder()
                .url(url)
                .build();
        _deliveryResult(callback, request, aClass);
    }

    private Response _getRequest(String url) {
        final Request request = new Request
                .Builder()
                .url(url)
                .build();
        return _deliveryResult(request);
    }

    /**
     * 构造post 请求
     *
     * @param url      请求的url
     * @param callback 结果回调的方法
     * @param map      请求参数
     */
    private void _postRequest(String url, final ResultCallback callback, Map<String, String> map, Class<?> aClass) {
        Request request = _buildPostRequest(url, map);
        _deliveryResult(callback, request, aClass);
    }

    private Response _postRequest(String url, Map<String, String> map) {
        Request request = _buildPostRequest(url, map);
        return _deliveryResult(request);
    }

    /**
     * 构造post请求
     *
     * @param url 请求url
     * @param map 请求的参数
     * @return 返回 Request
     */
    private Request _buildPostRequest(String url, Map<String, String> map) {
        if (null == map) return new Request.Builder().url(url).build();
        FormEncodingBuilder builder = new FormEncodingBuilder();
        for (String key : map.keySet()) {
            builder.add(key, map.get(key));
        }
        RequestBody requestBody = builder.build();
        return new Request.Builder().url(url).post(requestBody).build();
    }

    /**
     * 返回数据处理
     *
     * @param callback
     * @param request
     */
    private void _deliveryResult(final ResultCallback callback, Request request, final Class<?> aClass) {

        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, final IOException e) {
                sendFailCallback(callback, e);
            }

            @Override
            public void onResponse(Response response) throws IOException {
                try {
                    String str = response.body().string();
                    if (null == aClass) {
                        sendSuccessCallBack(callback, str);
                    } else {
                        Object object = JSON.parseObject(str, aClass);
                        sendSuccessCallBack(callback, object);
                    }
                } catch (final Exception e) {
                    sendFailCallback(callback, e);
                }

            }
        });
    }

    private Response _deliveryResult(Request request) {
        Response response = null;
        try {
            response = mOkHttpClient.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    private static Request _buildMultipartFormRequest(String url, File[] files, String[] fileKeys, Map<String, String> params) {


        MultipartBuilder builder = new MultipartBuilder()
                .type(MultipartBuilder.FORM);
        if (null != params)
            for (String key : params.keySet()) {
                builder.addPart(Headers.of("Content-Disposition", "form-data; name=\"" + key + "\""),
                        RequestBody.create(null, params.get(key)));
            }
        if (files != null) {
            RequestBody fileBody = null;
            for (int i = 0; i < files.length; i++) {
                File file = files[i];
                String fileName = file.getName();
                fileBody = RequestBody.create(MediaType.parse(_guessMimeType(fileName)), file);
                //TODO 根据文件名设置contentType
                builder.addPart(Headers.of("Content-Disposition",
                        "form-data; name=\"" + fileKeys[i] + "\"; filename=\"" + fileName + "\""),
                        fileBody);
            }
        }

        RequestBody requestBody = builder.build();
        return new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
    }

    private static String _guessMimeType(String path) {
        FileNameMap fileNameMap = URLConnection.getFileNameMap();
        String contentTypeFor = fileNameMap.getContentTypeFor(path);
        if (contentTypeFor == null) {
            contentTypeFor = "application/octet-stream";
        }
        return contentTypeFor;
    }

    /**
     * 异步下载文件
     *
     * @param url
     * @param destFileDir 本地文件存储的文件夹
     * @param callback
     */
    private void _download(final String url, final String destFileDir, final ResultCallback callback) {
        final Request request = new Request.Builder()
                .url(url)
                .build();
        final Call call = mOkHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(final Request request, final IOException e) {
                sendFailCallback(callback, e);
            }

            @Override
            public void onResponse(Response response) {
                InputStream is = null;
                byte[] buf = new byte[2048];
                int len = 0;
                FileOutputStream fos = null;
                try {
                    is = response.body().byteStream();
                    File file = new File(destFileDir, _getFileName(url));
                    fos = new FileOutputStream(file);
                    while ((len = is.read(buf)) != -1) {
                        fos.write(buf, 0, len);
                    }
                    fos.flush();
                    //如果下载文件成功，第一个参数为文件的绝对路径
                    sendSuccessCallBack(callback, file.getAbsolutePath());
                } catch (IOException e) {
                    sendFailCallback(callback, e);
                } finally {
                    try {
                        if (is != null) is.close();
                    } catch (IOException e) {
                    }
                    try {
                        if (fos != null) fos.close();
                    } catch (IOException e) {
                    }
                }

            }
        });
    }

    private String _getFileName(String path) {
        int separatorIndex = path.lastIndexOf("/");
        return (separatorIndex < 0) ? path : path.substring(separatorIndex + 1, path.length());
    }

    /**
     * 加载图片
     *
     * @param view
     * @param url
     * @throws IOException
     */
    private void _displayImage(final ImageView view, final String url, final int errorResId) {
        final Request request = new Request.Builder()
                .url(url)
                .build();
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                _setErrorResId(view, errorResId);
            }

            @Override
            public void onResponse(Response response) {
                InputStream is = null;
                try {
                    is = response.body().byteStream();
                    ImageUtils.ImageSize actualImageSize = ImageUtils.getImageSize(is);
                    ImageUtils.ImageSize imageViewSize = ImageUtils.getImageViewSize(view);
                    int inSampleSize = ImageUtils.calculateInSampleSize(actualImageSize, imageViewSize);
                    try {
                        is.reset();
                    } catch (IOException e) {
                        response = get(url);
                        is = response.body().byteStream();
                    }

                    BitmapFactory.Options ops = new BitmapFactory.Options();
                    ops.inJustDecodeBounds = false;
                    ops.inSampleSize = inSampleSize;
                    final Bitmap bm = BitmapFactory.decodeStream(is, null, ops);
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            view.setImageBitmap(bm);
                        }
                    });
                } catch (Exception e) {
                    _setErrorResId(view, errorResId);

                } finally {
                    if (is != null) try {
                        is.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });


    }

    private void _setErrorResId(final ImageView view, final int errorResId) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                view.setImageResource(errorResId);
            }
        });
    }

    @Override
    public void sendFailCallback(final ResultCallback callback, final Exception e) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                if (callback != null) {
                    callback.onFailure(e);
                }
            }
        });
    }

    @Override
    public void sendSuccessCallBack(final ResultCallback callback, final Object obj) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                if (callback != null) {
                    callback.onSuccess(obj);
                }
            }
        });
    }


    //************************ 对外接口************************/

    /**
     * 同步
     */
    //get✔
    public static Response get(String url) {
        return getmInstance()._getRequest(url);
    }

    //post✔
    public static Response post(String url, Map<String, String> map) {
        return getmInstance()._postRequest(url, map);
    }

    //上传文件
    public static Response post(String url, File file, String fileKey) throws IOException {
        return post(url, new File[]{file}, new String[]{fileKey}, null);
    }

    //上传文件
    public static Response post(String url, File file, String fileKey, Map<String, String> params) throws IOException {
        return post(url, new File[]{file}, new String[]{fileKey}, params);
    }

    //上传文件
    public static Response post(String url, File[] files, String[] fileKeys, Map<String, String> params) throws IOException {
        Request request = _buildMultipartFormRequest(url, files, fileKeys, params);
        return mOkHttpClient.newCall(request).execute();
    }

    /**
     * 异步
     */
    //✔
    public static void get(String url, ResultCallback callback) {
        get(url, callback, null);
    }

    //✔
    public static void post(String url, final ResultCallback callback, Map<String, String> map) {
        post(url, callback, map, null);
    }

    //✔
    public static void get(String url, ResultCallback callback, Class<?> aClass) {
        getmInstance()._getRequest(url, callback, aClass);
    }

    //✔
    public static void post(String url, final ResultCallback callback, Map<String, String> map, Class<?> aClass) {
        getmInstance()._postRequest(url, callback, map, aClass);
    }


    public static void post(String url, ResultCallback callback, File file, String fileKey, Map<String, String> params) throws IOException {
        post(url, callback, new File[]{file}, new String[]{fileKey}, params, null);
    }

    public static void post(String url, ResultCallback callback, File file, String fileKey, Class<?> aClass) throws IOException {
        post(url, callback, new File[]{file}, new String[]{fileKey}, null, aClass);
    }

    public static void post(String url, ResultCallback callback, File[] files, String[] fileKeys, Map<String, String> params, Class<?> aClass) throws IOException {
        Request request = _buildMultipartFormRequest(url, files, fileKeys, params);
        getmInstance()._deliveryResult(callback, request, aClass);
    }

    public static void downloadFile(final String url, final String destFileDir, final ResultCallback callback) {
        getmInstance()._download(url, destFileDir, callback);
    }

    //✔
    public static void displayImage(final ImageView view, final String url, final int errorResId) {
        getmInstance()._displayImage(view, url, errorResId);
    }
}

