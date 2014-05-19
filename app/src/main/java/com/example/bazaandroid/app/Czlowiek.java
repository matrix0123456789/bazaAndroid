package com.example.bazaandroid.app;

/**
 * Created by Administrator on 14.05.14.
 */
public class Czlowiek {
    public String imieNazwisko;
    public typCzlowieka typ;
    public enum typCzlowieka{uczeń, nauczyciel}
    public Boolean isUczen(){
        if(typ==typCzlowieka.uczeń)
            return true;
       // else
            return false;
    }
}
