package com.technionrankerv1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FragmentProfessors extends Fragment {

	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_professors, container, false);
		ListView list = (ListView)rootView.findViewById(R.id.leosProfs);
		String[] tempString2 = ((FragmentMainActivity) getActivity()).
				getProfessorValues();
		ArrayAdapter<String> ad=new ArrayAdapter<String>(getActivity(),
				R.layout.text_item, tempString2);
		list.setAdapter(ad);
		list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
	            String value = (String)parent.getItemAtPosition(position);
				Intent i = new Intent(getActivity(), ProfessorView.class);
				i.putExtra("professorName", value);
				i.putExtra("faculty", ((FragmentMainActivity) getActivity()).facultyMap.get(value));
				startActivity(i);
			}
		});
        return rootView;
	}
}