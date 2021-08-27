package com.ymotse.maratona.wrappers.execute;

public class WrapperTest01 {

    public static void main(String[] args) {
        byte byteP = 1;
        short shortP = 1;
        int intP = 1;
        long longP = 10L;
        float floatP = 10F;
        double doubleP = 100;
        char charP = 'Y';
        boolean booleanP = true;

        Byte byteW = 1;
        Short shortW = 1;
        Integer intW = 1; //autoboxing
        Long longW = 10L;
        Float floatW = 10F;
        Double doubleW = 100d;
        Character charW = 'Y';
        Boolean booleanW = true;

        int i = intW; //unboxing
        Integer intW2 = Integer.parseInt("1");

        boolean verdadeiro = Boolean.parseBoolean("tRuE");
        System.out.println(verdadeiro);

        System.out.println(Character.isDigit('A'));
        System.out.println(Character.isDigit('9'));
        System.out.println(Character.isLetterOrDigit('!'));
        System.out.println(Character.isUpperCase('C'));
        System.out.println(Character.isLowerCase('c'));
        System.out.println(Character.toUpperCase('m'));
        System.out.println(Character.toLowerCase('T'));
    }

}
