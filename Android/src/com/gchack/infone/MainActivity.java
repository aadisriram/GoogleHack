package com.gchack.infone;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import android.app.Activity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.View;

import com.facebook.*;
import com.facebook.model.*;

import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;


public class MainActivity extends Activity {


	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
		setContentView(R.layout.landingpage);
		Button button = (Button) findViewById(R.id.login_button);
		//startActivity(new Intent(getBaseContext(), LoginScreen.class));
		
		button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
        		// launch page
            	//startActivity(new Intent(getBaseContext(), LoginScreen.class));
        	    };                       
	});
		
	  }
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
}
	
	




