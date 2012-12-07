package com.example.tastydroid;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.json.JSONArray;
import org.json.JSONObject;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences.Editor;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

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

	/*public void clickbutton(View v) {
	    try {
	        // http://androidarabia.net/quran4android/phpserver/connecttoserver.php

	        // Log.i(getClass().getSimpleName(), "send  task - start");
	        HttpParams httpParams = new BasicHttpParams();
	        HttpConnectionParams.setConnectionTimeout(httpParams, TIMEOUT_MILLISEC);
	        HttpConnectionParams.setSoTimeout(httpParams, TIMEOUT_MILLISEC);
	        //
	        HttpParams p = new BasicHttpParams();
	        // p.setParameter("name", pvo.getName());
	        p.setParameter("user", "1");

	        // Instantiate an HttpClient
	        HttpClient httpclient = new DefaultHttpClient(p);
	        String url = "http://10.0.2.2:8080/sample1/" + 
	                     "webservice1.php?user=1&format=json";
	        HttpPost httppost = new HttpPost(url);

	        // Instantiate a GET HTTP method
	        try {
	            Log.i(getClass().getSimpleName(), "send  task - start");
	            //
	            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(
	                    2);
	            nameValuePairs.add(new BasicNameValuePair("user", "1"));
	            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
	            ResponseHandler<String> responseHandler = new BasicResponseHandler();
	            String responseBody = httpclient.execute(httppost,
	                    responseHandler);
	            // Parse
	            JSONObject json = new JSONObject(responseBody);
	            JSONArray jArray = json.getJSONArray("posts");
	            ArrayList<HashMap<String, String>> mylist = 
	                   new ArrayList<HashMap<String, String>>();

	            for (int i = 0; i < jArray.length(); i++) {
	                HashMap<String, String> map = new HashMap<String, String>();
	                JSONObject e = jArray.getJSONObject(i);
	                String s = e.getString("post");
	                JSONObject jObject = new JSONObject(s);

	                map.put("idusers", jObject.getString("idusers"));
	                map.put("UserName", jObject.getString("UserName"));
	                map.put("FullName", jObject.getString("FullName"));

	                mylist.add(map);
	            }
	            Toast.makeText(this, responseBody, Toast.LENGTH_LONG).show();

	        } catch (ClientProtocolException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        // Log.i(getClass().getSimpleName(), "send  task - end");

	    } catch (Throwable t) {
	        Toast.makeText(this, "Request failed: " + t.toString(),
	                Toast.LENGTH_LONG).show();
	    }
	}*/
}
