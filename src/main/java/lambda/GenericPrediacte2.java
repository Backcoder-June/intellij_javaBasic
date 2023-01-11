package lambda;

public interface GenericPrediacte2<T, R> {
    // T, R 제너릭 타입 두개로 잡아두기
    //T : 소비될 객체 타입 ( parameter )
    //R : return 객체 타입
    R test(T t);
}

