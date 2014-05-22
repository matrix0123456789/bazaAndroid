package com.example.bazaandroid.app;

import java.util.Date;

/**
 * Created by Administrator on 14.05.14.
 */
public class Wyp extends ObiektBazy {
    public Czlowiek kto;
    public laptop laptop;
    public Date czasStart;
    public Date czasKoniec=null;
    public Wyp(int _id, int _id_laptop, int _id_czlowiek, int _czasStart, int _czasKoniec)
    {
        id=_id;

        laptop=Baza.laptopy.get(_id_laptop);
        kto=Baza.ludzie.get(_id_czlowiek);

        if(_czasStart==0)
            czasStart=null;
        else
            czasStart=new Date(_czasStart);
        if(_czasKoniec==0)
            czasKoniec=null;
        else
            czasKoniec=new Date(_czasKoniec);
    }
    public long czasStart()
    {
        if(czasStart==null)
            return 0;
        return czasStart.getTime();
    }
    public long czasKoniec()
    {
        if(czasKoniec==null)
            return 0;
        return czasKoniec.getTime();
    }
}
