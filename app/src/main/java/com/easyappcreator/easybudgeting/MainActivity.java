package com.easyappcreator.easybudgeting;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static com.easyappcreator.easybudgeting.Globals.getRentBudget;

import static com.easyappcreator.easybudgeting.InputBudget.ClothesIn;
import static com.easyappcreator.easybudgeting.InputBudget.EntertainmentIn;
import static com.easyappcreator.easybudgeting.InputBudget.FoodIn;
import static com.easyappcreator.easybudgeting.InputBudget.GasIn;

import static com.easyappcreator.easybudgeting.InputBudget.MyPREFERENCES;
import static com.easyappcreator.easybudgeting.InputBudget.NewPurchasesIn;
import static com.easyappcreator.easybudgeting.InputBudget.OtherIn;

import static com.easyappcreator.easybudgeting.InputBudget.RentIn;
import static com.easyappcreator.easybudgeting.InputBudget.TuitionIn;

public class MainActivity extends AppCompatActivity {

    Databasehelper myDb;

    TextView ViewBudRent, ViewUsedRent, ViewDiffRent, ViewBudEnt, ViewUsedEnt, ViewDiffEnt;
    TextView ViewBudClothes, ViewUsedClothes, ViewDiffClothes, ViewBudPurchases, ViewUsedPurchases, ViewDiffPurchases;
    TextView ViewBudGas, ViewUsedGas, ViewDiffGas, ViewBudTuition, ViewUsedTuition, ViewDiffTuition;
    TextView ViewBudFood, ViewUsedFood, ViewDiffFood, ViewBudOther, ViewUsedOther, ViewDiffOther;
    TextView ViewBudTotal, ViewSpentTotal, ViewRemTotal;
    SharedPreferences sharedpreferences;
    int sumrentres, diffrent, sumentres, diffEnt;
    int sumclothesres, diffClothes, sumpurchasesres, diffPurchases;
    int sumgasres, diffGas, sumtuitionres, diffTuition;
    int sumfoodres, diffFood, sumotherres, diffOther;
    int BudTotal, SpentTotal, RemTotal;
    Button btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new Databasehelper(this);
        //btnDelete = (Button) findViewById(R.id.button8);
        //DeleteData();

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        //Display Details on (1) Rent
        ViewBudRent = (TextView)findViewById(R.id.textView27);
        ViewBudRent.setText(String.valueOf(sharedpreferences.getString(RentIn, "")));
        int RentInInt = Integer.parseInt(sharedpreferences.getString(RentIn, ""));

        sumrentres = myDb.getRentSumData();
        ViewUsedRent = (TextView)findViewById(R.id.textView28);
        ViewUsedRent.setText(String.valueOf(sumrentres));

        diffrent = RentInInt - sumrentres;
        ViewDiffRent = (TextView)findViewById(R.id.textView29);
        ViewDiffRent.setText(String.valueOf(diffrent));

        //Display Details on (2) Entertainment
        ViewBudEnt = (TextView)findViewById(R.id.textView30);
        ViewBudEnt.setText(String.valueOf(sharedpreferences.getString(EntertainmentIn, "")));
        int EntInInt = Integer.parseInt(sharedpreferences.getString(EntertainmentIn, ""));

        sumentres = myDb.getEntSumData();
        ViewUsedEnt = (TextView)findViewById(R.id.textView31);
        ViewUsedEnt.setText(String.valueOf(sumentres));

        diffEnt = EntInInt - sumentres;
        ViewDiffEnt = (TextView)findViewById(R.id.textView32);
        ViewDiffEnt.setText(String.valueOf(diffEnt));

        //Display Details on (3) Clothes/Necessities
        ViewBudClothes = (TextView)findViewById(R.id.textView33);
        ViewBudClothes.setText(String.valueOf(sharedpreferences.getString(ClothesIn, "")));
        int ClothesInInt = Integer.parseInt(sharedpreferences.getString(ClothesIn, ""));

        sumclothesres = myDb.getClothesSumData();
        ViewUsedClothes = (TextView)findViewById(R.id.textView34);
        ViewUsedClothes.setText(String.valueOf(sumclothesres));

        diffClothes = ClothesInInt - sumclothesres;
        ViewDiffClothes = (TextView)findViewById(R.id.textView35);
        ViewDiffClothes.setText(String.valueOf(diffClothes));

     //   //Display Details on (4) New Purchases
        ViewBudPurchases = (TextView)findViewById(R.id.textView40);
        ViewBudPurchases.setText(String.valueOf(sharedpreferences.getString(NewPurchasesIn, "")));
        int PurchasesInInt = Integer.parseInt(sharedpreferences.getString(NewPurchasesIn, ""));

        sumpurchasesres = myDb.getPurchasesSumData();
        ViewUsedPurchases = (TextView)findViewById(R.id.textView41);
        ViewUsedPurchases.setText(String.valueOf(sumpurchasesres));

        diffPurchases = PurchasesInInt - sumpurchasesres;
        ViewDiffPurchases = (TextView)findViewById(R.id.textView42);
        ViewDiffPurchases.setText(String.valueOf(diffPurchases));

        //Display Details on (5) Gas/Car Utilities
        ViewBudGas = (TextView)findViewById(R.id.textView43);
        ViewBudGas.setText(String.valueOf(sharedpreferences.getString(GasIn, "")));
        int GasInInt = Integer.parseInt(sharedpreferences.getString(GasIn, ""));

