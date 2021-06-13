package the.onlineservice.trivia.View;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Date;

import the.onlineservice.trivia.DB.DatabaseHelper;
import the.onlineservice.trivia.MainActivity;
import the.onlineservice.trivia.R;

public class FragmentThree extends Fragment {

    TextView s1,s3a,s4a;
    Button finish,history;
    DatabaseHelper database_helper;

    String userName,answer1,answer2;

    public FragmentThree() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_three, container, false);

        database_helper = new DatabaseHelper(getContext());

        //fetch shredpreference data
        SharedPreferences preferences = this.getActivity().getSharedPreferences("TRIVIA_SHRD_PREF", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        userName = preferences.getString("username",null);
        answer1 = preferences.getString("answer1",null);
        answer2 = preferences.getString("answer2",null);

        s1 = view.findViewById(R.id.s1);
        s1.setText("Hello "+userName);

        s3a = view.findViewById(R.id.s3a);
        s3a.setText(answer1);

        s4a = view.findViewById(R.id.s4a);
        s4a.setText(answer2);

        //create new database
        String currentDateTime = java.text.DateFormat.getDateTimeInstance().format(new Date());
        database_helper.addNotes(currentDateTime,userName,answer1,answer2);

        finish = view.findViewById(R.id.finish);
        history = view.findViewById(R.id.history);

        //intent to first page
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), MainActivity.class));
                getActivity().finishAffinity();
            }
        });

        //intent to history page
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_container,new FragmentHistory()).addToBackStack(null).commit();
            }
        });
        return view;
    }
}