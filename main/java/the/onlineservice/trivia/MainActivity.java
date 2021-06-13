package the.onlineservice.trivia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import the.onlineservice.trivia.DB.DatabaseHelper;
import the.onlineservice.trivia.View.QuestionActivity;

public class MainActivity extends AppCompatActivity {

    EditText userName_main;
    Button next;

    DatabaseHelper database_helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(ContextCompat.getColor
                    (MainActivity.this,R.color.white));
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }

        database_helper = new DatabaseHelper(MainActivity.this);

        userName_main = findViewById(R.id.userName_main);

        next = findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (userName_main.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please Enter your name", Toast.LENGTH_SHORT).show();
                }else {
                    SharedPreferences preferences = getSharedPreferences("TRIVIA_SHRD_PREF", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("username",userName_main.getText().toString());
                    editor.apply();

                    startActivity(new Intent(MainActivity.this, QuestionActivity.class));
                }
            }
        });
    }
}