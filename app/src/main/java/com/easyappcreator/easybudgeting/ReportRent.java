package com.easyappcreator.easybudgeting;

import android.app.AlertDialog;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ReportRent extends AppCompatActivity {

    Databasehelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_rent);

        myDb = new Databasehelper(this);
        Cursor res3 = myDb.getAllData();
        if(res3.getCount() == 0) {
            // show message
            showMessage("Error","Nothing found");
            return;
        }

        StringBuffer buffer = new StringBuffer();
        while (res3.moveToNext()) {
            if (res3.getString(2).equals("Rent/Utilities")) {
                //buffer.append("Id :"+ res2.getString(0)+"\n");
                buffer.append("Date: " + res3.getString(1) + "\n");
                buffer.append("$" + res3.getString(4) + "\n");
                buffer.append("" + res3.getString(2) + "\n");
                buffer.append("Description: " + res3.getString(3) + "\n\n");

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
