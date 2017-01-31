package com.example.rndroid.sqlite_ex2;


import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class UpdateSallaryFragment extends Fragment {

    String temp = null;
    String tempName = null, tempDept  = null;
    String tempDeptString = null;
    MyDatabase myDatabase;
    public UpdateSallaryFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myDatabase = new MyDatabase(getActivity());
        myDatabase.openDB();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = getActivity().getLayoutInflater().inflate(R.layout.fragment_update_sallary, container, false);
         final EditText editTextName = (EditText) v.findViewById(R.id.edittext_empName_updateSal);
         final EditText editTextDept = (EditText) v.findViewById(R.id.edittext_empDept_updateSal);
         final EditText editTextNewSal = (EditText) v.findViewById(R.id.edittext_empNewSal_updateSal);
        final Button buttonSubmit = (Button) v.findViewById(R.id.button_saveNewSal_updateSal);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor c1 = null;
//                tempDeptString = editTextDept.getText().toString().toLowerCase();
//                switch (tempDeptString){
//                    case "training" : temp = "1";
//                    case "placement" : temp = "2";
//                    case "sales" : temp = "3";
//                }
                c1 = myDatabase.getEmployeeName(editTextName.getText().toString().toLowerCase())/*,temp)*/;
                if (c1 != null){
                    while (c1.moveToNext()){
                         tempName = c1.getString(c1.getColumnIndex("ename"));
                         tempDept = c1.getString(c1.getColumnIndex("dno"));
                        Toast.makeText(getActivity(), "Inside while loop", Toast.LENGTH_SHORT).show();

                        if (editTextName.getText().toString().toLowerCase().equals(tempName) /*&& temp.contentEquals(tempDept)*/){
                            myDatabase.updateEmpSal(editTextNewSal.getText().toString());
                            Toast.makeText(getActivity(), "Salary Updated", Toast.LENGTH_SHORT).show();
                    }
                        else {
                            Toast.makeText(getActivity(), "Not Done", Toast.LENGTH_SHORT).show();
                        }
                    }
                }else {
                    Toast.makeText(getActivity(), "cursor is null", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return v;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        myDatabase.closeDB();
    }
}
