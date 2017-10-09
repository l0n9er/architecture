package basic2it.architecture;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.basic2.componts.ux.ImageText;

import com.basic2.http.AysonCall;

import java.util.HashMap;
import java.util.Map;

import basic2it.architecture.http.ApiFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageText imageText = (ImageText) findViewById(R.id.image_text);

        Map<String, String> params = new HashMap<>();
        params.put("mobile", "17710928693");
        params.put("pwd", "111111");
        ApiFactory.account().login(params).enqueue(new AysonCall<String>() {

            @Override
            public void successful(String response) {

            }

            @Override
            public void onFailure(Exception ex) {

            }
        });

    }
}
