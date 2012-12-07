package com.example.tastydroid;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences.Editor;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
					alertbox.setPositiveButton("Oui", new OnClickListener() {
						public void onClick(DialogInterface arg0, int arg1) {
							Intent launchTutorial;							
							launchTutorial = new Intent(getBaseContext(), Tutorial.class);
							startActivity(launchTutorial);
						}
					});
					alertbox.setNegativeButton("Non",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface arg0, int arg1) {
									
								}
							});
					alertbox.show();
				}
				alertBox();
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

				Button btn_search = (Button) findViewById(R.id.btn_search);
				btn_search.setOnClickListener(new View.OnClickListener() {

					/* Method called on click */
					public void onClick(View view) {
						Intent launchTutorial;							
						launchTutorial = new Intent(getBaseContext(), CircuitSelection.class);
						startActivity(launchTutorial);
					}
				});
				
				Button btn_geo = (Button) findViewById(R.id.btn_geo);
				btn_geo.setOnClickListener(new View.OnClickListener() {

					/* Method called on click */
					public void onClick(View view) {
						Intent launchTutorial;							
						launchTutorial = new Intent(getBaseContext(), Geoloc.class);
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
	
	/**
	 * Generating the alertbox to ask the user his username and password.
	 * Checking the informations and generate both patients and meetings table.
	 */
	public void alertBox() {

		// Building the alertBox.
		LayoutInflater factory = LayoutInflater.from(this);
		final View alertBoxView = factory.inflate(R.layout.alertlayout, null);
		AlertDialog.Builder alert = new AlertDialog.Builder(this);

		// Setting all the informations.
		alert.setTitle("Please Login to CUH Melanoma");
		alert.setMessage("Enter your username and password");
		// Insert the two textfield in the alertBox.
		alert.setView(alertBoxView);
		EditText inputUser = (EditText) alertBoxView.findViewById(R.id.username);
		EditText inputPassword = (EditText) alertBoxView.findViewById(R.id.password);

		// Set the listener for the positive button and try to connect.
		alert.setPositiveButton("Login", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int whichButton) {
/*
				if (!request("patient", inputUser.getText().toString(),
						inputPassword.getText().toString())) {

					// If the password is wrong show the alertBox again.
					alertBox();
				} else {

					// Load the other table informations.
					request("meeting", inputUser.getText().toString(),
							inputPassword.getText().toString());

					// Save all the info in the properties of the Application.
					SharedPreferences settings = getSharedPreferences("TastyDroidPref",
							MODE_PRIVATE);
					Editor editor = settings.edit();

					// Insert Encryption of the username and password.
					editor.putString("u", inputUser.getText().toString());
					editor.putString("p", inputPassword.getText().toString());
					editor.commit();

					// Set the informations localy.
					pass = inputPassword.getText().toString();
					user = inputUser.getText().toString();
				}
*/
			}
		});

		// Set the Cancel button but do nothing.
		alert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						// Canceled.
					}
				});

		// Display the alertBox.
		alert.show();
	}

}
