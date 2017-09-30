package com.basic2.http;

import java.io.IOException;
import java.nio.charset.Charset;

import okhttp3.Interceptor;
import okhttp3.Response;
import okhttp3.internal.platform.Platform;

import static com.basic2.http.HttpUtil.checkNotNull;

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
public class HttpLogInterceptor implements Interceptor {
    
    private static final Charset UTF8 = Charset.forName("UTF-8");
    private final HttpLogInterceptor.Logger logger;
    private volatile HttpLogInterceptor.Level level;

    public HttpLogInterceptor() {
        this(HttpLogInterceptor.Logger.DEFAULT);
    }

    public HttpLogInterceptor(HttpLogInterceptor.Logger logger) {
        this.level = HttpLogInterceptor.Level.NONE;
        this.logger = logger;
    }

    public HttpLogInterceptor setLevel(HttpLogInterceptor.Level level) {
        checkNotNull(level, "level == null. Use Level.NONE instead.");
        this.level = level;
        return this;
    }

    public HttpLogInterceptor.Level getLevel() {
        return this.level;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        //TODO
        return null;
    }

    public interface Logger {
        HttpLogInterceptor.Logger DEFAULT = new HttpLogInterceptor.Logger() {
            public void log(String message) {
                Platform.get().log(4, message, (Throwable) null);
            }
        };

        void log(String var1);
    }

    public static enum Level {
        NONE,
        BASIC,
        HEADERS,
        BODY;

        private Level() {
        }
    }
}
