package com.gibarsin.nonnull;

import java.util.function.Consumer;

import static java.util.Objects.requireNonNull;

/* default */ class ElementNode<T> implements Node<T> {
    private final T element;
    private Node<T> nextNode;

    /* default */ ElementNode(final T element) {
        this.element = requireNonNull(element);
        nextNode = new EndingNode<>();
    }

    /* default */ ElementNode(final T element, final Node<T> next) {
        this.element = requireNonNull(element);
        nextNode = requireNonNull(next);
    }

    @Override
    public T getByIndex(final int remaining) {
        if (remaining == 0) {
            return element;
        }
        return nextNode.getByIndex(remaining - 1);
    }

    @Override
    public void beConsumedBy(final Consumer<T> consumer) {
        consumer.accept(element);
        nextNode.beConsumedBy(consumer);
    }

    @Override
    public boolean exists(final T element) {
        if (this.element.equals(element)) {
            return true;
        }
        return nextNode.exists(element);
    }

    @Override
    public Node<T> addElement(final T element) {
        return new ElementNode<>(element, this);
    }

    @Override
    public Node<T> deleteByIndex(final int remaining) {
        if (remaining == 0) {
            return nextNode;
        }
        nextNode = nextNode.deleteByIndex(remaining - 1);
        return this;
    }
}
