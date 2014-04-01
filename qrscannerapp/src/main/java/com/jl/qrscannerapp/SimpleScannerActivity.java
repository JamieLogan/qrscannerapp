package com.jl.qrscannerapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import me.dm7.barcodescanner.zbar.Result;
import me.dm7.barcodescanner.zbar.ZBarScannerView;

/**
 * Created by jaimelogan on 31/03/2014.
 */
public class SimpleScannerActivity extends Activity implements ZBarScannerView.ResultHandler {

    public ZBarScannerView mScannerView;
    public final static String RESQR = "com.jl.qrscannerapp.MESSAGE";

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
        mScannerView = new ZBarScannerView(this);    // Programmatically initialize the scanner view
        setContentView(mScannerView);                // Set the scanner view as the content view



    }

    @Override
    public void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this); // Register ourselves as a handler for scan results.
        mScannerView.startCamera();          // Start camera on resume
    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();           // Stop camera on pause
    }

    @Override
    public void handleResult(Result rawResult) {
        // Do something with the result here
        Intent intent = new Intent(this, MainActivity.class);
        String res = rawResult.getContents();
        intent.putExtra(RESQR, res);
        startActivity(intent);


    }

}
