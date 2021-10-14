package com.company.localnotification;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationManagerCompat;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Icon;
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

        Intent actionIntent = new Intent(this,recivers.class);
        actionIntent.putExtra("toast","This is Notification Message");

        PendingIntent actionPending = PendingIntent.getBroadcast(this,0,actionIntent,0);
        Notification.Action action = new Notification.Action.Builder(Icon.createWithResource(this,
                R.drawable.ic_add_alert_24),"Toast Message",actionPending).build();

        Intent dismissIntent = new Intent(this,reciversDismiss.class);
        PendingIntent dismissPending = PendingIntent.getBroadcast(this,0,dismissIntent,0);
        Notification.Action dismissAction = new Notification.Action.Builder(Icon.createWithResource(this,
                R.drawable.ic_add_alert_24),"Dismiss",dismissPending).build();

        NotificationChannel channel = new NotificationChannel(CHANNEL_ID,"1"
                , NotificationManager.IMPORTANCE_DEFAULT);
        NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        manager.createNotificationChannel(channel);

        Bitmap icon = BitmapFactory.decodeResource(getResources(),R.drawable.abc);
      //  String text = getResources().getString(R.string.big_text);

        Notification.Builder builder = new Notification.Builder(MainActivity.this,CHANNEL_ID);

        builder.setSmallIcon(R.drawable.ic_add_alert_24)
                .setContentTitle("Title")
                .setContentText("Notification Text")
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .addAction(action)
                .addAction(dismissAction)
                .setColor(Color.BLUE)
                .setLargeIcon(icon)
                .setStyle(new Notification.BigPictureStyle().bigPicture(icon));


        NotificationManagerCompat compat = NotificationManagerCompat.from(MainActivity.this);

        compat.notify(1,builder.build());
     }
}