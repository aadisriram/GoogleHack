package com.gchack.infone;

import com.gchack.datalayer.WebServiceFetcher;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class VideoListAdapter extends ArrayAdapter<String>{
	private final Activity context;
	private final String[] web;
	private final Integer[] imageId;
	
	public VideoListAdapter(Activity context,
			String[] web, Integer[] imageId) {
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
		imageView.setImageResource(R.drawable.ic_launcher);
		return rowView;
	}
}
