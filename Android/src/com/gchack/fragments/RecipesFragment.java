package com.gchack.fragments;

import com.gchack.infone.CustomPlayerActivity;
import com.gchack.infone.R;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;


public class RecipesFragment extends ListFragment { 
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedBundleInstance){
		CustomPlayerActivity.recipeAdapter = new ArrayAdapter<String>(inflater.getContext(), R.layout.recipe_comments_view,R.id.move_list_item,
				 CustomPlayerActivity.eventStats);
		 setListAdapter(CustomPlayerActivity.recipeAdapter);
		 return super.onCreateView(inflater, container, savedBundleInstance); 
	}
} 
