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

public class MainActivity extends AppCompatActivity {
    ArrayList<String> todoitems;
    ArrayAdapter<String> aTodoAdapter;
    ListView lvItems;
    EditText etEditText;
    ImageView image;
    boolean flag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        populateArrayItems();
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
    }

    public void populateArrayItems()
    {
        todoitems = new ArrayList<String>();
        //todoitems.add("Item 1");
        //todoitems.add("Item 2");
        //todoitems.add("Item 3");
        //readItems();
        aTodoAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, todoitems);


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
                    image.setImageResource(R.drawable.star_shape);
                    flag=true;
                }
                return;
            }
        }

    }
}

