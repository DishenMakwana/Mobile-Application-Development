package com.company.localnotification;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationManagerCompat;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
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

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void startNotification()
    {
        Intent i = new Intent(this,MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,i,0);
        NotificationChannel channel = new NotificationChannel(CHANNEL_ID,"1"
                , NotificationManager.IMPORTANCE_DEFAULT);
        NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        manager.createNotificationChannel(channel);

        Notification.Builder builder = new Notification.Builder(MainActivity.this,CHANNEL_ID);

        builder.setSmallIcon(R.drawable.ic_add_alert_24)
                .setContentTitle("Title")
                .setContentText("Notification Text")
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);
        NotificationManagerCompat compat = NotificationManagerCompat.from(MainActivity.this);

        compat.notify(1,builder.build());
     }
}