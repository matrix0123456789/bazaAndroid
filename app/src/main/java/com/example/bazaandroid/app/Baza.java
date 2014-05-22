package com.example.bazaandroid.app;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Hashtable;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;


/**
 * Created by Matrix0123456789 on 14.05.14.
 * Jest to główna klasa odpowiedzialna za kontakt z serwerem. Wszystko jest statyczne.
 */
public class Baza {
    public static Hashtable<Integer, Czlowiek> ludzie=new Hashtable<Integer, Czlowiek>();
    public static Hashtable<Integer, laptop> laptopy=new Hashtable<Integer, laptop>();
    public static Hashtable<Integer, Wyp> wyporzyczenia=new Hashtable<Integer, Wyp>();
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

    /**
     * Uruchamiasz odczytanie wszystkich danych z bazy
     * @param host ip serwera
     */
    static public void czytaj(String host){
        try {
            czytaj(DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("http://"+host+"/xml.php"));
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    /**
     * Zapisuje zmiany na serwerze
     * @param host ip serwera
     */
    static public void zapisz(String host){

        String daneWysyłane="oddaj=";
        Wyp[] wyporzyczeniaDoZmiany=new Wyp[wyporzyczenia.size()];
        for(int i=0;i<wyporzyczenia.size();i++){
            Wyp el=wyporzyczenia.elements().nextElement();
            if(el.zmieniony){
                wyporzyczeniaDoZmiany[i]=el;
                daneWysyłane+=el.id+"/"+el.czasKoniec+";";

            }
        }
        daneWysyłane+="&dodaj=";
        Wyp[] wyporzyczeniaDoDodania=new Wyp[wyporzyczenia.size()];
        for(int i=0;i<wyporzyczenia.size();i++){
            Wyp el=wyporzyczenia.elements().nextElement();
            if(el.dodany){
                wyporzyczeniaDoDodania[i]=el;
                daneWysyłane+=el.laptop.id+"/"+el.kto.id+"/"+el.czasStart()+"/"+el.czasKoniec()+";";

            }
        }
        URL u = null;
        try {
            u = new URL("http://"+host+"/zapisz.php");
            HttpURLConnection con = (HttpURLConnection) u.openConnection();

            //add reuqest header
            con.setRequestMethod("POST");
            con.setRequestProperty("User-Agent", "Android");
            con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");


            // Send post request
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(daneWysyłane);
            wr.flush();
            wr.close();

            int responseCode = con.getResponseCode();

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
