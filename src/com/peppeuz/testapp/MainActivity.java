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
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	
	Button salva;
	Button cambia;
	EditText testoDaSalvare;
	SharedPreferences prefs;
	Bundle extra;
	String testo;
	String testoToast;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		salva = (Button) findViewById(R.id.salva);
		salva.setOnClickListener(this);
		cambia = (Button) findViewById(R.id.cambia);
		cambia.setOnClickListener(this);
		testoDaSalvare = (EditText) findViewById(R.id.testo);
		prefs = PreferenceManager.getDefaultSharedPreferences(this);
		extra = getIntent().getExtras();
		if (extra != null) {
			testo = extra.getString("testoIndietro");
		} else
		{
			testo = prefs.getString("testoSalvato", "");
		}

		Toast.makeText(getApplicationContext(), testo, Toast.LENGTH_LONG)
				.show();
		testoDaSalvare.setText(testo);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View view) {
		if (view == salva) {
			String testo = testoDaSalvare.getText().toString();
			salvapreferenze(testo);
			Toast.makeText(getApplicationContext(), "Testo salvato!", Toast.LENGTH_LONG).show();

		}
		if (view == cambia) {
			Intent cambia = new Intent(this, Second_activity.class);
			startActivity(cambia);
		}
		// TODO Auto-generated method stub

	}

	public void salvapreferenze(String testo) {

		prefs = PreferenceManager.getDefaultSharedPreferences(this);
		SharedPreferences.Editor editor = prefs.edit();
		editor.putString("testoSalvato", testo);
		editor.commit();

	}

}
