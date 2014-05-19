package com.example.bazaandroid.app;

/**
 * Created by Administrator on 14.05.14.
 */
public class Czlowiek extends ObiektBazy {
    public String imieNazwisko;
    public typCzlowieka typ;
    String klasa;
    public enum typCzlowieka{uczeń, nauczyciel}
    public Boolean isUczen(){
        if(typ==typCzlowieka.uczeń)
            return true;
       // else
            return false;
    }
    public Czlowiek(int _id, String _imieNazwisko, String _typ, String _klasa)
    {
        id=_id;
        imieNazwisko=_imieNazwisko;
        klasa=_klasa;
        if(_typ.equalsIgnoreCase("uczen"))
        {
            typ=typCzlowieka.uczeń;
        }
        else
            typ=typCzlowieka.nauczyciel;
    }
}
