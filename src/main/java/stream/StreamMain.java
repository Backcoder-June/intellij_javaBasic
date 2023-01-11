package stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMain {
    public static List<String> getHealthyDishMenu(List<Dish> menu) {
        List<Dish> lowCalDishes = new ArrayList<>();

        for (Dish dish : menu) {
            if (dish.getCalories() < 400) {
                lowCalDishes.add(dish);
            }
        }

        lowCalDishes.sort(new Comparator<Dish>() {
            @Override
            public int compare(Dish o1, Dish o2) {
                return o1.getCalories() - o2.getCalories();
            }
        });
        // 요리의 이름을 담을 리스트
        List<String> dishNames = new ArrayList<>();
        for (Dish lowCaloricDish : lowCalDishes) {
            dishNames.add(lowCaloricDish.getName());
        }
        return dishNames ;
    }

    // Stream 안쓴 버전

    //Stream 방식
    public static List<String> getHealthyStream(List<Dish> menu) {
        return menu.stream()
                .filter(dish -> dish.getCalories() < 400)
                .sorted(Comparator.comparing(dish -> dish.getCalories()))
                .map(Dish->Dish.getName())
                .collect(Collectors.toList());
    }


    public static void main(String[] args) {

        List<String> healthyDishMenu = getHealthyDishMenu(Dish.menu);

        for (String dishMenu : healthyDishMenu) {
            System.out.println(dishMenu);
        }


        /** 요리 목록에서 400kcal 이하의 요리들만 추출해서 칼로리가 낮은 순서대로 오름차 정렬 한 후, 이름만을 List 로 추출해 주세요. **/






    }
}
