package com.example.semaforo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnComenzar;
    ImageView ivSemaforo, ivSemaforo2, ivSemaforo3, ivSemaforo4, ivSemaforo5, ivSemaforo6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnComenzar = findViewById(R.id.btnComenzar);

        ivSemaforo = findViewById(R.id.ivSemaforo);
        ivSemaforo2 = findViewById(R.id.ivSemaforo2);
        ivSemaforo3 = findViewById(R.id.ivSemaforo3);

        ivSemaforo4 = findViewById(R.id.ivSemaforo4);
        ivSemaforo5 = findViewById(R.id.ivSemaforo5);
        ivSemaforo6 = findViewById(R.id.ivSemaforo6);

        btnComenzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {

                        for (int i = 0; i < 3; i++) {
                            int estado = i % 3;

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    switch (estado) {
                                        case 0:
                                            ivSemaforo.setImageResource(R.drawable.circulo_rojo);
                                            ivSemaforo2.setImageResource(R.drawable.circulo_gris);
                                            ivSemaforo3.setImageResource(R.drawable.circulo_gris);
                                            break;
                                        case 1:
                                            ivSemaforo.setImageResource(R.drawable.circulo_gris);
                                            ivSemaforo2.setImageResource(R.drawable.circulo_gris);
                                            ivSemaforo3.setImageResource(R.drawable.circulo_verde);
                                            break;
                                        case 2:
                                            ivSemaforo.setImageResource(R.drawable.circulo_gris);
                                            ivSemaforo2.setImageResource(R.drawable.circulo_amarillo);
                                            ivSemaforo3.setImageResource(R.drawable.circulo_gris);
                                            break;
                                        default:
                                            ivSemaforo.setImageResource(R.drawable.circulo_gris);
                                            ivSemaforo2.setImageResource(R.drawable.circulo_gris);
                                            ivSemaforo3.setImageResource(R.drawable.circulo_gris);
                                    }
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

                        for (int i = 0; i < 3; i++) {
                            int estado = i % 3;

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    switch (estado) {
                                        case 0:
                                            ivSemaforo4.setImageResource(R.drawable.circulo_gris);
                                            ivSemaforo5.setImageResource(R.drawable.circulo_gris);
                                            ivSemaforo6.setImageResource(R.drawable.circulo_verde);
                                            break;
                                        case 1:
                                            ivSemaforo4.setImageResource(R.drawable.circulo_gris);
                                            ivSemaforo5.setImageResource(R.drawable.circulo_amarillo);
                                            ivSemaforo6.setImageResource(R.drawable.circulo_gris);
                                            break;
                                        case 2:
                                            ivSemaforo4.setImageResource(R.drawable.circulo_rojo);
                                            ivSemaforo5.setImageResource(R.drawable.circulo_gris);
                                            ivSemaforo6.setImageResource(R.drawable.circulo_gris);
                                            break;
                                        default:
                                            ivSemaforo4.setImageResource(R.drawable.circulo_gris);
                                            ivSemaforo5.setImageResource(R.drawable.circulo_gris);
                                            ivSemaforo6.setImageResource(R.drawable.circulo_gris);
                                    }
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