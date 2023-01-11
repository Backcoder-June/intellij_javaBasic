package lambda;

import java.util.ArrayList;
import java.util.List;

public class FilteringApple {
    public static List<Apple> filterApplesByColor(List<Apple> applebox, Color colorinput) {
        List<Apple> result = new ArrayList<>();

        for (Apple apple : applebox) {
            if (apple.getColor() == colorinput) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterApples(List<Apple> applebox, Applepredicate applefunction) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : applebox) {
            if (applefunction.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static <T> List<T> filterGeneric(List<T> inventory, GenericPredicate<T> function) {
        List<T> result = new ArrayList<>();
        for (T t : inventory) {
            if (function.test(t)) {
                result.add(t);
            }
        }
        return result;
    }

    public static <T, R> List<R> map(List<T> inputList, GenericPrediacte2<T, R> function) {
        List<R> result = new ArrayList<>();
        for (T t : inputList) {
            R r = function.test(t);
            result.add(r);
        }
        return result;
    }





}
