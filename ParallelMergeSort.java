package Assignment;

// Question Number 6

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ParallelMergeSort {

    private static class MergeSortTask extends RecursiveTask<int[]> {
        private final int[] array;

        MergeSortTask(int[] array) {
            this.array = array;
        }

        @Override
        protected int[] compute() {
            if (array.length <= 1) {
                return array;
            }

            int mid = array.length / 2;

            MergeSortTask leftTask = new MergeSortTask(Arrays.copyOfRange(array, 0, mid));
            MergeSortTask rightTask = new MergeSortTask(Arrays.copyOfRange(array, mid, array.length));

            invokeAll(leftTask, rightTask);

            return merge(leftTask.join(), rightTask.join());
        }

        private int[] merge(int[] left, int[] right) {
            int[] merged = new int[left.length + right.length];

            int i = 0, j = 0, k = 0;
            while (i < left.length && j < right.length) {
                if (left[i] <= right[j]) {
                    merged[k++] = left[i++];
                } else {
                    merged[k++] = right[j++];
                }
            }

            while (i < left.length) {
                merged[k++] = left[i++];
            }

            while (j < right.length) {
                merged[k++] = right[j++];
            }

            return merged;
        }
    }

    public static int[] parallelMergeSort(int[] array) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        return forkJoinPool.invoke(new MergeSortTask(array));
    }

    public static void main(String[] args) {
        int[] inputArray = {8, 5, 2, 9, 5, 6, 3};
        int[] sortedArray = parallelMergeSort(inputArray);

        System.out.println("Sorted Array: " + Arrays.toString(sortedArray));
    }
}

