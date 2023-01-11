package stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static stream.Dish.*;

public class Filtering {

    public static void main(String[] args) {

        //Steam 필터 : 리턴조건에 맞는 데이터만 필터링
        //요리 목록중 채식주의자가 먹을 수 있는 음식만 필터링

        List<Dish> vergeDishes = menu.stream() // menu 에서 stream 으로 펼쳐서 필터로 dish 하나씩 꺼내서 -> function 적용
                .filter(dish -> dish.isVegeterianl()) // isVeget 인 것만 필터링으로 걸러진 상태
                .sorted(Comparator.comparing(dish -> dish.getCalories())) // sorted Comarator.comparing( rambda ) 정렬
                .collect(Collectors.toList());// collect - Collectors 로 List 로 담는 과정 ( 필터링 다 하고 마지막 과정 )

        // 출력도 Stream 가능
//        vergeDishes.stream().forEach(dish -> System.out.println(dish));  // foreach 는 stream 안해도 되긴 함

        // 요리 목록 중 육류이면서 600 미만 칼로리


        List<Dish> lightMeatFood = menu.stream()
                .filter(dish -> dish.getType().equals(Type.MEAT) && dish.getCalories() < 600) // filering 조건은 && 로 묶을 수 있으면 묶어서 사용 // 따로 filtering 도 되는 거 같기도 하고
                .sorted(Comparator.comparing(dish -> dish.getCalories()))
                .collect(Collectors.toList());

        lightMeatFood.stream().forEach(System.out::println);

        System.out.println("====================");

        List<Integer> nums = List.of(1, 2, 1, 3, 3, 2, 4, 4, 5, 6);

        nums.stream()
                .filter(n-> n%2==0) // 짝수 고르고
                .distinct()  // 중복제거 => 와 List 중복제거를 Stream 쓰면 개 쉽게 가능
                .collect(Collectors.toList())
                .forEach(n1 -> System.out.println(n1));


        System.out.println("=====================");

        // 원하는 개수만 필터링
        // 칼로리가 300칼로리보다 큰 요리중 limit 3


        menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .sorted(Comparator.comparing(Dish::getCalories).reversed())
                .limit(3) // 개수 제한
                .collect(Collectors.toList())
                .forEach(topdish -> System.out.println(topdish));


        // 요소 생략 필터링
        // 칼로리가 300칼로리보다 큰 요리중에 처음 2개는 제끼고 필터링
        menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .skip(2)
                .collect(Collectors.toList());
//                .forEach(a -> System.out.println(a));

        System.out.println("==============");
        // 처음 등장하는 고기요리 2개 필터링

        menu.stream()
                .filter(dish -> dish.getType().equals(Type.MEAT))
                .limit(2)
                .collect(Collectors.toList())
                .forEach(t -> System.out.println(t));
    }
}
