package ke.co.nevon.foreground;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button start,stop;
    EditText string;
    Intent intent;
    public static final String notificationManager="notificaton";
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start=findViewById(R.id.start);
        stop=findViewById(R.id.stop);
        string=findViewById(R.id.string);

        Log.d(TAG, "onCreate: "+Thread.currentThread().getId());
    }

    @Override
    protected void onResume() {
        super.onResume();
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start_service();
            }
        });


        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stop_service();
            }
        });
    }

    private void stop_service() {
        Intent intent=new Intent(this,ExampleService.class);
        stopService(intent);

    }

    private void start_service() {
        String messsage=string.getText().toString();

        Intent intent=new Intent(this,ExampleService.class);
        intent.putExtra(notificationManager,messsage);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            startService(intent);
        }

    }


}
