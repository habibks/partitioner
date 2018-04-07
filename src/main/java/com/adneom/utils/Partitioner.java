package com.adneom.utils;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.stream.Collectors.groupingBy;

public class Partitioner {

    public static <T> List<List<T>> partition(List<T> list, int partitionSize) {
        checkNotNullList(list);
        checkSizeGreaterThanZero(partitionSize);
        return getSubLists(list, partitionSize);
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

    private static <T> List<List<T>> getSubLists(List<T> list, int partitionSize) {
        Map<Integer, List<T>> subListByIndex = groupBySubListIndex(list, partitionSize);
        return new ArrayList<>(subListByIndex.values());
    }

    private static <T> Map<Integer, List<T>> groupBySubListIndex(List<T> list, int partitionSize) {
        AtomicInteger index = new AtomicInteger(0);
        return list.stream()
                .collect(groupingBy(it -> index.getAndIncrement() / partitionSize));
    }


}
