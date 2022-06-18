package com.aalbuja.inventario.Util;

public class Util {

    private static Util instance;

    public static Util getInstance() {
        if (instance == null)
            instance = new Util();
        return instance;
    }

}
