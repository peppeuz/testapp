package com.peppeuz.testapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Second_activity extends Activity implements OnClickListener {
	EditText secondoTesto;
	Button torna;
	SharedPreferences prefs;
	String testoRicevuto;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second_activity);
		secondoTesto = (EditText) findViewById(R.id.secondoTesto);
		torna = (Button) findViewById(R.id.torna);
		torna.setOnClickListener(this);
		prefs = PreferenceManager.getDefaultSharedPreferences(this);
		testoRicevuto = prefs.getString("testoSalvato", "D'oh! Qualcosa è andato storto!");
		secondoTesto.setText(testoRicevuto);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.second_activity, menu);
		return true;
	}

	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		if (view == torna){
			String testoDaInviare = secondoTesto.getText().toString();
			Intent cambia = new Intent(this, MainActivity.class);
			cambia.putExtra("testoIndietro", testoDaInviare);
			startActivity(cambia);
			
		}
		
	}

}
