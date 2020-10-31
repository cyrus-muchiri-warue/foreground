package ke.co.nevon.foreground;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.core.app.NotificationCompat;

import static ke.co.nevon.foreground.App.Channel_id;

public class ExampleService extends Service {
    private static final String TAG = "ExampleService";
    @Override
    public void onCreate() {
        super.onCreate();
    }

    public static final String notificationManager = "notificaton";

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand: "+Thread.currentThread().getId());
        String message = intent.getStringExtra(notificationManager);
        for (int i = 0; i < 1000; i++) {
            Notification notification = new NotificationCompat
                    .Builder(this, Channel_id)
                    .setContentTitle("hello")
                    .setContentText(String.valueOf(i))
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .build();
            startForeground(1, notification);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Intent intent1 = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent1, 0);

        return START_NOT_STICKY;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
