package com.gibarsin;

import com.gibarsin.nonnull.List;

public final class Main {
    public static void main(final String[] args) {
        final List<Integer> integers = new List<>();
        integers.add(0);
        integers.add(1);
        integers.add(2);
        integers.beConsumedBy(System.out::print);
        System.out.println();

        integers.deleteByIndex(1);
        integers.beConsumedBy(System.out::print);
        System.out.println();

        integers.add(1);
        integers.beConsumedBy(System.out::print);
        System.out.println();

        System.out.println(integers.exists(1));
        System.out.println(integers.exists(3));
    }
}
