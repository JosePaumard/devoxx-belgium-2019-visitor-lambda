package org.paumard.visitor;

import java.util.function.Consumer;

public interface VisitorInitializer<R> extends Consumer<VisitorBuilder<R>> {

    default void init(VisitorBuilder<R> builder) {
        this.accept(builder);
    }
}
