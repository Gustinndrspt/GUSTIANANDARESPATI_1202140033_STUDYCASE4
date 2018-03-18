package com.example.gusti_r7i22ff.gustianandarespati_1202140033_studycase4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //method saat button ditekan
    public void Namamahasiswa(View view) {
        //untuk berpindah ke aktivitas mahasiswa
        Intent h = new Intent(getApplicationContext(), NamaMahasiswa.class);
        startActivity(h);
    }

    //method saat button ditekan
    public void Carigambar(View view) {
        //untuk berpindah ke aktivitas gambar
        Intent r = new Intent(getApplicationContext(), MencariGambar.class);
        startActivity(r);
    }
}
