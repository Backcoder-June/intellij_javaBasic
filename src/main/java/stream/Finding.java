package stream;

import stream.practice.Trader;
import stream.practice.Trading;

import static stream.Dish.menu;

public class Finding {
    public static void main(String[] args) {

        boolean b = menu.stream()
                .anyMatch(d -> d.isVegeterianl());


        // 500 칼로리 초과 음식들 필터링해서, 그것 중에 생선요리가 있는지 anyMatch
        boolean c = menu.stream()
                .filter(a -> a.getCalories() > 440)
                .anyMatch(dish -> dish.getType() == Dish.Type.FISH);


        boolean b1 = menu.stream()
                .allMatch(d -> d.getCalories() < 1000);

        boolean b2 = menu.stream()
                .noneMatch(cc -> cc.getCalories() > 1000);

        System.out.println(b2);




    }
}
