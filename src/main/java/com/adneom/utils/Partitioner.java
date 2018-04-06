package com.adneom.utils;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.stream.Collectors.groupingBy;

public class Partitioner {

    public static <T> List<List<T>> partition(List<T> list, int size) {
        checkNotNullList(list);
        checkSizeGreaterThanZero(size);
        return getSubLists(list, size);
    }

    private static <T> void checkNotNullList(List<T> list) {
        if (list == null) {
            throw new IllegalArgumentException("List must not be null");
        }
    }

    private static void checkSizeGreaterThanZero(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Size must be greater than zero");
        }
    }

    private static <T> List<List<T>> getSubLists(List<T> list, int size) {
        AtomicInteger index = new AtomicInteger(0);
        Collection<List<T>> partitions = list.stream()
                .collect(groupingBy(it -> index.getAndIncrement() / size))
                .values();
        return new ArrayList<>(partitions);
    }


}
