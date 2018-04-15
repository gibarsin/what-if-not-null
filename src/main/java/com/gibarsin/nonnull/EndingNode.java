package com.gibarsin.nonnull;

import java.util.function.Consumer;

/* default */ class EndingNode<T> implements Node<T> {
    @Override
    public T getByIndex(final int remaining) {
        throw new IndexOutOfBoundsException();
    }

    @Override
    public void beConsumedBy(final Consumer<T> consumer) {

    }

    @Override
    public boolean exists(final T t) {
        return false;
    }

    @Override
    public Node<T> addElement(final T element) {
        return new ElementNode<>(element, this);
    }

    @Override
    public Node<T> deleteByIndex(final int index) {
        throw new IndexOutOfBoundsException();
    }
}
