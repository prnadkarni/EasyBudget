package com.easyappcreator.easybudgeting;

/**
 * Created by swati on 10/10/2017.
 */

public class Globals {
    private static Globals instance;
    private static int foodBudget = 0;
    private static int rentBudget = 0;
    private static int entertainBudget = 0;
    private static int clothesBudget = 0;
    private static int newPurBudget = 0;
    private static int carBudget = 0;
    private static int tuitionBudget = 0;
    private static int noneBudget = 0;

    private Globals(){}

    public static void setFoodBudget(int newBudget){
        Globals.foodBudget = newBudget;
    }

    public static void setRentBudget(int newBudget){
        Globals.rentBudget = newBudget;
    }

    public static void setClothesBudget(int newBudget){
        Globals.clothesBudget = newBudget;
    }

    public static void setNewPurBudget(int newBudget){
        Globals.newPurBudget = newBudget;
    }

    public static void setCarBudget(int newBudget){
        Globals.carBudget = newBudget;
    }

    public static void setTuitionBudget(int newBudget){
        Globals.tuitionBudget = newBudget;
    }

    public static void setNoneBudget(int newBudget){
        Globals.noneBudget = newBudget;
    }

    public static int getFoodBudget(){
        return Globals.foodBudget;
    }

    public static int getRentBudget(){
        return Globals.rentBudget;
    }

    public static int getClothesBudget(){
        return Globals.clothesBudget;
    }

    public static int getEntertainBudget(){
        return Globals.entertainBudget;
    }

    public static int getNewPurBudget(){
        return Globals.newPurBudget;
    }

    public static int getCarBudget(){
        return Globals.carBudget;
    }

    public static int getTuitionBudget(){
        return Globals.tuitionBudget;
    }

    public static int getNoneBudget(){
        return Globals.noneBudget;
    }

    public static void setEntertainBudget(int newBudget) {
        Globals.entertainBudget = newBudget;
    }
}
