package basic2it.architecture;

import com.basic2.http.HttpProxyImpl;
import com.basic2.http.Request;

import okhttp3.OkHttpClient;

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
public class ApiFactory {

    private static Request request;

    public static Api.AccountServices account() {
        return servs(Api.AccountServices.class);
    }

    private static <T> T servs(Class<T> clzz) {
        if (request == null)
            request = new Request.Builder()
                    .client(okhttp())
                    .build();
        return HttpProxyImpl.getInstance().newRequestQueue(clzz, request);
    }

    static OkHttpClient okhttp() {
        return new OkHttpClient.Builder()
                .build();
    }
}
