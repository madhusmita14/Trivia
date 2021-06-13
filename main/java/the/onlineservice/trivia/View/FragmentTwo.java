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

import java.util.ArrayList;

import the.onlineservice.trivia.DB.DatabaseHelper;
import the.onlineservice.trivia.R;

public class FragmentTwo extends Fragment {

    Button next_two;

    CheckBox q2c1,q2c2,q2c3,q2c4;

    DatabaseHelper database_helper;
    String checkBoxValueQ2;
    ArrayList<String> answerList;


    public FragmentTwo() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_two, container, false);

        database_helper = new DatabaseHelper(getContext());

        answerList = new ArrayList<>();

        q2c1 = view.findViewById(R.id.q2c1);
        q2c2 = view.findViewById(R.id.q2c2);
        q2c3 = view.findViewById(R.id.q2c3);
        q2c4 = view.findViewById(R.id.q2c4);

        q2c1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    checkBoxValueQ2 = compoundButton.getText().toString();
                    if(!answerList.contains(checkBoxValueQ2)){
                        answerList.add(checkBoxValueQ2);
                    }
                } else {
                    answerList.remove(checkBoxValueQ2);
                }
            }
        });

        q2c2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    checkBoxValueQ2 = compoundButton.getText().toString();
                    if(!answerList.contains(checkBoxValueQ2)){
                        answerList.add(checkBoxValueQ2);
                    }
                } else {
                    answerList.remove(checkBoxValueQ2);
                }
            }
        });

        q2c3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    checkBoxValueQ2 = compoundButton.getText().toString();
                    if(!answerList.contains(checkBoxValueQ2)){
                        answerList.add(checkBoxValueQ2);
                    }
                } else {
                    answerList.remove(checkBoxValueQ2);
                }
            }
        });

        q2c4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    checkBoxValueQ2 = compoundButton.getText().toString();
                    if(!answerList.contains(checkBoxValueQ2)){
                        answerList.add(checkBoxValueQ2);
                    }
                }
                else {
                    answerList.remove(checkBoxValueQ2);
                }
            }
        });

        next_two = view.findViewById(R.id.next_two);
        next_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //validation to check if null value is passing
                if (answerList.isEmpty()) {
                    Toast.makeText(getContext(), "Please select your answers", Toast.LENGTH_SHORT).show();
                }else {
                    //sending data by concatenating comma
                    String listString = "";
                    for (String s : answerList)
                    {
                        listString += s + ",";
                    }

                    SharedPreferences preferences = getActivity().getSharedPreferences("TRIVIA_SHRD_PREF", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("answer2",listString);
                    editor.apply();

                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.frame_container,new FragmentThree()).commit();
                }

            }
        });
        return view;
    }
}