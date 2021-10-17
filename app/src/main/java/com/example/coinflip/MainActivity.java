package com.example.coinflip;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
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
    private String gepTipp, jatekosTipp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        gombFej.setOnClickListener((view) -> {
            if (dobasokSzama != 5) {
                jatekosTipp = "fej";
                kiir(eredmeny(jatekosTipp, fejVagyIras()));
                dobasokSzama++;
            }
        });

        gombIras.setOnClickListener((view) -> {
            if (dobasokSzama != 5) {
                jatekosTipp = "iras";
                kiir(eredmeny(jatekosTipp, fejVagyIras()));
                dobasokSzama++;
            }
        });
    }

    public String fejVagyIras() {
        boolean random = rnd.nextBoolean();

        if (random) {
            kepErme.setImageResource(R.drawable.heads);
            gepTipp = "fej";
        } else {
            kepErme.setImageResource(R.drawable.tails);
            gepTipp = "iras";
        }

        return gepTipp;
    }

    public boolean eredmeny(String jatekosTipp, String gepTipp) {
        boolean gyozelem;

        if (jatekosTipp.equals(gepTipp)) {
            gyozelem = true;
        } else {
            gyozelem = false;
        }

        return gyozelem;
    }

    public void kiir(boolean gyozelem) {
        if (gyozelem) {
            gyozelemSzama++;
        } else {
            veresegSzama++;
        }
        textDobasok.setText("Dobások: " + dobasokSzama);
        textGyozelem.setText("Győzelem: " + gyozelemSzama);
        textVereseg.setText("Vereség: " + veresegSzama);
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