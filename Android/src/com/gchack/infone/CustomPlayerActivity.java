package com.gchack.infone;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.gchack.datalayer.WebServiceFetcher;
import com.gchack.dataobjects.VideoDetails;
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
    
    public static String[] commentStats = new String[0];
    public static String[] eventStats = new String[0];
    public static ArrayAdapter<String> adapter;
    
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.custom_player_view);
		commentStats = new String[0];
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
        
        new GetVideoDataTask().execute(videoId);
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
				commentStats = new String[vd.comments.size()];
				for(int i = 0; i < vd.comments.size(); i++) {
					commentStats[i] = vd.comments.get(i).getComment();
				}
				eventStats = new String[vd.events.size()];
				for(int i = 0; i < vd.comments.size(); i++) {
					eventStats[i] = vd.events.get(i).getEvent();
				}
				
			} catch (Exception e) {
				Toast t = Toast.makeText(getApplicationContext(), "Problem pulling comments", Toast.LENGTH_LONG);
				t.show();
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
