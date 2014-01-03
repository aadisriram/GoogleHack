package com.gchack.infone;
import android.app.ActionBar;
import android.app.ActionBar.TabListener;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.widget.Toast;

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
    Fragment commentsTab = new CommentsFragment();
    Fragment recipeTab = new RecipesFragment();
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.custom_player_view);
		
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
		ytp.loadVideo("6OdPsB2Wdwk");
		// TODO Auto-generated method stub
		
	}
}
