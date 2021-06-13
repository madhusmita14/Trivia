package the.onlineservice.trivia.Controller;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import the.onlineservice.trivia.DB.DatabaseHelper;
import the.onlineservice.trivia.Model.ModelHistory;
import the.onlineservice.trivia.R;

public class AdapterHistory extends RecyclerView.Adapter<AdapterHistory.viewHolder> {
    Context context;
    Activity activity;
    ArrayList<ModelHistory> arrayList;

    public AdapterHistory(Context context, Activity activity,
                                 ArrayList<ModelHistory> arrayList) {
        this.context = context;
        this.activity = activity;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_history_item,parent,false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.Game1_history.setText("Game:"+arrayList.get(position).getID());
        holder.Date_history.setText(arrayList.get(position).getGameDate());
        holder.Name_history.setText(arrayList.get(position).getUserName());
        holder.a1_history.setText(arrayList.get(position).getA1());
        holder.a2_history.setText(arrayList.get(position).getA2());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView Game1_history, Date_history,Name_history,a1_history,a2_history;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            Game1_history = (TextView) itemView.findViewById(R.id.Game1_history);
            Date_history = (TextView) itemView.findViewById(R.id.Date_history);
            Name_history = (TextView) itemView.findViewById(R.id.Name_history);
            a1_history = (TextView) itemView.findViewById(R.id.a1_history);
            a2_history = (TextView) itemView.findViewById(R.id.a2_history);
        }
    }
}
