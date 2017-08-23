package com.codepath.siddhatapatil.todo.sqLite;

/**
 * Created by siddhatapatil on 8/22/17.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class TodoItemDatabaseHelper extends SQLiteOpenHelper{
    public TodoItemDatabaseHelper(Context context) {
        super(context, TodoItemDatabase.DB_NAME, null, TodoItemDatabase.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TodoItemDatabase.TaskEntry.TABLE + " ( " +
                TodoItemDatabase.TaskEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                TodoItemDatabase.TaskEntry.COL_TASK + " TEXT NOT NULL);";

        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TodoItemDatabase.TaskEntry.TABLE);
        onCreate(db);
    }

}
