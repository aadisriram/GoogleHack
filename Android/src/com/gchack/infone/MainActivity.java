package com.gchack.infone;

import com.gchack.datalayer.WebServiceFetcher;
import com.gchack.dataobjects.VideoDetails;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

public class MainActivity extends Activity {

	VideoDetails videoDetails;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_main);
		new GetVideoList().execute();
//		Intent intent = new Intent(MainActivity.this, CustomPlayerActivity.class);
//        startActivity(intent);
        
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private class GetVideoList extends AsyncTask<Void, Integer, String> {

	     protected void onPostExecute(String result) {
	         Toast t = Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG);
	         t.show();
	     }

		@Override
		protected String doInBackground(Void... arg0) {
			WebServiceFetcher ws = new WebServiceFetcher();
			try {
				ws.getYoutubeList();
				return "testing";
			} catch (Exception e) {
				return e.getMessage();
			}
		}
	 }
}
