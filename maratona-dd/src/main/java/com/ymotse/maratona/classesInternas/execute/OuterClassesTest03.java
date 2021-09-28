package com.ymotse.maratona.classesInternas.execute;

public class OuterClassesTest03 {

    private String name = "William";

    static class Nested {
        private String lastName = "Suane";

        void print() {
            System.out.println(new OuterClassesTest03().name + " " + lastName);
        }
    }

    public static void main(String[] args) {
        Nested nested = new Nested();
        nested.print();
    }

}
