package com.gchack.infone;

import java.io.InputStream;
import java.net.URL;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class VideoListAdapter extends ArrayAdapter<String>{
	private final Activity context;
	private final String[] web;
	private final String[] imageId;
	
	public VideoListAdapter(Activity context,
			String[] web, String[] imageId) {
		super(context, R.layout.home_page_item, web);
		this.context = context;
		this.web = web;
		this.imageId = imageId;
	}
	
	@Override
	public View getView(int position, View view, ViewGroup parent) {
		LayoutInflater inflater = context.getLayoutInflater();
		View rowView= inflater.inflate(R.layout.home_page_item, null, true);
		TextView txtTitle = (TextView) rowView.findViewById(R.id.video_name);
		ImageView imageView = (ImageView) rowView.findViewById(R.id.video_thumb);
		txtTitle.setText(web[position]);
		new DownloadImageTask(imageView)
        .execute(imageId[position]);
		//imageView.setImageURI(imageId[position]);
		return rowView;
	}
	
	private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
		  ImageView bmImage;

		  public DownloadImageTask(ImageView bmImage) {
		      this.bmImage = bmImage;
		  }

		  protected Bitmap doInBackground(String... urls) {
		      String urldisplay = urls[0];
		      Bitmap mIcon11 = null;
		      try {
		        InputStream in = new java.net.URL(urldisplay).openStream();
		        mIcon11 = BitmapFactory.decodeStream(in);
		      } catch (Exception e) {
		          Log.e("Error", e.getMessage());
		          e.printStackTrace();
		      }
		      return mIcon11;
		  }

		  protected void onPostExecute(Bitmap result) {
		      bmImage.setImageBitmap(result);
		  }
		}
	
}
