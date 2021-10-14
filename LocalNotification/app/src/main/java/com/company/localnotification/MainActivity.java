package com.company.localnotification;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationManagerCompat;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button;
    public final String CHANNEL_ID= "1";
    int counter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter++;
                button.setText(""+ counter);
                if(counter == 5)
                {
                    startNotification();
                }

            }
        });
    }

    public void startNotification()
    {
        NotificationChannel channel = new NotificationChannel(CHANNEL_ID,"1"
                , NotificationManager.IMPORTANCE_DEFAULT);//in built class (there three parameters )
        NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        //This line of code reaches the system of services and from there to notification services.
        manager.createNotificationChannel(channel);// I've created the very first notification.

        Notification.Builder builder = new Notification.Builder(MainActivity.this,CHANNEL_ID);
        //The second is a channel ID.So here, I'll write channel Id, which is a fixed value.

        builder.setSmallIcon(R.drawable.ic_add_alert_24)//choose the icon
                .setContentTitle("Title")//title
                .setContentText("Notification Text")
                .setPriority(Notification.PRIORITY_DEFAULT);
        NotificationManagerCompat compat = NotificationManagerCompat.from(MainActivity.this);
        // I can create an object from the notification manager combat class to show the notification

        compat.notify(1,builder.build());
     }
}