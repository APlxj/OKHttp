package ap.com.okhttp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import ap.com.httpclient.BaseEntry;
import ap.com.httpclient.OkHttp;
import ap.com.httpclient.ResultCallback;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tv);
        iv = (ImageView) findViewById(R.id.iv);
        final long t1 = System.currentTimeMillis();
        /*OkHttp.get("http://www.yingqianpos.com/yunpos/vol/sync/operator/ValidateOper.form?" +
                "OperPw=f6634250652bcb4f" +
                "&HashCode=bed1b1ff9e7d50948941316116a825c3d9f6f9de109feb78bc0fe2c84becf4077fa4e3c08b6295ee" +
                "&OperId=18300070007" +
                "&LoginIP=10.0.4.15" +
                "&VersionCode=R1.4.3", new ResultCallback<BaseEntry>() {
            @Override
            public void onSuccess(BaseEntry entry) {
                long t2 = System.currentTimeMillis();
                *//*tv.setText(t2 - t1 + ":" + response.toString());*//*
                tv.setText(t2 - t1 + ":\n" +
                        "stats:" + entry.getStats() + "\n" +
                        "message:" + entry.getMessage() + "\n" +
                        "totalPage:" + entry.getTotalPage() + "\n" +
                        "main:" + entry.getMain().toString() + "\n" +
                        "list:" + entry.getList().toString() + "\n" +
                        "others:" + entry.getOthers() + "\n" +
                        "totalPageList:" + entry.getTotalPageList());
            }

            @Override
            public void onFailure(Exception e) {

            }
        }, BaseEntry.class);*/

        /*Map<String, String> map = new HashMap<>();
        map.put("OperPw", "f6634250652bcb4f");
        map.put("HashCode", "bed1b1ff9e7d50948941316116a825c3d9f6f9de109feb78bc0fe2c84becf4077fa4e3c08b6295ee");
        map.put("OperId", "18300070007");
        map.put("LoginIP", "10.0.4.15");
        map.put("VersionCode", "R1.4.3");
        OkHttp.post("http://www.yingqianpos.com/yunpos/vol/sync/operator/ValidateOper.form", new ResultCallback() {
            @Override
            public void onSuccess(Object entry) {
                *//*BaseEntry entry = (BaseEntry) response;
                Log.d("sss", response.toString());*//*
                long t2 = System.currentTimeMillis();
                tv.setText(*//*t2 - t1 + ":\n" +
                        "stats:" + entry.getStats() + "\n" +
                        "message:" + entry.getMessage() + "\n" +
                        "totalPage:" + entry.getTotalPage() + "\n" +
                        "main:" + entry.getMain().toString() + "\n" +
                        "list:" + entry.getList().toString() + "\n" +
                        "others:" + entry.getOthers() + "\n" +
                        "totalPageList:" + entry.getTotalPageList()*//*entry.toString());
            }

            @Override
            public void onFailure(Exception e) {

            }
        }, map);*/

        new Thread(new Runnable() {
            @Override
            public void run() {
                Map<String, String> map = new HashMap<>();
                map.put("OperPw", "f6634250652bcb4f");
                map.put("HashCode", "bed1b1ff9e7d50948941316116a825c3d9f6f9de109feb78bc0fe2c84becf4077fa4e3c08b6295ee");
                map.put("OperId", "18300070007");
                map.put("LoginIP", "10.0.4.15");
                map.put("VersionCode", "R1.4.3");
                Response response = OkHttp.post("http://www.yingqianpos.com/yunpos/vol/sync/operator/ValidateOper.form?", map);
                if (response.isSuccessful()) {
                    try {
                        final String str = response.body().string();
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                tv.setText(str);
                            }
                        });
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();


        OkHttp.displayImage(iv, "http://h.hiphotos.baidu.com/image/pic/item/279759ee3d6d55fb2d12cf5567224f4a21a4dde9.jpg", R.mipmap.ic_launcher);

    }
}
