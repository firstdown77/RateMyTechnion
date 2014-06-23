package com.ratemytechnion;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.ratemytechnion.R;

public class FragmentWelcomeView extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_welcome_view,
				container, false);
		
		ApplicationWithGlobalVariables a = ((ApplicationWithGlobalVariables) getActivity().getApplication());
		a.setLoggedIn(true);
		Bundle bundle = getActivity().getIntent().getExtras();
		String personName = bundle.getString("the username");
		TextView myText = (TextView) rootView.findViewById(R.id.helloVisitorTextView);
		myText.setText(personName);
		TextView thresholdText = (TextView) rootView.findViewById(R.id.ratingsSubmittedAndThresholdTextView);
		int threshold = a.getRatingsThreshold();
		int submitted = a.getRatingsSubmitted();
		int remaining = threshold - submitted;
		if (submitted >= 0 && threshold >= 0 && remaining >= 0) {
			thresholdText.setText("You have submitted " + submitted + ((submitted == 1) ? " rating." : " ratings.")
					+ " You may submit " + remaining + " more " + ((remaining == 1) ? "rating" : "ratings") + " this"
							+ " semester." + ((remaining == 0) ? "\n\nThank you for using RateMyTechnion."
									+ " See you next semester." : ""));
		}

		return rootView;
	}
}
