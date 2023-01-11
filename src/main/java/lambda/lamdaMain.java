package lambda;

import java.util.List;

import static lambda.FilteringApple.*;

public class lamdaMain {

    // 귀찮으니 내부클래스로
    public static class LightApplePredicate implements Applepredicate {
        @Override
        public boolean test(Apple apple) {
            return apple.getWeight() <= 60;
        }
    }



    public static void main(String[] args) {
        Apple apple1 = new Apple(100, Color.RED);

        List<Apple> appleList = List.of(
                new Apple(40, Color.RED )
                ,new Apple(50, Color.GREEN)
                ,new Apple(60, Color.YELLOW)
                ,new Apple(70, Color.GREEN)
                ,new Apple(80, Color.RED)
        );
        List<Apple> targetApples = filterApplesByColor(appleList, Color.YELLOW);

        for (Apple targetApple : targetApples) {
            System.out.println(targetApple);
        }

        System.out.println("=========새로운 클래스를 아예 만들어서============");
        List<Apple> yellowapples = filterApples(appleList, new YellowApplePredicate());

        for (Apple yellowapple : yellowapples) {
            System.out.println(yellowapple);
        }

        System.out.println("=========귀찮아 내부클래스로============");
        List<Apple> lightApples = filterApples(appleList, new LightApplePredicate());

        for (Apple lightApple : lightApples) {
            System.out.println(lightApple);
        }

        System.out.println("===========귀찮아 익명클래스로=============");
        List<Apple> HeavyApples = filterApples(appleList, new Applepredicate() {
            @Override
            public boolean test(Apple apple) {
                return apple.getWeight() > 60;
            }
        });

        for (Apple heavyApple : HeavyApples) {
            System.out.println(heavyApple);
        }

        System.out.println("============= 실시간으로 조건을 간단하게 만들어 쓸 수 있는 람다 ==============");
        // Lambda 조건 : interace 의 추상메소드가 딱 하나만 있을 때만 사용 가능

        // applelist 에서 apple 을 꺼내서 => 색이 green 이냐에 따른 결과값을 return
        List<Apple> greenapples = filterApples(appleList, apple -> apple.getColor() == Color.GREEN);

        for (Apple greenapple : greenapples) {
            System.out.println(greenapple);
        }

        System.out.println("==================람다 연습 ================");
        List<Apple> redandheavyapples = filterApples(appleList,
                apple -> apple.getColor() == Color.RED && apple.getWeight() > 60);

        for (Apple redandheavyapple : redandheavyapples) {
            System.out.println(redandheavyapple);
        }

        System.out.println("===============Generic + Lambda =================");

        List<Integer> numbers = List.of(
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10
        );

        List<Integer> evenNums = filterGeneric(numbers, n -> n % 2 == 0);
        System.out.println(evenNums);


        System.out.println("=====================test=================");

        /**
         * 리스트와 변경조건을 전달하면 => 리스트 내부의 값을 변경조건에 따라 변환하고 반환하는 map 메서드를 구현해보세요
         * ex) map(appleList, apple -> apple.setColor(RED))
         * => 리스트 안의 모든 사과 빨간색으로 변환
         * **/

        List<Apple> mapresult = map(appleList, apple ->
                {
                    if (apple.getColor() == Color.RED) {
                        apple.setWeight(999);
                    }
                    apple.setColor(Color.RED);
                });

        for (Apple apple : mapresult) {
            System.out.println(apple);
        }

        System.out.println("===========");


    }
}
