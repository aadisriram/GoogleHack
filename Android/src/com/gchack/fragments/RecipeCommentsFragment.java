package com.gchack.fragments;

import com.gchack.infone.R;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;


public class RecipeCommentsFragment extends ListFragment {
	String[] numbers_text = new String[]{ "This is first comment", "Second comment", "Really big big big comment using complex engineering terms"};
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedBundleInstance){
		 ArrayAdapter<String> adapter = new ArrayAdapter<String>(inflater.getContext(), R.layout.recipe_comments_view,R.id.move_list_item,
				 numbers_text);  
		 setListAdapter(adapter);
		 return super.onCreateView(inflater, container, savedBundleInstance); 
	}
}
