package agency;

import java.util.List;
import java.util.function.Predicate;

public class IntersectionCriterion<T> implements Predicate<T> {

    List<Predicate<T>> list;

    public IntersectionCriterion(List<Predicate<T>> list) {
        this.list = list;
    }

    @Override
    public boolean test(T t) {
        for (Predicate<T> predicate:list ) {
            if (!(predicate.test(t)))
                return false;
        }
        return true;
    }
}
