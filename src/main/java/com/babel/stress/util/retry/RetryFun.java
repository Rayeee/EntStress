package com.babel.stress.util.retry;

import com.babel.stress.exception.ServiceException;

/**
 * Created by Rayee on 2017/9/21.
 */
@FunctionalInterface
public interface RetryFun<T> {

    T execute() throws ServiceException;

}
