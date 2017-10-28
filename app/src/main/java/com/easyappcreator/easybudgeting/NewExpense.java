package com.easyappcreator.easybudgeting;

import android.app.AlertDialog;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.lang.Enum;

import static com.easyappcreator.easybudgeting.R.id.parent;
import static com.easyappcreator.easybudgeting.R.id.spinner;

public class NewExpense extends AppCompatActivity {

    Databasehelper myDb;
    EditText editDate, editDescription, editAmount;
    int sumres1;
    Button btnAddData;
    Button btnViewAll;
    Button btnDelete;
    Button btnBal;
    Spinner editCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_expense);
        myDb = new Databasehelper(this);

        editDate = (EditText) findViewById(R.id.editText);
        editCategory = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.categories_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        editCategory.setAdapter(adapter);

        editDescription = (EditText) findViewById(R.id.editText3);
        editAmount = (EditText) findViewById(R.id.editText4);
        btnAddData = (Button) findViewById(R.id.button3);


        AddData();

    }


    public void AddData() {
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean inserted = true;
                        if(editCategory.getSelectedItem().toString().equals("Category")){
                            Toast.makeText(getApplicationContext(), "Please enter a valid category", Toast.LENGTH_LONG).show();
                            inserted = false;
                        }
                        if(editDate.getText().toString().equals("Date")){
                            Toast.makeText(getApplicationContext(), "Please enter a date", Toast.LENGTH_LONG).show();
                            inserted = false;
                        }
                        if(editDescription.getText().toString().equals("item Description")){
                            Toast.makeText(getApplicationContext(), "Please enter a description", Toast.LENGTH_LONG).show();
                            inserted = false;
                        }
                        if(editAmount.getText().toString().equals("Amount")){
                            Toast.makeText(getApplicationContext(), "Please enter an amount", Toast.LENGTH_LONG).show();
                            inserted = false;
                        }
                      if(inserted == true){
                          boolean isInserted = myDb.insertData(editDate.getText().toString(),
                                  editCategory.getSelectedItem().toString(),
                                  editDescription.getText().toString(),
                                  editAmount.getText().toString());
                          if (isInserted = true) {
                              //Toast.makeText(Expenseshere.this, "Data Inserted", Toast.LENGTH_LONG).show();
                              Toast.makeText(getApplicationContext(), "saved", Toast.LENGTH_LONG).show();
                              editCategory.setSelection(0);
                              editDescription.setText("Item Description", TextView.BufferType.EDITABLE);
                              editAmount.setText("Amount", TextView.BufferType.EDITABLE);
                              editDate.setText("Date", TextView.BufferType.EDITABLE);
                          }  else {
                              //Toast.makeText(Expenseshere.this, "Data Not Inserted", Toast.LENGTH_LONG).show();
                              Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_LONG).show();

                          }
                      }


                    }

                }
        );
    }

    public void viewAll() {
        btnViewAll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = myDb.getAllData();
                        if(res.getCount() == 0) {
                            // show message
                            showMessage("Error","Nothing found");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("Id :"+ res.getString(0)+"\n");
                            buffer.append("Date :"+ res.getString(1)+"\n");
                            buffer.append("Category :"+ res.getString(2)+"\n");
                            buffer.append("Description :"+ res.getString(3)+"\n");
                            buffer.append("Amount :"+ res.getString(4)+"\n\n");
                        }

                        // Show all data
                        showMessage("Data",buffer.toString());
                    }
                }
        );
    }

    public void DeleteData() {
        btnDelete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        myDb.deleteAll();
                    }
                });
    }

    public void ShowBalance() {
        btnBal.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        sumres1 = myDb.getSumData();

                    }
                    //showMessage("My Total is ", sumres1.toString());
                });
    }
    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

}

