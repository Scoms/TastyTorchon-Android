package com.example.tastydroid;



import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Toast;

public class Scan extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.circuit_current);
		IntentIntegrator integrator = new IntentIntegrator(Scan.this);  
        integrator.initiateScan(); 
	}
	
	public void onActivityResult(int requestCode, int resultCode, Intent intent) {  
        IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);  
        if (scanResult != null) {  
            Toast.makeText(getApplicationContext(), "resultCode: " + resultCode + " -> " + scanResult.getContents() + " " + scanResult.getFormatName(), Toast.LENGTH_LONG).show();  
        }  
    }  
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
