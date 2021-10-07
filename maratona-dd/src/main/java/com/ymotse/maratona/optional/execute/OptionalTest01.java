package com.ymotse.maratona.optional.execute;

import java.util.List;
import java.util.Optional;

public class OptionalTest01 {

    public static void main(String[] args) {
        Optional<String> o1 = Optional.of("Aha uhu o DevDojo e' foda");
        //Optional<String> o2 = Optional.of(null); #NullPointerException
        Optional<String> o2 = Optional.ofNullable(null);
        Optional<String> o3 = Optional.empty();

        System.out.println(o1);
        System.out.println(o2);
        System.out.println(o3);
        System.out.println("----------------");

        Optional<String> nameOptional = Optional.ofNullable(findName("willllliam"));
        System.out.println(nameOptional);
        System.out.println(nameOptional.orElse("EMPTY!!"));
        System.out.println("----------------");

        Optional<String> nameOptional2 = Optional.ofNullable(findName("William"));
        System.out.println(nameOptional2);

        nameOptional2.ifPresent(s -> System.out.println(s.toUpperCase()));
    }

    private static String findName(String name) {
        List<String> names = List.of("William", "DevDojo");
        int i = names.indexOf(name);
        if(i != -1) {
//            return Optional.of(names.get(i));
            return names.get(i);
        }
//        return Optional.empty();
        return null;
    }

}
