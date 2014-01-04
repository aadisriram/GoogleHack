package com.gchack.infone;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class LoginScreen extends Activity {

private static final int SPLASH_DISPLAY_TIME = 3000;
	protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);	
	setContentView(R.layout.landingpage);
//	try {
//		Thread.sleep(3000);
//		startActivity(new Intent(getBaseContext(), MainActivity.class));
//	} catch (InterruptedException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
	new Handler().postDelayed(new Runnable() {

        public void run() {

            Intent mainIntent = new Intent(LoginScreen.this,
                    MainActivity.class);
            LoginScreen.this.startActivity(mainIntent);

            LoginScreen.this.finish();
            overridePendingTransition(R.anim.mainfadein,
                    R.anim.splashfadeout);
        }
    }, SPLASH_DISPLAY_TIME);
//	Button button = (Button) findViewById(R.id.login_button);
//
//	button.setOnClickListener(new View.OnClickListener() {
//		public void onClick(View v) {
//			// launch page
//			startActivity(new Intent(getBaseContext(), MainActivity.class));
//		};                       
//	});
}
}
