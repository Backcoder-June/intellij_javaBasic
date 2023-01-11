package compare;

import lombok.*;

@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode
public class Person implements Comparable<Person> {
    private String name;
    private int age;

    @Override
    public int compareTo(Person o) { //compareTo 메소드 : 비교대상 객체 2개를 전달받음 ( this / o )
        return this.age - o.getAge(); // this 랑 비교해서 양 > 같 = 음 <
        // 이걸 계속 하나하나 써서 Comparable 하게 만들어서 => 정렬을 시키는 것
    }
}
