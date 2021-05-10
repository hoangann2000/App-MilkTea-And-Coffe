package com.hoangan.cafe.activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.hoangan.cafe.R;

public class LoadingScreen extends AppCompatActivity {
    private ProgressBar progressBar;
    private TextView txtright;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_screen);
        Anhxa();
    }

    private void Anhxa() {
        progressBar = findViewById(R.id.progressBar);
        txtright = findViewById(R.id.txtright);
        PhanTram phanTram = new PhanTram();
        phanTram.execute();
    }
    class PhanTram extends AsyncTask<Void,Integer,Void>
    {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setMax(100);
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Intent intent = new Intent(getApplicationContext(),Dangnhap.class);
            startActivity(intent);
            finish();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            int i = values[0];
            progressBar.setProgress(i);
            txtright.setText(i+"%");
        }

        @Override
        protected Void doInBackground(Void... voids) {

            for (int i =0;i<=100;i++){
                try {
                    publishProgress(i);
                    Thread.sleep(30);
                }
                catch (Exception ex)
                {
                    Log.e("Loi",ex.toString());
                }
            }
            return null;
        }
    }
}