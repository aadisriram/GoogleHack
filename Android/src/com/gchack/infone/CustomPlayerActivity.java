package com.gchack.infone;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ActionBar;
import android.app.ActionBar.TabListener;
import android.app.Activity;
import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Toast;

import com.gchack.datalayer.WebServiceFetcher;
import com.gchack.dataobjects.VideoDetails;
import com.gchack.dataobjects.YoutubeVideo;
import com.gchack.fragments.CommentsFragment;
import com.gchack.fragments.RecipesFragment;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerFragment;


public class CustomPlayerActivity extends Activity implements 
YouTubePlayer.OnInitializedListener {
	private YouTubePlayerFragment ytpf;
	private YouTubePlayer ytp;
	ActionBar.Tab comments, recipes;
	private String videoId;
    Fragment commentsTab = new CommentsFragment();
    Fragment recipeTab = new RecipesFragment();
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.custom_player_view);
		videoId = getIntent().getStringExtra("videoId");
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayShowHomeEnabled(false);
	//	 actionBar.setDisplayShowTitleEnabled(false);
		 
	        // Create Actionbar Tabs
	    actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
	    comments = actionBar.newTab().setText("Comments");
        recipes = actionBar.newTab().setText("Recipe");
        comments.setTabListener(new com.gchack.infone.TabListener(commentsTab));
        recipes.setTabListener(new com.gchack.infone.TabListener(recipeTab));
        
        actionBar.addTab(comments);
        actionBar.addTab(recipes);
	/*	Intent intent = new Intent(CustomPlayerActivity.this,CustomYouTubeActivity.class);
        startActivity(intent); */
        ytpf = (YouTubePlayerFragment) getFragmentManager()
	             .findFragmentById(R.id.youtube_fragment);
		ytpf.initialize("AIzaSyC-R09MYt2HS82nxKuFCzvNgC60DnxFcqM", this);
	}
	@Override
	public void onInitializationFailure(Provider provider,
			YouTubeInitializationResult youtubeInitialize) {
		// TODO Auto-generated method stub
		Toast.makeText(this, "Initialization Fail", Toast.LENGTH_LONG).show();
		
	}

	@Override
	public void onInitializationSuccess(Provider provider, YouTubePlayer player,
			boolean wasrestored) {
		ytp = player;
		Toast.makeText(this, "Initialization  Success", Toast.LENGTH_LONG).show();
		ytp.loadVideo(videoId);
		// TODO Auto-generated method stub
		
	}
	
	WebServiceFetcher ws = new WebServiceFetcher();
	private class GetVideoDataTask extends AsyncTask<String, Integer, String> {

		protected void onPostExecute(String result) {
			try {
				VideoDetails vd = ws.getVideoDetails(result);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		@Override
		protected String doInBackground(String... arg0) {
			try {
				return ws.getVideoData(arg0[0]);
			} catch (Exception e) {
				return e.getMessage();
			}
		}
	}
}
