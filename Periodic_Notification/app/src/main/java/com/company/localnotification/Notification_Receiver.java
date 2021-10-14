package com.company.localnotification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationManagerCompat;

public class Notification_Receiver extends BroadcastReceiver{
    public final String CHANNEL_ID= "1";


    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationChannel channel = new NotificationChannel(CHANNEL_ID,"1"
                , NotificationManager.IMPORTANCE_DEFAULT);
        NotificationManager manager = (NotificationManager)context.getSystemService(context.NOTIFICATION_SERVICE);
        manager.createNotificationChannel(channel);

        Notification.Builder builder = new Notification.Builder(context,CHANNEL_ID);

        builder.setSmallIcon(R.drawable.ic_add_alert_24)
                .setContentTitle("Title")
                .setContentText("Notification Text")
                .setPriority(Notification.PRIORITY_DEFAULT);
        NotificationManagerCompat compat = NotificationManagerCompat.from(context);

        compat.notify(1,builder.build());
    }
}
