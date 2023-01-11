package inherit;

import itcen.Dancer;
import itcen.Rapper;
import itcen.Singer;

public class IdolDancer extends Dancer implements Singer, Rapper {
    private int numberOfFan;
    public IdolDancer(String crew, String myName, int numberOfFan ) {
        super(crew, myName);
        this.numberOfFan = numberOfFan;
        System.out.println("자식 생성자 만들어짐");
    }

    // public idolDancer(){}
    // == public idolDancer(){super();} 기본생성자는 default 로 super() 로 기본 생성자 가져옴.
    // 근데 여기선 부모 class Dancer 에서 final 때문에 기본 생성자를 만들지 못하기 때문에 기본 생성자를 만들어 두지 못했다.
    // => 그렇기 때문에 여기서도 기본생성자를 만들 수 없는 것.

    public int getNumberOfFan() {
        return numberOfFan;
    }
    private void wink() {
        System.out.println("윙크!");
    }

    // 윙크는 자식이 가진 private 메소드. overriding 하면서 추가해줄 수 있음.


    @Override
    public void dance(String myName) {
        streching();
        makeFlexible();
        wink();
        sing();

        System.out.println(myName + "님이 춤을 춥니다.");
    }


    public void setNumberOfFan(int numberOfFan) {
        this.numberOfFan = numberOfFan;
    }


    @Override
    public void sing() {
        System.out.println("노래합니다.");
    }

    @Override
    public void Rap() {
        System.out.println("랩 하는 중!");
    }
}
