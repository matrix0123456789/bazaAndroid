package com.example.bazaandroid.app;

import java.util.Dictionary;
import java.util.Enumeration;

/**
 * Created by Administrator on 14.05.14.
 */
public class Baza {
    public static Dictionary<Integer, Czlowiek> ludzie=new Słownik<Integer, Czlowiek>();
    public static Dictionary<Integer, Czlowiek> laptopy=new Słownik<Integer, Laptop>();
    public static Dictionary<Integer, Czlowiek> wyporzyczenia=new Słownik<Integer, Czlowiek>();


    private static class Słownik<T, T2> extends Dictionary<Integer, Czlowiek> {
        @Override
        public Enumeration<Czlowiek> elements() {
            return null;
        }

        @Override
        public Czlowiek get(Object o) {
            return null;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public Enumeration<Integer> keys() {
            return null;
        }

        @Override
        public Czlowiek put(Integer integer, Czlowiek czlowiek) {
            return null;
        }

        @Override
        public Czlowiek remove(Object o) {
            return null;
        }

        @Override
        public int size() {
            return 0;
        }
    }
}
