package com.gchack.infone;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.os.Handler;
 
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.plus.PlusClient;
import com.google.android.gms.plus.PlusClient.OnAccessRevokedListener;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;

import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;


public class LoginScreen extends Activity  implements
ConnectionCallbacks, OnConnectionFailedListener, OnClickListener,
OnAccessRevokedListener{
	
	   private static final int REQUEST_CODE_RESOLVE_ERR = 9000;
	    private ProgressDialog mConnectionProgressDialog;
	    private PlusClient mPlusClient;
	    private ConnectionResult mConnectionResult;
		private static final String TAG = "SignInTestActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    
	    mPlusClient = new PlusClient.Builder(getApplicationContext(), this, this)
        .setActions("http://schemas.google.com/AddActivity", "http://schemas.google.com/BuyActivity")
        .setScopes("profile")       // alternative basic login scope
        .build();
	    
	    
	}

	@Override
	public void onAccessRevoked(ConnectionResult status) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onConnectionFailed(ConnectionResult result) {
		 if (mConnectionProgressDialog.isShowing()) {
             // The user clicked the sign-in button already. Start to resolve
             // connection errors. Wait until onConnected() to dismiss the
             // connection dialog.
             if (result.hasResolution()) {
                     try {
                             result.startResolutionForResult(this, REQUEST_CODE_RESOLVE_ERR);
                     } catch (SendIntentException e) {
                             mPlusClient.connect();
                     }
             }
     }

     // Save the intent so that we can start an activity when the user clicks
     // the sign-in button.
     mConnectionResult = result;
		
	}
	

	@Override
	public void onConnected(Bundle connectionHint) {
		  mConnectionProgressDialog.dismiss();
	}

	@Override
	public void onDisconnected() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.sign_in_button:
			Log.v(TAG, "Tapped sign in");
			if (!mPlusClient.isConnected()) {
				// Show the dialog as we are now signing in.
				mConnectionProgressDialog.show();
				// Make sure that we will start the resolution (e.g. fire the
				// intent and pop up a dialog for the user) for any errors
				// that come in
				// We should always have a connection result ready to resolve,
				// so we can start that process.
				if (mConnectionResult != null) {
					startResolution();
				} else {
					// If we don't have one though, we can start connect in
					// order to retrieve one.
					mPlusClient.connect();
				}
			}
		}
	}

	private void startResolution() {
		// TODO Auto-generated method stub
		
	}
}
					
		
	
