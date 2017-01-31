package com.example.rndroid.sqlite_ex2;


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
public class EmployeeDetailFragment extends Fragment {

    MyDatabase myDatabase;
    public EmployeeDetailFragment() {
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
        View v = getActivity().getLayoutInflater().inflate(R.layout.fragment_employee_detail, container, false);
        final EditText editTextName = (EditText) v.findViewById(R.id.edittextEmpName_empDetails);
        final EditText editTextDept = (EditText) v.findViewById(R.id.edittextEmpDept_empDetails);
        final EditText editTextSal = (EditText) v.findViewById(R.id.edittextEmpSal_empDetails);
        Button buttonSubmit = (Button) v.findViewById(R.id.buttonSubmit_empDetails);
        Button buttonEditName = (Button) v.findViewById(R.id.buttonEditName_empDetails);
        Button buttonEditSal = (Button) v.findViewById(R.id.buttonEditSal_empDetails);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String department = editTextDept.getText().toString().toLowerCase();
                if (department.equals("sales")||department.equals("training")||department.equals("placement")){
                    myDatabase.insert(editTextName.getText().toString().toLowerCase(),editTextSal.getText().toString().toLowerCase(),department);
                    Toast.makeText(getActivity(), "Details Saved", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getActivity(), "Enter Valid department.\n sales or placement or training", Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonEditSal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity m = (MainActivity) getActivity();
                m.changeView("updateSal");
            }
        });
        return v;
    }

    @Override
    public void onDestroy() {
        myDatabase.closeDB();
        super.onDestroy();
    }
}
