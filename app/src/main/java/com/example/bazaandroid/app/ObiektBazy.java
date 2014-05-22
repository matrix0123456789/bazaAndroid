package com.example.bazaandroid.app;

/**
 * Created by Administrator on 14.05.14.
 * Interfejs do obiektów, które są zczytane z bazy danych
 */
public abstract class ObiektBazy {
    /**
     * Identyfikator elementu w bazie
     */
    public int id;
    /***
     * Czy zmieniono od czasu pobrania z bazy
     */
    public boolean zmieniony=false;
    /**
     * Czy obiekt został dodany teraz na telefonie
     */
    public boolean dodany=false;


}
