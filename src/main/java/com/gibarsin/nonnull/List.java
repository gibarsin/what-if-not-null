package com.gibarsin.nonnull;

import java.util.function.Consumer;

import static java.util.Objects.requireNonNull;

/**
 * Basic implementation of a single linked list.
 *
 * @param <T> The type of instances which will be held by the list instances
 */
public class List<T> {

    /**
     * If there are no elements in the list, then the first node is an {@link EndingNode},
     * else it is an {@link ElementNode}. This instance variable is never going to be null.
     */
    private Node<T> firstNode;

    /**
     * Builds a list with no elements.
     */
    public List() {
        firstNode = new EndingNode<>();
    }

    /**
     * Builds a list with only one element.
     *
     * @param firstElement the non-null only element that the list is going to hold
     */
    public List(final T firstElement) {
        firstNode = new ElementNode<>(requireNonNull(firstElement));
    }

    /**
     * Adds an element to the list.
     *
     * @param element the non-null element to insert
     */
    public void add(final T element) {
        firstNode = firstNode.addElement(requireNonNull(element));
    }

    /**
     * Deletes the element held at a position.
     *
     * @param index a non-negative index no greater than the list size minus one
     * @throws IndexOutOfBoundsException if the index is not between the list size bounds
     */
    public void deleteByIndex(final int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }
        firstNode = firstNode.deleteByIndex(index);
    }

    /**
     * Returns the element held at a position.
     *
     * @param index a non-negative index no greater than the list size minus one
     * @return the desired element
     * @throws IndexOutOfBoundsException if the index is not between the list size bounds
     */
    public T getByIndex(final int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }
        return firstNode.getByIndex(index);
    }

    /**
     * Informs if an element exists in the list.
     *
     * @param element the element to check if exists.
     * @return true if the element exists, false in other case
     */
    public boolean exists(final T element) {
        return firstNode.exists(requireNonNull(element));
    }

    /**
     * Consumes all the elements of the list.
     *
     * @param consumer the non-null consumer that is going to consume the elements
     */
    public void beConsumedBy(final Consumer<T> consumer) {
        firstNode.beConsumedBy(requireNonNull(consumer));
    }
}
