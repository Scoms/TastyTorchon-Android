package com.example.tastydroid;

import com.google.android.maps.MapActivity;

import android.app.Activity;
import android.os.Bundle;

public class Geoloc extends MapActivity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.geoloc);
		
	}

	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}
}
