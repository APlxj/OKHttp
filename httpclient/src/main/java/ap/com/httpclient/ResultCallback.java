package ap.com.httpclient;

/**
 * 类描述：
 * 创建人：swallow.li
 * 创建时间：
 * Email: swallow.li@kemai.cn
 * 修改备注：
 */
public abstract class ResultCallback<T> {

    /**
     * 请求成功回调
     *
     * @param response
     */
    public abstract void onSuccess(T response);

    /**
     * 请求失败回调
     *
     * @param e
     */
    public abstract void onFailure(Exception e);
}
