package com.icsc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tenPdfview, tenPdflink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tenPdfview=(TextView)findViewById(R.id.tenPdfname);
        tenPdflink=(TextView)findViewById(R.id.tenpdf);
        String pdfnamee = getIntent().getStringExtra("pdfn");
        String pdfpp = getIntent().getStringExtra("url");
        tenPdfview.setText(pdfnamee);
        tenPdfview.setText(pdfpp);
    }
}