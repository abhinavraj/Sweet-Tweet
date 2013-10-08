package fragments;

import java.util.ArrayList;

import org.json.JSONArray;

import android.os.Bundle;

import com.abhinav.twitterclient.R;
import com.abhinav.twitterclient.TwitterClientApp;
import com.abhinav.twitterclient.models.Tweet;
import com.loopj.android.http.JsonHttpResponseHandler;

public class HomeTimelineFragment extends TweetsListFragment {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
    	TwitterClientApp.getRestClient().getHomeTimeLine(new JsonHttpResponseHandler() {
    		@Override
    		public void onSuccess(JSONArray jsonTweets) {
    			ArrayList<Tweet> tweets = Tweet.fromJson(jsonTweets);
    			getAdapter().addAll(tweets);
    		}
    	});
	}

}
