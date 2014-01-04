package com.gchack.infone;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginScreen extends Activity {
	
	protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);	
	setContentView(R.layout.landingpage);
	Button button = (Button) findViewById(R.id.login_button);

	button.setOnClickListener(new View.OnClickListener() {
		public void onClick(View v) {
			// launch page
			startActivity(new Intent(getBaseContext(), MainActivity.class));
		};                       
	});
}
}
