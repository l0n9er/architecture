package com.basic2.http;

/**
 * Created by Basic on 2017/9/30.
 */

public interface Call<T> extends retrofit2.Call<T>{
    void enqueue(JsonCallback<T> callback);
}
