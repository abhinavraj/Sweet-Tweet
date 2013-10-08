package com.abhinav.twitterclient;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import fragments.HomeTimelineFragment;
import fragments.MentionsFragment;

public class TweetsActivity extends FragmentActivity implements TabListener {
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);
        setNavigationTabs();
    }
    
    private void setNavigationTabs() {
    	ActionBar actionbar = getActionBar();
    	actionbar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
    	actionbar.setDisplayShowTitleEnabled(true);
    	Tab tabHome = actionbar.newTab().setText("Home").setTag("HomeTimelineFragment").setTabListener(this);
    	Tab tabMentions = actionbar.newTab().setText("Mentions").setTag("MentionsFragment").setTabListener(this);
    	
    	actionbar.addTab(tabHome);
    	actionbar.addTab(tabMentions);
    	actionbar.selectTab(tabHome);
    }

	
	@Override
	public void onTabReselected(Tab tab, android.app.FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabSelected(Tab tab, android.app.FragmentTransaction ft) {
		FragmentManager fm = getSupportFragmentManager();
		FragmentTransaction fts = getSupportFragmentManager().beginTransaction();
		if(tab.getTag() == "HomeTimelineFragment") {
			fts.replace(R.id.frame_container, new HomeTimelineFragment());
		} else {
			fts.replace(R.id.frame_container, new MentionsFragment());
		}
		fts.commit();
	}

	@Override
	public void onTabUnselected(Tab tab, android.app.FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}
    
}
