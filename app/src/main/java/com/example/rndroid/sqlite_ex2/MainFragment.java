package com.example.rndroid.sqlite_ex2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {


    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = getActivity().getLayoutInflater().inflate(R.layout.fragment_main,container,false);
        Button buttonStud = (Button) v.findViewById(R.id.buttonStudDetail);
        Button buttonDept = (Button) v.findViewById(R.id.buttonDeptDetail);
        final MainActivity m = (MainActivity) getActivity();
        buttonStud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                m.changeView("stud");
            }
        });

        buttonDept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                m.changeView("dept");
            }
        });
        return v;
    }

}
