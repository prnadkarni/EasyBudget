package com.easyappcreator.easybudgeting;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class SetBudget extends AppCompatActivity {
    EditText editFood, editRent, editEntertain, editClothes, editNew, editCar, editTuition, editNone;
    Button update;
    public static final String MY_PREFS_NAME = "Budgets";
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_budget);
        editFood = (EditText) findViewById(R.id.editText2);
        editRent = (EditText) findViewById(R.id.editText5);
        editEntertain = (EditText) findViewById(R.id.editText6);
        editClothes = (EditText) findViewById(R.id.editText7);
        editNew = (EditText) findViewById(R.id.editText8);
        editCar = (EditText) findViewById(R.id.editText9);
        editTuition = (EditText) findViewById(R.id.editText10);
        editNone = (EditText) findViewById(R.id.editText11);
        update = (Button) findViewById(R.id.button5);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        //editFood.setSelection(Globals.getFoodBudget());
        setAmounts();
    }

    public void setAmounts(){
        update.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        if(!editFood.getText().toString().matches("")){

                            editor.putInt("Food Budget", Integer.valueOf(editFood.getText().toString()));
                            editor.apply();
                        }
                        if(!editFood.getText().toString().matches("")){
                            editor.putInt("Rent Budget", Integer.valueOf(editRent.getText().toString()));
                            editor.apply();
                        }
                        if(!editFood.getText().toString().matches("")){
                           editor.putInt("Entertain Budget", Integer.valueOf(editEntertain.getText().toString()));
                            editor.apply();
                        }
                        if(!editFood.getText().toString().matches("")){
                            editor.putInt("Clothes Budget", Integer.valueOf(editClothes.getText().toString()));
                            editor.apply();
                        }
                        if(!editFood.getText().toString().matches("")){
                            editor.putInt("New Budget", Integer.valueOf(editNew.getText().toString()));
                            editor.apply();
                        }
                        if(!editFood.getText().toString().matches("")){
                            editor.putInt("Car Budget", Integer.valueOf(editCar.getText().toString()));
                            editor.apply();
                        }
                        if(!editFood.getText().toString().matches("")){
                            editor.putInt("Tuition Budget", Integer.valueOf(editTuition.getText().toString()));
                            editor.apply();
                        }
                        if(!!editFood.getText().toString().matches("")){
                            editor.putInt("None Budget", Integer.valueOf(editNone.getText().toString()));
                            editor.apply();
                        }

                        /*
                        Globals.setFoodBudget(Integer.valueOf(editFood.getText().toString()));
                        Globals.setRentBudget(Integer.valueOf(editRent.getText().toString()));
                        Globals.setClothesBudget(Integer.valueOf(editClothes.getText().toString()));
                        Globals.setNewPurBudget(Integer.valueOf(editNew.getText().toString()));
                        Globals.setCarBudget(Integer.valueOf(editCar.getText().toString()));
                        Globals.setNoneBudget(Integer.valueOf(editNone.getText().toString()));
                        Globals.setTuitionBudget(Integer.valueOf(editTuition.getText().toString()));
                        Globals.setEntertainBudget(Integer.valueOf(editEntertain.getText().toString()));
                        */

                    }
                }
        );

    }
}
