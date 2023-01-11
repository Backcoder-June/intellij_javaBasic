package itcen;


import static itcen.DanceLevel.*;
import static java.lang.Math.random;

public abstract class Dancer {
    private final String crew;
    private final String myName;
    private DanceLevel level = BEGINNER;

    //public Dancer(){}
    // => 여기서 무조건 값이 할당되어야 하기 때문에, 기본 생성자가 있으면 컴파일 안된다.
    // => 값을 둘다 할당하는 생성자가 있어야 함

    public Dancer(String crew, String myName) {
        this.crew = crew;
        this.myName = myName;
        System.out.println("부모 생성자 만들어짐");
    }

    private boolean stretch;
    private boolean flexible;

    public void streching() {
        System.out.println(myName + "님이 스트레칭 합니다. ");
        stretch = true;
    }
    public void makeFlexible() {
        if (!stretch) {
            System.out.println("스트레칭 안하고 유연성을 기르려다 죽었습니다.");
            return;
        }
        System.out.println(myName + "님이 유연성을 기릅니다.");
        flexible = true;
    }

    public abstract void dance(String myName);/* {
        // 캡슐화 시키기 ( 객체지향 )
        streching();
        makeFlexible();

        if (!flexible) {
            System.out.println("유연성 안기르고 춤추려다 죽었습니다.");
            return;
        }
        System.out.println(myName + "님이 춤을 춥니다.");
    }*/

    public String getCrew() {
        return crew;
    }
    public String getMyName() {
        return myName;
    }

}
