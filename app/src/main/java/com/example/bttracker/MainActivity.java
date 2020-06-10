package com.example.bttracker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createNotificationChannel();
    }

    public void goToLogActivity(View view) {
        Intent tolog = new Intent(this, LogActivity.class);
        startActivity(tolog);
    }

    public void goToNormalActivity(View view) {
        Intent toNomrmal = new Intent(this, NomalActivity.class);
        startActivity(toNomrmal);
    }

    public void gotoMechanismActivity(View view) {
        Intent toMechanism = new Intent(this, MechanismActivity.class);
        startActivity(toMechanism);
    }

    public void gotoHandlingActivity(View view) {
        Intent toHandlingActivity = new Intent( this,HandlingActivity.class);
        startActivity(toHandlingActivity);
    }

    public void setReminder(View view) {
        // when user clicks "SET REMINDER" button, a toast message will
        // pop up to let user know that a reminder is set
        Toast.makeText(this, "Reminder set!", Toast.LENGTH_SHORT).show();
        // Create an intent object to start
        // the ReminderBroadcastReceiver class
        Intent intent = new Intent(this, ReminderBroadcastReceiver.class);
        // Create a pending intent so that the intent object above
        // will only fire when alarm triggers
        PendingIntent pd = PendingIntent.getBroadcast(this, 0, intent, 0);
        // create an AlarmManager
        AlarmManager alarmManager=(AlarmManager)getSystemService(ALARM_SERVICE);
        // Repeating interval for the alarmManager is set to 6 second
        // for demonstration purpose
        // In real world application, users may want to get daily reminder
        // In that case, set the interval to 100 * 60 * 60 * 24
        long interval = 1000*6;
        // set up a repeating alarm so that the notification reminder
        // gets fired at the set interval
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,System.currentTimeMillis(), interval, pd);
    }

    public void createNotificationChannel(){
        // First, check SDK version
        // Create notification channel only if SDK version > Android 8
        // CAUTION: It's Oreo's 0, not number 0!!!
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.0){
            String channelID = "BT_Tracker_Channel";
            String channelName = "BTTrackerReminderChannel";
            String channelIDescription = "Channel for BT Tracker reminder";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(channelID, channelName, importance);
            channel.setDescription(channelIDescription);
            // Create a notification manager
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            // Create notification channel
            notificationManager.createNotificationChannel(channel);
        }
    }
}
