package com.easyappcreator.easybudgeting;

import android.app.AlertDialog;
import android.content.res.Resources;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import static com.easyappcreator.easybudgeting.R.string.Date3;
import android.text.Html;


public class Report extends AppCompatActivity {

    Databasehelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        myDb = new Databasehelper(this);
        Cursor res2 = myDb.getAllData();
        if(res2.getCount() == 0) {
            // show message
            showMessage("Error","Nothing found");
            return;
        }

        StringBuffer buffer = new StringBuffer();
        while (res2.moveToNext()) {
            //buffer.append("Id :"+ res2.getString(0)+"\n");

            buffer.append("Date: " + res2.getString(1)+"\n");
            buffer.append("Amount: $"+ res2.getString(4)+"\n");
            buffer.append(""+ res2.getString(2)+"\n");
            buffer.append("Description: "+ res2.getString(3)+"\n\n");

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
