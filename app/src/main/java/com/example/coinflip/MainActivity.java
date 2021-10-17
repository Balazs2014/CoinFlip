package com.example.coinflip;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ImageView kepErme;
    private Button gombFej, gombIras;
    private TextView textDobasok, textGyozelem, textVereseg;
    private Random rnd;
    private int dobasokSzama, gyozelemSzama, veresegSzama;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    public void init() {
        kepErme = findViewById(R.id.kepErme);
        gombFej = findViewById(R.id.gombFej);
        gombIras = findViewById(R.id.gombIras);
        textDobasok = findViewById(R.id.textDobasok);
        textGyozelem = findViewById(R.id.textGyozelem);
        textVereseg = findViewById(R.id.textVereseg);
        dobasokSzama = 0;
        gyozelemSzama = 0;
        veresegSzama = 0;
    }
}