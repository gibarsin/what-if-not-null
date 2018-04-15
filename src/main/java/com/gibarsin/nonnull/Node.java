package com.gibarsin.nonnull;

import java.util.function.Consumer;

/* default */ interface Node<T> {
    T getByIndex(final int remaining);

    void beConsumedBy(final Consumer<T> consumer);

    boolean exists(final T element);

    Node<T> addElement(final T element);

    Node<T> deleteByIndex(final int remaining);
}
