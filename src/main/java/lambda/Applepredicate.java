package lambda;

@FunctionalInterface // 람다 사용 가능 검증
public interface Applepredicate {
    // 필터 조건을 test 라는 함수를 쓰고싶으니  interface로 감싸서 사용
    // 추상메소드가 딱 하나 test 있으니까, Lambda 를 써도 어짜피 이거 하나만 가르키므로 사용 가능
    // 두 개 이상일 시, lambda 사용 불가
    boolean test(Apple apple);

}
