package basic2it.architecture;

import com.basic2.http.Call;

import retrofit2.http.GET;

/**
 * Created by Basic on 2017/9/30.
 */

public interface Api {
    interface AccountServices {
        @GET("api/account/login")
        Call<String> login();
    }
}
