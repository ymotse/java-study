package com.ymotse.maratona.resourceBundle;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleTest01 {

    public static void main(String[] args) {
        System.out.println(Locale.getDefault());

        ResourceBundle bundleUS = ResourceBundle.getBundle("messages", new Locale("en", "US"));
        boolean keyExists = bundleUS.containsKey("sasa");
        System.out.println(keyExists);

        System.out.println(bundleUS.getString("hello"));
        System.out.println(bundleUS.getString("good.morning"));
        System.out.println("------------------");

        ResourceBundle bundleBR = ResourceBundle.getBundle("messages", new Locale("pt", "BR"));
        System.out.println(bundleBR.getString("hello"));
        System.out.println(bundleBR.getString("good.morning"));

        //messages_en_US.properties
        //messages_en.properties
        //messages.properties

    }

}
