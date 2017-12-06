package ap.com.okhttp;

import android.Manifest;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import ap.com.httpclient.BaseEntry;
import ap.com.httpclient.OkHttp;
import ap.com.httpclient.ResultCallback;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tv;
    ImageView iv;
    private DownloadService.DownloadBinder downloadBinder;

    private ServiceConnection connection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            downloadBinder = (DownloadService.DownloadBinder) service;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tv);
        tv.setOnClickListener(this);
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

       /* new Thread(new Runnable() {
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
        }).start();*/


        /*OkHttp.displayImage(iv, "http://h.hiphotos.baidu.com/image/pic/item/279759ee3d6d55fb2d12cf5567224f4a21a4dde9.jpg", R.mipmap.ic_launcher);*/


        Intent intent = new Intent(this, DownloadService.class);
        //保证DownloadService一直在后台运行，
        //绑定服务让MaiinActivity和DownloadService进行通信
        startService(intent);  //启动服务
        bindService(intent, connection, BIND_AUTO_CREATE);//绑定服务
        /**
         *运行时权限处理：我们需要再用到权限的地方，每次都要检查是否APP已经拥有权限
         *下载功能，需要些SD卡的权限，我们在写入之前检查是否有WRITE_EXTERNAL_STORAGE权限,没有则申请权限
         */
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        }
    }

    /**
     * 用户选择允许或拒绝后,
     * 会回调onRequestPermissionsResult
     *
     * @param requestCode  请求码
     * @param permissions
     * @param grantResults 授权结果
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0 && grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "拒绝权限将无法使用程序", Toast.LENGTH_SHORT).show();
                    finish();
                }
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //解除绑定服务
        unbindService(connection);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv:
                String url = "http://h.hiphotos.baidu.com/image/pic/item/279759ee3d6d55fb2d12cf5567224f4a21a4dde9.jpg";
                String url2 = "http://shouji.360tpcdn.com/171201/b89086bc4fbc7233df8523437bad3ed0/com.tencent.mobileqq_758.apk";
//                downloadBinder.startDownload(url);
                downloadBinder.startDownload(url2);
                break;
        }
    }
}
