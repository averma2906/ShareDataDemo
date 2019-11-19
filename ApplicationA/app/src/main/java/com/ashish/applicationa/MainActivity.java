package com.ashish.applicationa;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.content.*;
import android.widget.RadioGroup;
enum OperationType{
    Concatination,
    Addition,
    Substraction,
    Multiplication,
    Division
}
public class MainActivity extends AppCompatActivity {
 EditText value1;
 EditText value2;
 RadioGroup radioGroup;
 OperationType currentOperation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Setting reference of edit text fields.
        value1 = findViewById(R.id.editText);
        value2 = findViewById(R.id.editText2);
        radioGroup = findViewById(R.id.radioGroup);
//       FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    private String actionType;
    public void SendValue(View v)
    {
            Intent i = new Intent();
            i.setAction(Intent.ACTION_SEND);
            String [] stringsArray = new String[2];
            stringsArray[0]=value1.getText().toString();
            stringsArray[1]=value1.getText().toString();
           // stringArray[2]==value1.getText().toString();
            i.putExtra("values",stringsArray);
            //i.putExtra("value2",value2.getText().toString());
            i.setType("text/plain");
            startActivity(i);
    }

    public void OnRadioButtonClick(View v)
    {
        int selectedId = radioGroup.getCheckedRadioButtonId();

        switch (selectedId)
        {
            case R.id.subradioButton:
                currentOperation = OperationType.Substraction;
                break;
            case R.id.concatradioButton:
                currentOperation = OperationType.Concatination;
                break;
            case R.id.divideradioButton:
                currentOperation = OperationType.Division;
                break;
            case R.id.sumradioButton:
                currentOperation = OperationType.Addition;
                break;
            case R.id.multiplyradioButton:
                currentOperation = OperationType.Multiplication;
                break;

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
