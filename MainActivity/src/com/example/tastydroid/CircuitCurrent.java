package com.example.tastydroid;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class CircuitCurrent extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.circuit_current);
		Button btn = (Button) findViewById(R.id.btn_scan);
		btn.setOnClickListener(new View.OnClickListener() {

			/* Method called on click */
			public void onClick(View view) {
				/*Intent launchTutorial;							
				launchTutorial = new Intent(getBaseContext(), Scan.class);
				startActivity(launchTutorial);*/
				IntentIntegrator integrator = new IntentIntegrator(CircuitCurrent.this);  
		        integrator.initiateScan(); 
			
			}
		});
	}
	
	
public void onActivityResult(int requestCode, int resultCode, Intent intent) {  
    IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);  
    if (scanResult != null) {  
    	CheckBox checkBox = (CheckBox) findViewById(R.id.cb1);
    	checkBox.setChecked(true); 
        Toast.makeText(getApplicationContext(), "resultCode: " + resultCode + " -> " + scanResult.getContents() + " " + scanResult.getFormatName(), Toast.LENGTH_LONG).show();  
    }  
}  

}