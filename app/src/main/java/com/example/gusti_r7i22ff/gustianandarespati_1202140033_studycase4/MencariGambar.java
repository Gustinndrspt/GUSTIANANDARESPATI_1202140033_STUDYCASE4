package com.example.gusti_r7i22ff.gustianandarespati_1202140033_studycase4;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.URL;

/**
 * Created by gusti_r7i22ff on 18/03/2018.
 */

public class MencariGambar extends AppCompatActivity{

    //deklarasi komponen variabel
    private EditText mURLgambar;
    private ImageView mGambar;
    private Button mButtonLoad;
    private ProgressDialog mLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mencari_gambar);// akan tergabung ke layout mana


        //Mendefinisikan gambar dan edittext pada layout activity mencari gambar
        mURLgambar = findViewById(R.id.URL);
        mGambar = findViewById(R.id.Gambar);
        mButtonLoad = findViewById(R.id.button3);
    }


    public void Search(View view) {
        loadImagetInit();
    }

    private void loadImagetInit() {
        String ImgUrl = mURLgambar.getText().toString();
        //AsyncTask mencari gambar di internet
        new loadImage().execute(ImgUrl);
    }

    private class loadImage extends AsyncTask<String, Void, Bitmap> {
        //method ketika proses asynctask belum dimulai
        @Override
        protected void onPreExecute() { //awal dari pengerjaan dalam menampilkan loading
            super.onPreExecute();

            // Membuat Progress Dialog
            mLoading = new ProgressDialog(MencariGambar.this);

            // Judul Progress Dialog
            mLoading.setTitle("Sedang Mencari Image");

            // Seting message Progress Dialog
            mLoading.setMessage("Loading...");

            // menampilkan Progress Dialog
            mLoading.show();
        }
        //method saat proses asynctask dijalankan
        @Override
        protected Bitmap doInBackground(String... params) { //apa yang sedang terjadi ketika dijalankan memasukkan data ke list view
            Bitmap x = null;
            try {
                //download gambar dr url
                URL f = new URL(params[0]);
                //mengkonversi gambar ke bitmap (decode to bitmap)

                x = BitmapFactory.decodeStream((InputStream) f.getContent());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return x;
        }

        //method sesudah asynctask sudah dijalankan
        @Override
        protected void onPostExecute(Bitmap x) { // akhir dari pengerjaan ketika di klik lg button maka akan menampilkan gambar yang telah dicari
            super.onPostExecute(x);
            //menampung gambar ke imageview dan menampilkan
            mGambar.setImageBitmap(x);
            //menghilangkan progress dialog
            mLoading.dismiss();
        }
    }
}


