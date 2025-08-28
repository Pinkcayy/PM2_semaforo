package com.example.semaforo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnComenzar;
    ImageView ivSemaforo, ivSemaforo2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnComenzar = findViewById(R.id.btnComenzar);
        ivSemaforo = findViewById(R.id.ivSemaforo);
        ivSemaforo2 = findViewById(R.id.ivSemaforo2);

        btnComenzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        int[] ciclo = new int[]{
                                R.drawable.circulo_rojo,
                                R.drawable.circulo_amarillo,
                                R.drawable.circulo_verde
                        };

                        for (int i = 0; i < 3; i++) {
                            int res = ciclo[i % ciclo.length];

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    ivSemaforo.setImageResource(res);
                                }
                            });

                            try {
                                Thread.sleep(5000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
                thread.start();

                Thread thread2 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        int[] ciclo = new int[]{
                                R.drawable.circulo_verde,
                                R.drawable.circulo_amarillo,
                                R.drawable.circulo_rojo
                        };

                        for (int i = 0; i < 3; i++) {
                            int res = ciclo[i % ciclo.length];

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    ivSemaforo2.setImageResource(res);
                                }
                            });

                            try {
                                Thread.sleep(5000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
                thread2.start();
            }
        });
    }
}