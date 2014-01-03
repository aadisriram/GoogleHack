package com.gchack.fragments;

import com.gchack.infone.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class EventScheduleBar extends Fragment {
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedBundleInstance){
		View seekbarView = inflater.inflate(R.layout.seek_bar, container, false);
		return seekbarView;
	}
}
