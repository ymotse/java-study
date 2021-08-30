package com.ymotse.maratona.dates.execute;

import java.time.*;
import java.util.Map;

public class ZoneTest01 {

    public static void main(String[] args) {

        Map<String, String> shortIds = ZoneId.SHORT_IDS;
        for(String key: shortIds.keySet()) {
            System.out.println(key + ": " + shortIds.get(key));
        }
        System.out.println("---------------");

        System.out.println(ZoneId.systemDefault());
        ZoneId tokyoZone = ZoneId.of("Asia/Tokyo");
        System.out.println(tokyoZone);

        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        ZonedDateTime zonedDateTime = now.atZone(tokyoZone);
        System.out.println(zonedDateTime);
        System.out.println("---------------");

        Instant nowInstant = Instant.now();
        System.out.println(nowInstant);
        ZonedDateTime zonedDateTime2 = nowInstant.atZone(tokyoZone);
        System.out.println(zonedDateTime2);
        System.out.println("---------------");

        System.out.println(ZoneOffset.MIN);
        System.out.println(ZoneOffset.MAX);

        ZoneOffset offsetManaus = ZoneOffset.of("-04:00");
        OffsetDateTime offsetDateTimeManaus = now.atOffset(offsetManaus);
        System.out.println(offsetDateTimeManaus);

        OffsetDateTime offsetDateTime = OffsetDateTime.of(now, offsetManaus);
        System.out.println(offsetDateTime);

        OffsetDateTime offsetDateTime2 = nowInstant.atOffset(offsetManaus);
        System.out.println(offsetDateTime2);
    }

}
