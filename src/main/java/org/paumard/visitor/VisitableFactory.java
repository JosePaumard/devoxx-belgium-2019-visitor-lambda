package org.paumard.visitor;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Stream;

public interface VisitableFactory<T> {

    Stream<Function<T, Object>> functions();

    static <T> X<T> visiting(Class<T> type) {
        return () -> type;
    }

    default Visitable<T> makeVisitable(T t) {
        return () -> functions().map(function -> function.apply(t));
    }

    interface X<T> {
        Class<?> type();

        default VisitableFactory<T> collectsFrom(Function<T, Object>... functions) {
            return () -> Arrays.stream(functions);
        }
    }
}
