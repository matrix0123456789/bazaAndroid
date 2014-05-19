package com.example.bazaandroid.app;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.Dictionary;
import java.util.Enumeration;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;


/**
 * Created by Administrator on 14.05.14.
 */
public class Baza {
    public static Dictionary<Integer, Czlowiek> ludzie=new Słownik<Integer, Czlowiek>();
    public static Słownik<Integer, laptop> laptopy=new Słownik<Integer, laptop>();
    public static Słownik<Integer, Wyp> wyporzyczenia=new Słownik<Integer, Wyp>();
public static void czytaj(Document dok){
    NodeList laptopyXML=dok.getElementsByTagName("laptop");
    for(int i=0;i<laptopyXML.getLength();i++)
    {
        laptopy.put(Integer.parseInt(laptopyXML.item(i).getAttributes().getNamedItem("id").getNodeValue()),new laptop(Integer.parseInt(laptopyXML.item(i).getAttributes().getNamedItem("id").getNodeValue()),laptopyXML.item(i).getAttributes().getNamedItem("nazwa").getNodeValue()));
    }

    NodeList ludzieXML=dok.getElementsByTagName("laptop");
    for(int i=0;i<laptopyXML.getLength();i++)
    {
        ludzie.put(Integer.parseInt(ludzieXML.item(i).getAttributes().getNamedItem("id").getNodeValue()),new Czlowiek(Integer.parseInt(ludzieXML.item(i).getAttributes().getNamedItem("id").getNodeValue()),ludzieXML.item(i).getAttributes().getNamedItem("imie").getNodeValue()+" "+ludzieXML.item(i).getAttributes().getNamedItem("nazwisko").getNodeValue(),ludzieXML.item(i).getAttributes().getNamedItem("typ").getNodeValue(),ludzieXML.item(i).getAttributes().getNamedItem("klasa").getNodeValue()));
    }
    NodeList wypXML=dok.getElementsByTagName("wyp");
    for(int i=0;i<laptopyXML.getLength();i++)
    {
        wyporzyczenia.put(Integer.parseInt(wypXML.item(i).getAttributes().getNamedItem("id").getNodeValue()),new Wyp(Integer.parseInt(wypXML.item(i).getAttributes().getNamedItem("id").getNodeValue()),Integer.parseInt(wypXML.item(i).getAttributes().getNamedItem("id_laptop").getNodeValue()),Integer.parseInt(wypXML.item(i).getAttributes().getNamedItem("id_czlowiek").getNodeValue()),Integer.parseInt(wypXML.item(i).getAttributes().getNamedItem("data_start").getNodeValue()),Integer.parseInt(wypXML.item(i).getAttributes().getNamedItem("data_koniec").getNodeValue())));
    }
}
    static public void czytaj(){
        try {
            czytaj(DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("http://"));
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    private static class Słownik<T, T2> extends Dictionary<T, T2> {
        @Override
        public Enumeration<T2> elements() {
            return null;
        }

        @Override
        public T2 get(Object o) {
            return null;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public Enumeration<T> keys() {
            return null;
        }

        @Override
        public T2 put(T integer, T2 czlowiek) {
            return null;
        }

        @Override
        public T2 remove(Object o) {
            return null;
        }

        @Override
        public int size() {
            return 0;
        }
    }
}
