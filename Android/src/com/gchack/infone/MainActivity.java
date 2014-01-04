package com.gchack.infone;

import com.gchack.datalayer.WebServiceFetcher;
import com.gchack.dataobjects.VideoDetails;
import com.gchack.dataobjects.YoutubeVideo;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.gchack.datalayer.WebServiceFetcher;
import com.gchack.dataobjects.VideoDetails;
import com.gchack.dataobjects.YoutubeVideo;

public class MainActivity extends Activity {

	VideoDetails videoDetails;
	private ListView mainListView;
	private ArrayAdapter<String> listAdapter;
	List<YoutubeVideo> videoListOne = new ArrayList<YoutubeVideo>();
	List<String> videoNameList = new ArrayList<String>();
	WebServiceFetcher ws = new WebServiceFetcher();

	String[] web = {

	} ;
	String[] imageId = {

	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);	
		setContentView(R.layout.activity_main);
		ActionBar ab = getActionBar();
		ab.setTitle("Recent Feed");
		VideoListAdapter adapter = new
				VideoListAdapter(MainActivity.this, web, imageId);
		mainListView = (ListView)findViewById(R.id.home_list);
		mainListView.setAdapter(adapter);
		mainListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				Intent intent = new Intent(MainActivity.this, CustomPlayerActivity.class);
				intent.putExtra("videoId", videoListOne.get(position).getId());
				startActivity(intent);
			}
		});
		new GetVideoList().execute();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private class GetVideoList extends AsyncTask<Void, Integer, String> {

		protected void onPostExecute(String result) {

			videoListOne = new ArrayList<YoutubeVideo>();
			videoNameList = new ArrayList<String>();
			try {
				JSONObject jObj = new JSONObject(result);
				jObj = jObj.getJSONObject("feed");
				JSONArray linkArray = jObj.getJSONArray("entry");
				for(int i = 0; i < linkArray.length(); i++) {
					JSONObject temp = linkArray.getJSONObject(i);
					JSONObject idObj = temp.getJSONObject("id");
					String id = idObj.getString("$t");
					String[] splitId = id.split("/");
					id = splitId[splitId.length - 1];
					JSONObject title = temp.getJSONObject("title");
					videoNameList.add(title.getString("$t"));
					temp = temp.getJSONObject("media$group");
					JSONObject length = temp.getJSONObject("yt$duration");
					JSONArray tt = temp.getJSONArray("media$thumbnail");
					temp = tt.getJSONObject(0);
					videoListOne.add(new YoutubeVideo(id, temp.getString("url"), title.getString("$t"), length.getInt("seconds")));
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}

			web = new String[videoNameList.size()];
			imageId = new String[videoListOne.size()];
			int i = 0;
			for(String vid: videoNameList) {
				web[i] = vid;
				imageId[i] = videoListOne.get(i).getThumbnail();
				System.out.println(imageId[i]);
				i++;
			}
			VideoListAdapter adapter = new VideoListAdapter(MainActivity.this, web, imageId);
			mainListView.setAdapter(adapter);
			adapter.notifyDataSetChanged();
		}

		@Override
		protected String doInBackground(Void... arg0) {

			try {
				return ws.getYoutubeList();
			} catch (Exception e) {
				return e.getMessage();
			}
		}
	}
	
}

