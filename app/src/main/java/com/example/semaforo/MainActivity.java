package com.example.semaforo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnComenzar;
    ImageView ivSemaforo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnComenzar = findViewById(R.id.btnComenzar);
        ivSemaforo = findViewById(R.id.ivSemaforo);

        btnComenzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    ivSemaforo.setImageResource(R.drawable.circulo_rojo);
                                }
                            });
                        try {
                            Thread.sleep(5000);
                        }
                        catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });

                Thread thread2 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(5000);
                        }
                        catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                ivSemaforo.setImageResource(R.drawable.circulo_gris);
                            }
                        });
                        try {
                            Thread.sleep(5000);
                        }
                        catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
                thread.start();
                thread2.start();
            }
        });
    }
}