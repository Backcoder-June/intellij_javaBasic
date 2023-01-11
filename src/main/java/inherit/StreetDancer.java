package inherit;

import itcen.Dancer;
import itcen.Rapper;

public class StreetDancer extends Dancer implements Rapper {
    public StreetDancer(String crew, String myName) {
        super(crew, myName);
    }

    private void bboy() {
        System.out.println("비보잉!");
    }

    @Override
    public void dance(String myName) {
        streching();
        makeFlexible();
        bboy();
        Rap();
        System.out.println(myName + "님이 춤을 춥니다.");
    }


    @Override
    public void Rap() {
        System.out.println("스트립댄서의 랩핑!");
    }
}
