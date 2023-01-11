package lambda;

@FunctionalInterface
public interface GenericPredicate<T> { //<T extends Apple>
    boolean test(T t);
}
