package stream;

import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Mapping {
    public static void main(String[] args) {

        List<String> dishNames = Dish.menu.stream()
                .map(dish -> dish.getName())
                .collect(Collectors.toList());


        List<String> words = List.of(
                "safari", "chrome", "edge", "opera", "firefox"
        );

        List<Integer> wordsLengthList = words.stream()
                .map(s -> s.length())
                .collect(Collectors.toList());


        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6);

        List<Double> collect = nums.stream()
                .map(a -> Math.sqrt(a))
                .collect(Collectors.toList());


        int sum = Dish.menu.stream()
                .mapToInt(a -> a.getCalories())
                .sum();

        OptionalDouble meatFoodCalAvg = Dish.menu.stream()
                .filter(d -> d.getType() == Dish.Type.MEAT)
                .mapToInt(dish -> dish.getCalories())
                .average();


        meatFoodCalAvg.ifPresent(cal -> System.out.println(cal));




    }

}
