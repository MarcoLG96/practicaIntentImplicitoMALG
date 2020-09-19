package com.example.practicaintentimplicitomalg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Calendar;
import java.util.List;

import static java.net.Proxy.Type.HTTP;

public class MainActivity extends AppCompatActivity {

    Button btnllama, btnmapa, btnweb, btncorreo, btncalendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnllama = (Button) findViewById(R.id.llamada);
        btnmapa = (Button) findViewById(R.id.mapa);
        btnweb = (Button) findViewById(R.id.paginaweb);
        btncorreo = (Button) findViewById(R.id.correo);
        btncalendar = (Button) findViewById((R.id.calendario));

        btnllama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "LLamada", Toast.LENGTH_LONG).show();
                Uri numero = Uri.parse("tel:4451033630");
                Intent callintent = new Intent(Intent.ACTION_DIAL, numero);

                PackageManager packageManager = getPackageManager();
                List<ResolveInfo> activities = packageManager.queryIntentActivities(callintent, 0);
                boolean isIntentSafe = activities.size() > 0;

                if (isIntentSafe) {
                    startActivity(callintent);
                }

                String title = getResources().getString(R.string.app_name);
// Create intent to show chooser
                Intent chooser = Intent.createChooser(callintent, title);

// Verify the intent will resolve to at least one activity
                if (callintent.resolveActivity(getPackageManager()) != null) {
                    startActivity(chooser);
                }
            }

        });

        btnmapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "mapa", Toast.LENGTH_LONG).show();
                Uri location = Uri.parse("geo:0,0?q=1600+Amphitheatre+Parkway,+Mountain+View,+California");
                Intent mapintent = new Intent(Intent.ACTION_VIEW, location);

                PackageManager packageManager = getPackageManager();
                List<ResolveInfo> activities = packageManager.queryIntentActivities(mapintent, 0);
                boolean isIntentSafe = activities.size() > 0;

                if (isIntentSafe)
                {
                    startActivity(mapintent);
                }

                String title = getResources().getString(R.string.app_name);
// Create intent to show chooser
                Intent chooser = Intent.createChooser(mapintent, title);

// Verify the intent will resolve to at least one activity
                if (mapintent.resolveActivity(getPackageManager()) != null)
                {
                    startActivity(chooser);

                }
            }

            ;;


        });

        btncorreo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setType("Text/Plain");
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {"marco@example.com"}); // recipients
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Email practica ");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message text");
                emailIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse("content://path/to/email/attachment"));

                PackageManager packageManager = getPackageManager();
                List<ResolveInfo> activities = packageManager.queryIntentActivities(emailIntent, 0);
                boolean isIntentSafe = activities.size() > 0;

                if (isIntentSafe) {
                    startActivity(emailIntent);
            }

                String title = getResources().getString(R.string.app_name);

                Intent chooser = Intent.createChooser(emailIntent, title);


                if (emailIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(chooser);
                }
        }
    });

        btnweb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri webpage = Uri.parse("https://www.android.com");
                Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
                PackageManager packageManager = getPackageManager();
                List<ResolveInfo> activities = packageManager.queryIntentActivities(webIntent, 0);
                boolean isIntentSafe = activities.size() > 0;

// Start an activity if it's safe
                if (isIntentSafe) {
                    startActivity(webIntent);
                }

                String title = getResources().getString(R.string.app_name);
// Create intent to show chooser
                Intent chooser = Intent.createChooser(webIntent, title);

// Verify the intent will resolve to at least one activity
                if (webIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(chooser);
                }
            }
        });

        btncalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent calendarIntent = new Intent(Intent.ACTION_INSERT, CalendarContract.Events.CONTENT_URI);
                Calendar beginTime = Calendar.getInstance();
                beginTime.set(2020, 7, 19, 7, 30);
                Calendar endTime = Calendar.getInstance();
                endTime.set(2020, 7, 19, 10, 30);
                calendarIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginTime.getTimeInMillis());
                calendarIntent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime.getTimeInMillis());
                calendarIntent.putExtra(CalendarContract.Events.TITLE, "Ninja class");
                calendarIntent.putExtra(CalendarContract.Events.EVENT_LOCATION, "Secret dojo");

                PackageManager packageManager = getPackageManager();
                List<ResolveInfo> activities = packageManager.queryIntentActivities(calendarIntent, 0);
                boolean isIntentSafe = activities.size() > 0;

                if (isIntentSafe) {
                    startActivity(calendarIntent);
                }

                String title = getResources().getString(R.string.app_name);
                Intent chooser = Intent.createChooser(calendarIntent, title);

                if (calendarIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(chooser);
                }


            }
        });
};
}



