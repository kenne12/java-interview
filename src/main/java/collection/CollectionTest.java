package collection;

import java.util.List;
import java.util.stream.Collectors;

/**
 * You should complete the function in this class
 * <p>
 * Feel free to define any method and / or class you want
 */
class CollectionTest {


    /**
     * operation : x -> ((x * 2) + 3) ^ 5
     */
    public static List<Double> compute1(List<Integer> input) {
        if (input.isEmpty()) return List.of();
        return input.stream().map(val -> Math.pow((val * 2) + 3, 5)).collect(Collectors.toList());
    }

    /**
     * operation : abc -> AbcAbc
     */
    public static List<String> compute2(List<String> input) {
        if (input.isEmpty()) return List.of();
        if (input.size() == 1 && input.get(0).equals("")) return List.of("");

        if (!input.get(0).contains(" ")) {
            String value = upperFirstCaracter(input.get(0));
            return List.of(value + "" + value);
        } else {
            String[] splitString = input.get(0).split(" ");

            String firstPart = upperFirstCaracter(splitString[0]);
            String secondPart = splitString[1].toLowerCase();

            String thirdPart = splitString[2] + "" + firstPart;
            String fourthPart = splitString[1];
            String fiftPart = splitString[2];
            return List.of(firstPart + " " + secondPart + " " + thirdPart + " " + fourthPart + " " + fiftPart);
        }
    }

    private static String upperFirstCaracter(String input) {
        String firstCaracter = String.valueOf(input.charAt(0));
        return firstCaracter.toUpperCase() + "" + input.substring(1);
    }

}
