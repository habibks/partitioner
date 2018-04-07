package com.adneom.utils;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.adneom.utils.Partitioner.partition;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

public class PartitionerTest {

    @Test
    public void should_return_empty_list_when_list_is_empty() {
        List<Integer> list = new ArrayList<>();
        int partitionSize = 2;

        List<List<Integer>> result = partition(list, partitionSize);

        assertThat(result).isEmpty();
    }

    @Test
    public void should_return_1__2__3__4__5_when_list_containing_1_2_3_4_5_and_size_is_1() {
        List<Integer> list = asList(1,2,3,4,5);
        int partitionSize = 1;

        List<List<Integer>> result = partition(list, partitionSize);

        assertThat(result.size()).isEqualTo(5);
        assertThat(result.get(0)).containsExactly(1);
        assertThat(result.get(1)).containsExactly(2);
        assertThat(result.get(2)).containsExactly(3);
        assertThat(result.get(3)).containsExactly(4);
        assertThat(result.get(4)).containsExactly(5);
    }

    @Test
    public void should_return_1_2__3_4__5_when_list_containing_1_2_3_4_5_and_size_is_2() {
        List<Integer> list = asList(1,2,3,4,5);
        int partitionSize = 2;

        List<List<Integer>> result = partition(list, partitionSize);

        assertThat(result.size()).isEqualTo(3);
        assertThat(result.get(0)).containsExactly(1,2);
        assertThat(result.get(1)).containsExactly(3,4);
        assertThat(result.get(2)).containsExactly(5);
    }

    @Test
    public void should_return_1_2_3__4_5_when_list_containing_1_2_3_4_5_and_size_is_3() {
        List<String> list = asList("1","2","3","4","5");
        int partitionSize = 3;

        List<List<String>> result = partition(list, partitionSize);

        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get(0)).containsExactly("1","2","3");
        assertThat(result.get(1)).containsExactly("4","5");
    }

    @Test
    public void should_throw_illegal_argument_exception_when_list_is_null() {
        List<Integer> list = null;
        int partitionSize = 2;

        Throwable thrown = catchThrowable(() -> partition(list, partitionSize));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                .withFailMessage("List must not be null");
    }

    @Test
    public void should_throw_illegal_argument_exception_when_size_is_equal_to_zero() {
        List<Integer> list = new ArrayList<>();
        int partitionSize = 0;

        Throwable thrown = catchThrowable(() -> partition(list, partitionSize));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                .withFailMessage("Size must be greater than zero");
    }

    @Test
    public void should_throw_illegal_argument_exception_when_size_is_less_then_zero() {
        List<Integer> list = new ArrayList<>();
        int partitionSize = -2;

        Throwable thrown = catchThrowable(() -> partition(list, partitionSize));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                .withFailMessage("Size must be greater than zero");
    }
}
