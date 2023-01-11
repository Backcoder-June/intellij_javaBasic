package anonoymous;

public class calMain {

    // 매번 class 새로 file 만들기 귀찮음 => 내부 class 를 만들자 ( 보통 static 으로 만듦 )
    // 이것도 매번 다 내부 class 만들기 귀찮음 => 익명 class 를 만들자
    // 익명을 더 간단하게 => Lambda


    public static class SubCal implements Calculator {
        @Override
        public int operate(int n1, int n2) {
            return n1 + n2;
        }
    }





    public static void main(String[] args) {

        Calculator addCal = new SubCal();
        System.out.println(addCal.operate(100, 200));

        Calculator multiCal = new Calculator() {
            @Override
            public int operate(int n1, int n2) {
                return n1 * n2;
            }
        };
        System.out.println(multiCal.operate(10,50));

        Calculator divCal = (n1, n2) -> n1 / n2;

        System.out.println(divCal.operate(111, 3));


        // 람다로 함수에 함수를 넣어서 쓰는 방식
        // 인터페이스로 우회해서 사용
        // js 꺼를 java 에서도 사용
        PowerOperator op = ((n1, n2, cal) -> cal.operate(n1, n2));

        int r1 = op.power(50, 60, (n1, n2) -> n1 + n2);
        System.out.println(r1);

        int r2 = op.power(500, 3, (n1, n2) -> n1 * n2);
        System.out.println(r2);
    }
}
