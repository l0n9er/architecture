package com.basic2.http;

import java.io.IOException;

import retrofit2.*;
import retrofit2.Call;

/*
 * Copyright (C) 2017 meikoz, http://basic2it.cc/
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
public abstract class AysonCall<T> implements Callback<T> {

    public abstract void successful(T response);

    public abstract void onFailure(Exception ex);

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.isSuccessful())
            successful(response.body());
        else {
            onFailure(new HttpErrorException(response.errorBody()));
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        onFailure(new NullPointerException());
    }
}
