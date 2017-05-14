package com.example.lenovo.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText edtTinggi, edtBerat;
    private Button btnHitung, btnClear;
    private TextView txtHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        edtTinggi = (EditText) findViewById(R.id.edt_tinggi);
        edtBerat = (EditText) findViewById(R.id.edt_berat);
        btnHitung = (Button) findViewById(R.id.btn_hitung);
        txtHasil = (TextView) findViewById(R.id.txt_hasil);
        btnClear = (Button) findViewById(R.id.btn_clear);

        btnClear.setOnClickListener(new View.OnClickListener() {
                                        public void onClick(View v) {

                                            edtTinggi.setText("");
                                            edtBerat.setText("");
                                            txtHasil.setText("Hasil");
                                        }
                                    });

        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtTinggi.length() == 0 && edtBerat.length() ==0 ) {
                    Toast.makeText(getApplication(),"Berat dan Tinggi Tidak Boleh Kosong ",Toast.LENGTH_SHORT).show();
                }
                else if (edtTinggi.length() == 0){
                    Toast.makeText(getApplication(),"Timggi Tidak Boleh Kosong ",Toast.LENGTH_SHORT).show();
                }

                else if (edtBerat.length() ==0 ){
                    Toast.makeText(getApplication(),"Berat Tidak Boleh Kosong ",Toast.LENGTH_SHORT).show();
                }



                else {
                    String Tinggi = edtTinggi.getText().toString();
                    String Berat = edtBerat.getText().toString();

                    double t = Double.parseDouble(Tinggi);
                    double b = Double.parseDouble(Berat);

                    double hs = hasilbb(t, b);


                    if (hs < 0.0018) txtHasil.setText("Hasil: UnderWeight/Kurus, sebaiknya mulai mengkonsumsi makanan yang bergizi terutama karbohidrat dan jaga pola makan");
                    if (0.0018 < hs && hs < 0.0025) txtHasil.setText("Hasil: NormalWeight, berat badan tubuh anda termasuk ideal tetap jaga pola makan dan banyak berolahraga");
                    if (0.0025 < hs && hs < 0.0027) txtHasil.setText("Hasil: OverWeight/Kegemukan, anda sebaiknya mulai melakukan program diet dan olahraga secara teratur");
                    if (hs > 0.0027) txtHasil.setText("Hasil: Obesitas, Lakukan program diet dan konsultasikan dengan dokter");


                }
            }
        });
    }
    public double hasilbb(double t, double b){
        return  b/(t*t);

    }
}