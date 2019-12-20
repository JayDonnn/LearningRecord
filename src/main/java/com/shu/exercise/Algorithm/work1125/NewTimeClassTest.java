package Algorithm.work1125;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class NewTimeClassTest {

    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2019, 11, 25);
        LocalDate date1 = date.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        System.out.println(date1);

//        Instant instant = Instant.ofEpochSecond(3, 1_000_000_000);
//        Instant instant1 = Instant.ofEpochSecond(2, -1_000_000_000);
//
//        Duration duration = Duration.between(instant1, instant);
//        System.out.println(instant.getNano());
//        System.out.println(instant.getEpochSecond());
//        System.out.println(instant1.getNano());
//        System.out.println(instant1.getEpochSecond());
//        System.out.println(duration.getSeconds());

        Period between = Period.between(LocalDate.of(2009, 11, 25),
                LocalDate.of(2019, 11, 25));

        System.out.println(between.getYears());

        Duration.of(3, ChronoUnit.SECONDS);
        Period.of(1, 1, 1);

        ZoneId zoneId = ZoneId.of("Europe/Rome");
        ZonedDateTime zonedDateTime = date1.atStartOfDay(zoneId);
        System.out.println(zonedDateTime);

    }
}
