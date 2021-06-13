package the.onlineservice.trivia.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

import the.onlineservice.trivia.Model.ModelHistory;

public class DatabaseHelper extends SQLiteOpenHelper {

    //database name
    public static final String DATABASE_NAME = "Trivia";

    //database version
    public static final int DATABASE_VERSION = 1;

    //databse table name
    public static final String TABLE_NAME = "trivia";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME,null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query;
        //creating table
        query = "CREATE TABLE " + TABLE_NAME + "(ID INTEGER PRIMARY KEY, gameDate TEXT," +
                "userName TEXT,a1 TEXT,a2 TEXT)";
        sqLiteDatabase.execSQL(query);
    }

    //upgrading db
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    //add the new data
    public void addNotes(String gameDate, String userName,String a1,String a2) {
        SQLiteDatabase sqLiteDatabase = this .getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("GameDate", gameDate);
        values.put("UserName", userName);
        values.put("A1", a1);
        values.put("A2", a2);

        //inserting new row
        sqLiteDatabase.insert(TABLE_NAME, null , values);

        //close database connection
        sqLiteDatabase.close();
    }

    //get the all notes
    public ArrayList<ModelHistory> getNotes() {
        ArrayList<ModelHistory> arrayList = new ArrayList<>();

        // select all query
        String select_query= "SELECT *FROM " + TABLE_NAME;

        SQLiteDatabase db = this .getWritableDatabase();
        Cursor cursor = db.rawQuery(select_query, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                ModelHistory noteModel = new ModelHistory();
                noteModel.setID(cursor.getString(0));
                noteModel.setGameDate(cursor.getString(1));
                noteModel.setUserName(cursor.getString(2));
                noteModel.setA1(cursor.getString(3));
                noteModel.setA2(cursor.getString(4));
                arrayList.add(noteModel);
            }while (cursor.moveToNext());
        }
        return arrayList;
    }

}
