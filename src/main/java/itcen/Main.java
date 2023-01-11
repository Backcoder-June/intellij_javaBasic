package itcen;

import inherit.IdolDancer;
import inherit.StreetDancer;
import poly.PerformanceTeam;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        /*Dancer dancer = new Dancer("itcen", "june");
        System.out.println(dancer.getCrew() + "팀의" + dancer.getMyName() + "입니다. ");
        dancer.dance();
*/
        IdolDancer idolDancer = new IdolDancer("아이티센", "june", 3);
        Dancer idolDancer2 = new IdolDancer("아이티센2", "june2", 4);
        Dancer idolDancer3 = new IdolDancer("아이티센3", "june3", 5);

        StreetDancer streetDancer = new StreetDancer("길거리댄서", "팝핀현준");
        Dancer streetDancer2 = new StreetDancer("길거리댄서2", "웨이브준현");

        PerformanceTeam team = new PerformanceTeam();

        LinkedList<Object> list1 = new LinkedList<>();
        Queue<Object> queue = new LinkedList<>();

        team.joinDacner(idolDancer);
        team.joinDacner(streetDancer2);

        team.groupDance();
    }
}