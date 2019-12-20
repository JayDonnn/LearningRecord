package Algorithm.work1125;

import java.util.Optional;
import java.util.Properties;

public class OptionalTest {

    public Optional<Integer> stringToInt(String s) {
        try {
            return Optional.of(Integer.parseInt(s));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

    public int readDuration(Properties props, String name) {
        return Optional.ofNullable(props.getProperty(name))
                .flatMap(this::stringToInt).filter(integer -> integer > 0)
                .orElse(0);
    }

    public static void main(String[] args) {
        Properties props = new Properties();
        props.setProperty("a", "5");
        props.setProperty("b", "true");
        props.setProperty("c", "-3");

        OptionalTest optionalTest = new OptionalTest();
        System.out.println(optionalTest.readDuration(props, "a"));
        System.out.println(optionalTest.readDuration(props, "b"));
        System.out.println(optionalTest.readDuration(props, "c"));
    }
}
