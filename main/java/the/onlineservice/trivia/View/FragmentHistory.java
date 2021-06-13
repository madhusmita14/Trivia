package the.onlineservice.trivia.View;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

import the.onlineservice.trivia.Controller.AdapterHistory;
import the.onlineservice.trivia.DB.DatabaseHelper;
import the.onlineservice.trivia.Model.ModelHistory;
import the.onlineservice.trivia.R;

public class FragmentHistory extends Fragment {

    ArrayList<ModelHistory> arrayList;
    RecyclerView recyclerView;
    DatabaseHelper database_helper;

    public FragmentHistory() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_history, container, false);

        recyclerView = (RecyclerView)view.findViewById(R.id.recycler_view);
        database_helper = new DatabaseHelper(getContext());

        displayNotes();

        return view;
    }

    public void displayNotes() {
        arrayList = new ArrayList<>(database_helper.getNotes());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        AdapterHistory adapter = new AdapterHistory(getContext(), getActivity(), arrayList);
        recyclerView.setAdapter(adapter);
    }
}