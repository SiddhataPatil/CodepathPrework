package com.codepath.siddhatapatil.todo;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.app.Activity;
        import android.view.View;
        import android.widget.Toast;
/**
 * Created by siddhatapatil on 8/23/17.
 */

public class Calendar extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar_activity);
    }
    public void setAlarm(View view)
    {
        Toast toast = Toast.makeText(getApplicationContext(),
                getResources().getString(R.string.action_alarm),
                Toast.LENGTH_SHORT);
        toast.show();
    }
}