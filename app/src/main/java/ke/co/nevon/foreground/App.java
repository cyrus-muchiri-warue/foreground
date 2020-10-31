package ke.co.nevon.foreground;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class App extends Application {
    public static final String Channel_id="service channel";
    public static final String notificationManager="notificaton";
    @Override
    public void onCreate() {
        super.onCreate();
        notification_channel();

    }

    private void notification_channel() {
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O)
        {
            NotificationChannel channel=new NotificationChannel(
                    Channel_id,
                    "service channel",
                    NotificationManager.IMPORTANCE_DEFAULT
            );
          NotificationManager manager=getSystemService(NotificationManager.class);
          manager.createNotificationChannel(channel);
        }
    }
}
