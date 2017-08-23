package com.codepath.siddhatapatil.todo.sqLite;

/**
 * Created by siddhatapatil on 8/22/17.
 */
import android.provider.BaseColumns;

public class TodoItemDatabase {
    public static final String DB_NAME = "com.codepath.siddhatapatil.todo.sqLite";
    public static final int DB_VERSION = 1;

    public class TaskEntry implements BaseColumns {
        public static final String TABLE = "tasks";

        public static final String COL_TASK = "title";
    }
}