        sumgasres = myDb.getGasSumData();
        ViewUsedGas = (TextView)findViewById(R.id.textView44);
        ViewUsedGas.setText(String.valueOf(sumgasres));

        diffGas = GasInInt - sumgasres;
        ViewDiffGas = (TextView)findViewById(R.id.textView45);
        ViewDiffGas.setText(String.valueOf(diffGas));

        //Display Details on (6) Tuition/Books
        ViewBudTuition = (TextView)findViewById(R.id.textView46);
        ViewBudTuition.setText(String.valueOf(sharedpreferences.getString(TuitionIn, "")));
        int TuitionInInt = Integer.parseInt(sharedpreferences.getString(TuitionIn, ""));

        sumtuitionres = myDb.getTuitionSumData();
        ViewUsedTuition = (TextView)findViewById(R.id.textView47);
        ViewUsedTuition.setText(String.valueOf(sumtuitionres));

        diffTuition = TuitionInInt - sumtuitionres;
        ViewDiffTuition = (TextView)findViewById(R.id.textView48);
        ViewDiffTuition.setText(String.valueOf(diffTuition));

        //Display Details on (7) Food/Groceries
        ViewBudFood = (TextView)findViewById(R.id.textView49);
        ViewBudFood.setText(String.valueOf(sharedpreferences.getString(FoodIn, "")));
        int FoodInInt = Integer.parseInt(sharedpreferences.getString(FoodIn, ""));

        sumfoodres = myDb.getFoodSumData();
        ViewUsedFood = (TextView)findViewById(R.id.textView50);
        ViewUsedFood.setText(String.valueOf(sumfoodres));

        diffFood = FoodInInt - sumfoodres;
        ViewDiffFood = (TextView)findViewById(R.id.textView51);
        ViewDiffFood.setText(String.valueOf(diffFood));

        //Display Details on (8) Other
        ViewBudOther = (TextView)findViewById(R.id.textView52);
        ViewBudOther.setText(String.valueOf(sharedpreferences.getString(OtherIn, "")));
        int OtherInInt = Integer.parseInt(sharedpreferences.getString(OtherIn, ""));

        sumotherres = myDb.getOtherSumData();
        ViewUsedOther = (TextView)findViewById(R.id.textView53);
        ViewUsedOther.setText(String.valueOf(sumotherres));

        diffOther = OtherInInt - sumotherres;
        ViewDiffOther = (TextView)findViewById(R.id.textView54);
        ViewDiffOther.setText(String.valueOf(diffOther));

        BudTotal = RentInInt + EntInInt + ClothesInInt + PurchasesInInt + GasInInt + TuitionInInt + FoodInInt + OtherInInt;
        SpentTotal = sumrentres + sumentres + sumclothesres + sumpurchasesres + sumgasres + sumtuitionres + sumfoodres + sumotherres;
        RemTotal = diffrent + diffEnt + diffClothes + diffPurchases + diffGas + diffTuition + diffFood + diffOther;
        ViewBudTotal = (TextView)findViewById(R.id.textView59);
        ViewBudTotal.setText(String.valueOf(BudTotal));

        ViewSpentTotal = (TextView)findViewById(R.id.textView60);
        ViewSpentTotal.setText(String.valueOf(SpentTotal));

        ViewRemTotal = (TextView)findViewById(R.id.textView61);
        ViewRemTotal.setText(String.valueOf(RemTotal));

    }

    // Called when the user taps the Add button
    public void addNewExpense(View view) {
        Intent intent = new Intent(this, NewExpense.class);
        startActivity(intent);
    }

    // Called when the user taps the View button
    public void viewExpenses(View view) {
        Intent intent = new Intent(this, Report.class);
        startActivity(intent);
    }

    //Called when the user taps the Set Budget Button
    public void setBudget(View view) {
        Intent intent = new Intent(this, SetBudget.class);
        startActivity(intent);
    }

    //Not used
    public void InputBudget(View view) {
        Intent intent = new Intent(this, InputBudget.class);
        startActivity(intent);
    }

    // These below are for individual categories, when user taps the category, gives details
    public void ReportRent(View view) {
        Intent intent = new Intent(this, ReportRent.class);
        startActivity(intent);
    }

    public void ReportEntertainment(View view) {
        Intent intent = new Intent(this, ReportEntertainment.class);
        startActivity(intent);
    }

    public void ReportClothes(View view) {
        Intent intent = new Intent(this, ReportClothes.class);
        startActivity(intent);
    }

    public void ReportPurchases(View view) {
        Intent intent = new Intent(this, ReportPurchases.class);
        startActivity(intent);
    }

    public void ReportGas(View view) {
        Intent intent = new Intent(this, ReportGas.class);
        startActivity(intent);
    }

    public void ReportTuition(View view) {
        Intent intent = new Intent(this, ReportTuition.class);
        startActivity(intent);
    }

    public void ReportFood(View view) {
        Intent intent = new Intent(this, ReportFood.class);
        startActivity(intent);
    }

    public void ReportOther(View view) {
        Intent intent = new Intent(this, ReportOther.class);
        startActivity(intent);
    }

    // This is called when user taps the Clear All button
    public void DeleteData() {
        btnDelete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        myDb.deleteAll();
                    }
                });
    }
}
