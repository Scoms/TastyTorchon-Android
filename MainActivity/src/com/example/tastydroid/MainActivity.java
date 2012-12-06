package com.example.tastydroid;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences.Editor;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//Load the SharedPreferences
				SharedPreferences prefs = getSharedPreferences("TastyDroidPref",
						MODE_PRIVATE);				
				if (prefs.getInt("firstOpen", 0) == 0) {
					Builder alertbox = new Builder(this);
					alertbox.setMessage("Voulez vous voir le didacticiel ?");
					alertbox.setPositiveButton("Yes", new OnClickListener() {
						public void onClick(DialogInterface arg0, int arg1) {
							Intent launchTutorial;							
							launchTutorial = new Intent(getBaseContext(), Tutorial.class);
							startActivity(launchTutorial);
						}
					});
					alertbox.setNegativeButton("No",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface arg0, int arg1) {
									
								}
							});
					alertbox.show();
				}
				// Setting the validation Button.
				Button btn = (Button) findViewById(R.id.btn_scan);
				btn.setOnClickListener(new View.OnClickListener() {

					/* Method called on click */
					public void onClick(View view) {
						Intent launchTutorial;							
						launchTutorial = new Intent(getBaseContext(), Scan.class);
						startActivity(launchTutorial);
					}
				});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
