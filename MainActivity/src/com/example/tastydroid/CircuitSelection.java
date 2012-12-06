package com.example.tastydroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CircuitSelection extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.circuit_selection);
		
		Button btn_valid_circuit = (Button) findViewById(R.id.btn_valid_circuit);
		btn_valid_circuit.setOnClickListener(new View.OnClickListener() {

			/* Method called on click */
			public void onClick(View view) {
				Intent launchTutorial;							
				launchTutorial = new Intent(getBaseContext(), CircuitCurrent.class);
				startActivity(launchTutorial);
			}
		});
	}

	
}