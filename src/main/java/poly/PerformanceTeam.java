package poly;

import inherit.IdolDancer;
import inherit.StreetDancer;
import itcen.Dancer;

import java.util.ArrayList;
import java.util.List;

public class PerformanceTeam {

    private List<Dancer> dancers = new ArrayList<>();
    public void joinDacner(IdolDancer idolDancer) {
        dancers.add(idolDancer);
        System.out.println(idolDancer.getMyName() + "님이 댄스팀에 합류하셨습니다.");
        System.out.println("현재팀원 수 : " + dancers.size());
    }

    // OverLoading 시켜서 StreetDancer 타입도 받게 해거나
    public void joinDacner(StreetDancer streetDancer) {
        dancers.add(streetDancer);
        System.out.println(streetDancer.getMyName() + "님이 댄스팀에 합류하셨습니다.");
        System.out.println("현재팀원 수 : " + dancers.size());
    }


    // 부모 Type 으로 묶어서 만들거나.
    public void joinDacner(Dancer dancer) {
        dancers.add(dancer);
        System.out.println(dancer.getMyName() + "님이 댄스팀에 합류하셨습니다.");
        System.out.println("현재팀원 수 : " + dancers.size());
    }


    public void groupDance() {
        for (Dancer dancer : dancers) {
                    dancer.dance(dancer.getMyName());
        }
    }



}
