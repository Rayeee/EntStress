package com.babel.stress.request;

import com.babel.stress.exception.ServiceException;
import com.babel.stress.util.retry.RetryUtils;
import com.xiaoleilu.hutool.http.HttpUtil;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.LongAdder;

/**
 * Created by Rayee on 2017/9/24.
 */
@Service
public class Request {

    public static LongAdder longAdder = new LongAdder();

    private static String url = "http://www.zlano.com:8090/ent/webapi/split/ltp?sentence=%E5%A4%A7%E5%9E%8B%E6%B4%BB%E5%8A%A8";

    public void doSend() {
        for (int i = 0; i <= 5; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                sendRequest();
            }).start();
        }
    }

    private void sendRequest() {
        for (; ; ) {
            try {
                long start = System.currentTimeMillis();
                String result = RetryUtils.retry(() -> HttpUtil.get(url), 3);
                longAdder.increment();
//                System.out.println(String.format("单次请求耗时：%d ms", System.currentTimeMillis() - start));
//                System.out.println(longAdder.intValue());
//                System.out.println("result = " + result);
            } catch (ServiceException e) {
                e.printStackTrace();
            }
        }
    }

}
