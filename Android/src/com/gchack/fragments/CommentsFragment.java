package com.gchack.fragments;


import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.gchack.infone.CustomPlayerActivity;
import com.gchack.infone.R;


public class CommentsFragment extends ListFragment {
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedBundleInstance){
		 CustomPlayerActivity.adapter = new ArrayAdapter<String>(inflater.getContext(), R.layout.recipe_comments_view,R.id.move_list_item,
				 CustomPlayerActivity.commentStats);
		 setListAdapter(CustomPlayerActivity.adapter);
		 return super.onCreateView(inflater, container, savedBundleInstance); 
	}
} 
