package ap.com.httpclient;

/**
 * 类描述：
 * 创建人：swallow.li
 * 创建时间：
 * Email: swallow.li@kemai.cn
 * 修改备注：
 */
public interface ICallBack {

    /**
     * 发送失败的回调
     *
     * @param callback
     * @param e
     */
    void sendFailCallback(final ResultCallback callback, final Exception e);

    /**
     * 发送成功的调
     *
     * @param callback
     * @param obj
     */
    void sendSuccessCallBack(final ResultCallback callback, final Object obj);
}
