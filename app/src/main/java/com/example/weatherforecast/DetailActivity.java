package com.example.weatherforecast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    String currentData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent=getIntent();
        currentData=intent.getStringExtra("data");
        TextView textView=findViewById(R.id.detail_weather);
        textView.setText(currentData);

    }
    private Intent createIntent()
    {
        Intent shareIntent= ShareCompat.IntentBuilder.from(this)
                .setType("text/plain")
                .setText(currentData+"#Forecast")
                .getIntent();
        return  shareIntent;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=new MenuInflater(this);
        menuInflater.inflate(R.menu.detail_menu,menu);
        MenuItem menuItem=menu.findItem(R.id.item_share);
        menuItem.setIntent(createIntent());
        return super.onCreateOptionsMenu(menu);
    }
}
