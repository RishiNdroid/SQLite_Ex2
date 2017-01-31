package com.example.rndroid.sqlite_ex2;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    FragmentManager manager;
    public void changeView(String str){
        EmployeeDetailFragment studentDetailFragment = new EmployeeDetailFragment();
        manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        if (str.contentEquals("stud")) {
            transaction.replace(R.id.container1, studentDetailFragment);
            transaction.commit();
        }else if (str.contentEquals("updateSal")){
            UpdateSallaryFragment updateSallaryFragment = new UpdateSallaryFragment();
            FragmentTransaction transaction1 = manager.beginTransaction();
            transaction.replace(R.id.container1,updateSallaryFragment);
            transaction.commit();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainFragment mainFragment = new MainFragment();
        manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.container1, mainFragment);
        transaction.commit();
    }
}
