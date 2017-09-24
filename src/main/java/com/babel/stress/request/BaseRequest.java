package com.babel.stress.request;

import com.babel.stress.util.PoolingHttpClientManager;

/**
 * Created by Rayee on 2017/9/24.
 */
public abstract class BaseRequest {

    protected static PoolingHttpClientManager httpClientPool = new PoolingHttpClientManager(10, 3000, 3000);

}
