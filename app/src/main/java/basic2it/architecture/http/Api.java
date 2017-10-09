package basic2it.architecture.http;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Basic on 2017/9/30.
 */

public interface Api {

    interface AccountServices {
        @POST("api/login")
        Call<String> login(@Body Map map);
    }
}
