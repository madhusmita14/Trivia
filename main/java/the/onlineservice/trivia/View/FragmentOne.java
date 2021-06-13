package the.onlineservice.trivia.View;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import the.onlineservice.trivia.DB.DatabaseHelper;
import the.onlineservice.trivia.R;

public class FragmentOne extends Fragment{

    Button next_one;
    CheckBox q1c1,q1c2,q1c3,q1c4;

    DatabaseHelper database_helper;
    String checkBoxValue;

    public FragmentOne() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_one, container, false);

        database_helper = new DatabaseHelper(getContext());

        q1c1 = view.findViewById(R.id.q1c1);
        q1c2 = view.findViewById(R.id.q1c2);
        q1c3 = view.findViewById(R.id.q1c3);
        q1c4 = view.findViewById(R.id.q1c4);

        //adding listener to all checkbox
        q1c1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    checkBoxValue = compoundButton.getText().toString();
                    //Toast.makeText(getContext(), checkBoxValue, Toast.LENGTH_SHORT).show();
                    q1c2.setChecked(false);
                    q1c3.setChecked(false);
                    q1c4.setChecked(false);
                }
                else {
                    checkBoxValue = null;
                }
            }
        });

        q1c2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    checkBoxValue = compoundButton.getText().toString();
                    //Toast.makeText(getContext(), checkBoxValue, Toast.LENGTH_SHORT).show();
                    q1c1.setChecked(false);
                    q1c3.setChecked(false);
                    q1c4.setChecked(false);
                }
                else {
                    checkBoxValue = null;
                }
            }
        });

        q1c3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    checkBoxValue = compoundButton.getText().toString();
                    //Toast.makeText(getContext(), checkBoxValue, Toast.LENGTH_SHORT).show();
                    q1c1.setChecked(false);
                    q1c2.setChecked(false);
                    q1c4.setChecked(false);
                }
                else {
                    checkBoxValue = null;
                }
            }
        });

        q1c4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    checkBoxValue = compoundButton.getText().toString();
                    //Toast.makeText(getContext(), checkBoxValue, Toast.LENGTH_SHORT).show();
                    q1c1.setChecked(false);
                    q1c2.setChecked(false);
                    q1c3.setChecked(false);
                }
                else {
                    checkBoxValue = null;
                }
            }
        });

        next_one = view.findViewById(R.id.next_one);
        next_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkBoxValue == null) {
                    Toast.makeText(getContext(), "Please select any answer", Toast.LENGTH_SHORT).show();
                }else {
                    //save the data in shredpreference
                    SharedPreferences preferences = getActivity().getSharedPreferences("TRIVIA_SHRD_PREF", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("answer1",checkBoxValue);
                    editor.apply();

                    //intent to next fragment
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.frame_container,new FragmentTwo()).commit();
                }
            }
        });

        return view;
    }
}