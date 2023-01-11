package lambda;

public class YellowApplePredicate implements Applepredicate {

    @Override
    public boolean test(Apple apple) {
        return apple.getColor() == Color.YELLOW;
    }
}
