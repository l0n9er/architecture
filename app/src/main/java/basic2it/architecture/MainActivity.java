package basic2it.architecture;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.basic2.componts.ux.ImageText;

import com.basic2.http.JsonCallback;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageText imageText = (ImageText) findViewById(R.id.image_text);

        ApiFactory.account().login().enqueue(new JsonCallback<String>() {

            @Override
            public void successful(String response) {

            }

            @Override
            public void onFailure(Exception ex) {

            }
        });

    }
}
