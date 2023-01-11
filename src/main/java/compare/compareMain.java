package compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import static java.util.Comparator.*;

public class compareMain {
    public static void main(String[] args) {

        List<Person> pList= new java.util.ArrayList<>(List.of(
                new Person("bune", 32)
                , new Person("aom", 27)
                , new Person("cuna", 29)
                , new Person("dzman", 10)
        ));

        List<Integer> nums = new java.util.ArrayList<>(List.of(3, 1, 4, 1, 5, 9, 2));

        //Collections.sort(pList); 객체 자체로는 기준이 없어서 정렬할 수 없다.
        // => Comparable< > 인터페이스 구현해서 사용
        //public class Person implements Comparable<Person> {
        //    @Override
        //    public int compareTo(Person o) {
        //        return 0;
        //    }

        pList.sort(new Comparator<Person>() {
            /*@Override
            public int compare(Person o1, Person o2) {
                return o2.getAge() - o1.getAge();
            }*/
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        // 람다 한방 식
        pList.sort(comparing(person -> person.getAge())); //T 를 주면 R 을 내놔라
        pList.sort(comparing(Person::getName));
        pList.sort(comparing(Person::getName).reversed()); //

        System.out.println(pList);

        Collections.sort(nums);
        Collections.reverse(nums);
    }
}