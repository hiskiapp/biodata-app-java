package app.hiskia.biodata;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    @SuppressLint("QueryPermissionsNeeded")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button whatsapp = findViewById(R.id.telp);
        whatsapp.setOnClickListener(view -> {
            String number = "6285777727179"; // use country code with your phone number
            String url = "https://api.whatsapp.com/send?phone=" + number;
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        });

        Button address = findViewById(R.id.address);
        address.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.google.com/maps/@-6.4327468,110.8712238,20.46z"));
            startActivity(intent);
        });

        Button email = findViewById(R.id.email);
        email.setOnClickListener(view -> {
            String subject = "Hai His!";
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:hi@hiskia.app")); // only email apps should handle this
            intent.putExtra(Intent.EXTRA_SUBJECT, subject);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        });
    }
}