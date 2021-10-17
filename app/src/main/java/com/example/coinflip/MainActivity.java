package com.example.coinflip;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ImageView kepErme;
    private Button gombFej, gombIras;
    private TextView textDobasok, textGyozelem, textVereseg;
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
            }
        });

        gombIras.setOnClickListener((view) -> {
            if (dobasokSzama != 5) {
                jatekosTipp = "iras";
                kiir(eredmeny(jatekosTipp, fejVagyIras()));
            }
        });
    }

    public String fejVagyIras() {
        dobasokSzama++;
        double random = Math.floor(Math.random() * 2);

        if (random == 1) {
            kepErme.setImageResource(R.drawable.heads);
            gepTipp = "fej";
            Toast.makeText(MainActivity.this, "Fej", Toast.LENGTH_SHORT).show();
        } else {
            kepErme.setImageResource(R.drawable.tails);
            gepTipp = "iras";
            Toast.makeText(MainActivity.this, "Írás", Toast.LENGTH_SHORT).show();
        }

        if (dobasokSzama == 5) {
            jatekVege();
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

        if (gyozelemSzama == 3 || veresegSzama == 3) {
            jatekVege();
        }
    }

    public void jatekVege() {
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
        alertBuilder.setCancelable(false);
        if (gyozelemSzama >= 3) {
            alertBuilder.setTitle("Győzelem");
        } else {
            alertBuilder.setTitle("Vereség");
        }
        alertBuilder.setMessage("Szeretnél új játékot játszani?");
        alertBuilder.setPositiveButton("Igen", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ujJatek();
            }
        });

        alertBuilder.setNegativeButton("Nem", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        alertBuilder.create().show();
    }

    public void ujJatek() {
        dobasokSzama = 0;
        gyozelemSzama = 0;
        veresegSzama = 0;
        textDobasok.setText("Dobások: 0");
        textGyozelem.setText("Győzelem: 0");
        textVereseg.setText("Vereség: 0");
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