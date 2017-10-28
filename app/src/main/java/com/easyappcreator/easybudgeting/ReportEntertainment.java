package com.easyappcreator.easybudgeting;

import android.app.AlertDialog;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ReportEntertainment extends AppCompatActivity {

    Databasehelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_entertainment);

        myDb = new Databasehelper(this);
        Cursor res5 = myDb.getAllData();
        if(res5.getCount() == 0) {
            // show message
            showMessage("Error","Nothing found");
            return;
        }

        StringBuffer buffer = new StringBuffer();
        while (res5.moveToNext()) {
            if (res5.getString(2).equals("Entertainment")) {
                //buffer.append("Id :"+ res2.getString(0)+"\n");
                buffer.append("Date: " + res5.getString(1) + "\n");
                buffer.append("$" + res5.getString(4) + "\n");
                buffer.append("" + res5.getString(2) + "\n");
                buffer.append("Description: " + res5.getString(3) + "\n\n");

            }
        }

        // Show all data
        showMessage("All Expenses",buffer.toString());

    }

    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

}
