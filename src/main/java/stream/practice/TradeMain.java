package stream.practice;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class TradeMain {
    public static void main(String[] args) {

        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Trading> tradings = List.of(
                new Trading(brian, 2021, 300),
                new Trading(raoul, 2022, 1000),
                new Trading(raoul, 2021, 400),
                new Trading(mario, 2021, 710),
                new Trading(mario, 2022, 700),
                new Trading(alan, 2022, 950)
        );

        // 2021 발생 모든 거래 찾아 거래액 오름차 정렬
        List<Trading> collect2 = tradings.stream()
                .filter(trading -> trading.getYear() == 2021)
                .sorted(Comparator.comparing(t -> t.getValue()))
                .collect(Collectors.toList());
//                .forEach(a -> System.out.println(a));

        // 거래자가 근무하는 모든 도시이름을 중복 없이 나열
        List<String> collect1 = tradings.stream()
                /*.map(c -> c.getTrader())
                .map(tradername -> tradername.getCity())*/ // 이렇게 두번에 나눠서 하는걸
                .map(c -> c.getTrader().getCity()) // 바로 한방에 하면 된다.
                .distinct()
                .collect(Collectors.toList());
//                .forEach(a -> System.out.println(a));

        System.out.println("---------------------------------");

        // cambridge 에 근무하는 모든 거래자를 찾아 이름순 오름차 정렬
        List<Trader> collect = tradings.stream()
                .map(trading -> trading.getTrader())
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .sorted(Comparator.comparing(tr -> tr.getName()))
                .collect(Collectors.toList());
//                .forEach(a -> System.out.println(a));

        System.out.println("------------------------");

        // 모든 거래자 이름을 리스트에 모아서 알파벳 순으로 오름차 정렬
        List<String> collect3 = tradings.stream()
                .map(trading -> trading.getTrader().getName())
                .sorted() // String 이나 숫자 타입이면 자동정렬 ( Comparator 필요없음 )
                .collect(Collectors.toList());
//                .forEach(a-> System.out.println(a));


        // 거래액 500 초과 큰 거래액 순서로 정렬
        tradings.stream()
                .filter(trading -> trading.getValue() > 500)
                .sorted(Comparator.comparing(Trading::getValue).reversed())
                .collect(Collectors.toList())
                .forEach(b -> System.out.println(b));



        System.out.println("==================");
        // 연습 5: Milan에 거주하는 거래자가 한명이라도 있는지 여부 확인?
        boolean milanbln = tradings.stream()
                .anyMatch(t -> t.getTrader().getCity() == "Milan");
                /*.map(a -> a.getTrader())
                .anyMatch(b -> b.getCity() == "Milan");*/ // map 으로 안돌리고 바로 anyMatch 에서 두번 뽑으면 된다.

        System.out.println(milanbln);


        System.out.println("==================");
        // 연습 6: Cambridge에 사는 거래자의 모든 거래액의 총합 출력.

        int cambridgeTotalSum = tradings.stream()
                .filter(f -> f.getTrader().getCity().equalsIgnoreCase("Cambridge"))
                .mapToInt(a -> a.getValue())
                .sum();

        System.out.println(cambridgeTotalSum);


        System.out.println("==================");
        // 연습 7: 모든 거래에서 최고거래액은 얼마인가?
        OptionalInt maxTradeValue = tradings.stream()
                .mapToInt(a -> a.getValue())
                .max();

        maxTradeValue.ifPresent(mtv -> System.out.println(mtv));

        System.out.println("====================");
        // 가장 작은 거래액 가진 거래정보 탐색 => min 을 바로 쓰고 Comparator 로 나중에 비교 값 주기
        Optional<Trading> min = tradings.stream()
                .min(Comparator.comparing(a -> a.getValue()));

        min.ifPresent(mv -> System.out.println(mv));



    }
}
