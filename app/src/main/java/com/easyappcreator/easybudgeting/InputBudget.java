package com.easyappcreator.easybudgeting;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.easyappcreator.easybudgeting.R.layout.activity_input_budget;

public class InputBudget extends AppCompatActivity {

    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String RentIn = "RentKey";
    public static final String FoodIn = "FoodKey";
    public static final String GasIn = "GasKey";
    public static final String EntertainmentIn = "EntertainmentKey";
    public static final String ClothesIn = "ClothesKey";
    public static final String NewPurchasesIn = "NewPurchasesKey";
    public static final String TuitionIn = "TuitionKey";
    public static final String OtherIn = "OtherKey";

    //TextView ViewBudRent;

    EditText edTe1,edTe2,edTe3, edTe4, edTe5, edTe6, edTe7, edTe8;
    Button but1;
    private SharedPreferences sharedpreferences;
    int prefMode = Activity.MODE_PRIVATE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_input_budget);

            edTe1=(EditText)findViewById(R.id.editText16);
            edTe2=(EditText)findViewById(R.id.editText17);
            edTe3=(EditText)findViewById(R.id.editText18);
            edTe4=(EditText)findViewById(R.id.editText19);
            edTe5=(EditText)findViewById(R.id.editText20);
            edTe6=(EditText)findViewById(R.id.editText21);
            edTe7=(EditText)findViewById(R.id.editText22);
            edTe8=(EditText)findViewById(R.id.editText23);

            //Set previous entered value in field

            but1=(Button)findViewById(R.id.button6);
            sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
            int RentInInt = Integer.parseInt(sharedpreferences.getString(RentIn, ""));
            edTe1.setText(String.valueOf(RentInInt));
            int EntInInt = Integer.parseInt(sharedpreferences.getString(EntertainmentIn, ""));
            edTe2.setText(String.valueOf(EntInInt));
            int ClothesInInt = Integer.parseInt(sharedpreferences.getString(ClothesIn, ""));
            edTe3.setText(String.valueOf(ClothesInInt));
            int PurchasesInInt = Integer.parseInt(sharedpreferences.getString(NewPurchasesIn, ""));
            edTe4.setText(String.valueOf(PurchasesInInt));
            int GasInInt = Integer.parseInt(sharedpreferences.getString(GasIn, ""));
            edTe5.setText(String.valueOf(GasInInt));
            int TuitionInInt = Integer.parseInt(sharedpreferences.getString(TuitionIn, ""));
            edTe6.setText(String.valueOf(TuitionInInt));
            int FoodInInt = Integer.parseInt(sharedpreferences.getString(FoodIn, ""));
            edTe7.setText(String.valueOf(FoodInInt));
            int OtherInInt = Integer.parseInt(sharedpreferences.getString(OtherIn, ""));
            edTe8.setText(String.valueOf(OtherInInt));

            but1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Get new value
                    String rent  = edTe1.getText().toString();
                    String entertainment  = edTe2.getText().toString();
                    String clothes  = edTe3.getText().toString();
                    String purchases  = edTe4.getText().toString();
                    String gas  = edTe5.getText().toString();
                    String tuition  = edTe6.getText().toString();
                    String food  = edTe7.getText().toString();
                    String other  = edTe8.getText().toString();

                    //Save new Value

                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putString(RentIn, rent);
                    editor.putString(EntertainmentIn, entertainment);
                    editor.putString(ClothesIn, clothes);
                    editor.putString(NewPurchasesIn, purchases);
                    editor.putString(GasIn, gas);
                    editor.putString(TuitionIn, tuition);
                    editor.putString(FoodIn, food);
                    editor.putString(OtherIn, other);
                    editor.commit();
                    Toast.makeText(InputBudget.this,"Thanks",Toast.LENGTH_LONG).show();

                }
            });
        }
        }

