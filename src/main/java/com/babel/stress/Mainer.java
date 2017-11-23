package com.babel.stress;

import com.babel.stress.request.Request;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Rayee on 2017/9/24.
 */
public class Mainer {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application-config.xml");
        new Thread(() -> {
            long times = 0;
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(String.format("请求TPS:%d", (Request.longAdder.longValue() - times)));
                times = Request.longAdder.longValue();
            }
        }).start();
        Request request = context.getBean(Request.class);
        request.doSend();
    }

}
