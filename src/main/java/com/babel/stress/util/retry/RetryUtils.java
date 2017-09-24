package com.babel.stress.util.retry;


import com.babel.stress.exception.ServiceException;
import com.babel.stress.exception.SystemException;

/**
 * Created by Rayee on 2017/9/21.
 */
public class RetryUtils {

    public static <T> T retry(RetryFun<T> fun, int count) throws ServiceException {
        int i = 1;
        do {
            try {
                return fun.execute();
            } catch (Exception e) {
                if (e instanceof ServiceException) {
                    throw e;
                } else {
                    if (i >= count) {
                        throw e;
                    }
                }
            }
        } while (i++ < count);
        throw new SystemException("500", "重试结束，系统异常");
    }

}
