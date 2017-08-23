package com.codepath.siddhatapatil.todo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;

import android.view.View;

import java.util.ArrayList;

import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;

import com.codepath.siddhatapatil.todo.sqLite.TodoItemDatabase;
import com.codepath.siddhatapatil.todo.sqLite.TodoItemDatabaseHelper;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> todoitems;
    ArrayAdapter<String> aTodoAdapter;
    ListView lvItems;
    EditText etEditText;
    ImageView image;
    boolean flag = true;
    private TodoItemDatabaseHelper database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        database = new TodoItemDatabaseHelper(this);
        lvItems = (ListView)findViewById(R.id.lvItems);
        lvItems.setAdapter(aTodoAdapter);
        etEditText = (EditText)findViewById(R.id.etEditText);
        lvItems.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id)
            {
                todoitems.remove(position);
                aTodoAdapter.notifyDataSetChanged();
                //writeItems();
                return true;
            }
        });
        image = (ImageView) findViewById(R.id.imageButton1);
        populateArrayItems();
    }

    public void delete(View view) {
        View parent = (View) view.getParent();
        lvItems = (ListView)findViewById(R.id.lvItems);
        String task = String.valueOf(todoitems);
        SQLiteDatabase db = database.getWritableDatabase();
        db.delete(TodoItemDatabase.TaskEntry.TABLE,
                TodoItemDatabase.TaskEntry.COL_TASK + " = ?",
                new String[]{task});
        db.close();
        populateArrayItems();
    }

    private void populateArrayItems() {
        todoitems = new ArrayList<String>();
        SQLiteDatabase db = database.getReadableDatabase();
        Cursor cursor = db.query(TodoItemDatabase.TaskEntry.TABLE,
                new String[]{TodoItemDatabase.TaskEntry._ID, TodoItemDatabase.TaskEntry.COL_TASK},
                null, null, null, null, null);
        while (cursor.moveToNext()) {
            int idx = cursor.getColumnIndex(TodoItemDatabase.TaskEntry.COL_TASK);
            todoitems.add(cursor.getString(idx));
        }

        if (aTodoAdapter == null) {
            aTodoAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, todoitems);
            lvItems.setAdapter(aTodoAdapter);
        } else {
            aTodoAdapter.clear();
            aTodoAdapter.addAll(todoitems);
            aTodoAdapter.notifyDataSetChanged();
        }

        cursor.close();
        db.close();
    }


// Trying to do with sqlite..so commented the code out
    /*
    private void readItems()
    {
        File filesDir = getFilesDir();
        File file = new File(filesDir, "todo.txt");
        try
        {
            todoitems = new ArrayList<String>(FileUtils.readLines(file));
        } catch (IOException e)
        {

        }
    }

    private void writeItems()
    {
        File filesDir =getFilesDir();
        File file = new File(filesDir, "todo.txt");
        try
        {
            FileUtils.writeLines(file, todoitems);
        }catch (IOException e){

        }
    }
*/
    public void onAddItem(View view)
    {
        aTodoAdapter.add(etEditText.getText().toString());
        etEditText.setText("");
    }

    public void onPriority(View view) {

        switch(view.getId()){
            case R.id.imageButton1:{
                if(flag)
                {
                    image.setImageResource(R.drawable.square);
                    flag=false;
                }
                else
                {
                    image.setImageResource(R.drawable.star);
                    flag=true;
                }
                return;
            }
        }

    }


}

