package com.gchack.infone;
import com.gchack.fragments.RecipeCommentsFragment;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;
import com.google.android.youtube.player.YouTubePlayer.Provider;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;


public class CustomPlayerActivity extends Activity implements 
YouTubePlayer.OnInitializedListener {
	private YouTubePlayerFragment ytpf;
	private YouTubePlayer ytp;
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.custom_player_view);
	
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
		ytp.loadVideo("x_1N5xwuBYs");
		// TODO Auto-generated method stub
		
	}
}
