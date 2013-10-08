package fragments;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.abhinav.twitterclient.R;
import com.abhinav.twitterclient.TweetsAdapter;
import com.abhinav.twitterclient.models.Tweet;

public class TweetsListFragment extends Fragment {

	TweetsAdapter adapter;
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		ArrayList<Tweet> tweets = new ArrayList<Tweet>();
		Activity activity = getActivity();
		adapter = new TweetsAdapter(activity, tweets);
		ListView lv = (ListView)activity.findViewById(R.id.lvTweets);
		lv.setAdapter(adapter);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_tweets_list, container, false);
	}

	public TweetsAdapter getAdapter() {
		return adapter;
	}
}
