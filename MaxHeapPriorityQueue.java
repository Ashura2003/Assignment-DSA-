package Assignment;

import java.util.*;

public class MaxHeapPriorityQueue<T> {

    private final List<T> heap;
    private final Comparator<T> comparator;

    public MaxHeapPriorityQueue() {
        this.heap = new ArrayList<>();
        this.comparator = null;
    }

    public MaxHeapPriorityQueue(Comparator<T> comparator) {
        this.heap = new ArrayList<>();
        this.comparator = comparator;
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int leftChild(int i) {
        return 2 * i + 1;
    }

    private int rightChild(int i) {
        return 2 * i + 2;
    }

    private void siftUp(int i) {
        while (i > 0 && compare(heap.get(parent(i)), heap.get(i)) < 0) {
            Collections.swap(heap, parent(i), i);
            i = parent(i);
        }
    }

    private void siftDown(int i) {
        int maxIndex = i;
        int l = leftChild(i);
        int r = rightChild(i);

        if (l < heap.size() && compare(heap.get(l), heap.get(maxIndex)) > 0) {
            maxIndex = l;
        }
        if (r < heap.size() && compare(heap.get(r), heap.get(maxIndex)) > 0) {
            maxIndex = r;
        }

        if (i != maxIndex) {
            Collections.swap(heap, i, maxIndex);
            siftDown(maxIndex);
        }
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public int size() {
        return heap.size();
    }

    public void insert(T element) {
        heap.add(element);
        siftUp(heap.size() - 1);
    }

    public T extractMax() {
        if (isEmpty()) {
            throw new NoSuchElementException("Priority queue is empty.");
        }
        T max = heap.get(0);
        Collections.swap(heap, 0, heap.size() - 1);
        heap.remove(heap.size() - 1);
        siftDown(0);
        return max;
    }

    private int compare(T a, T b) {
        if (comparator != null) {
            return comparator.compare(a, b);
        }
        @SuppressWarnings("unchecked")
        Comparable<T> comp = (Comparable<T>) a;
        return comp.compareTo(b);
    }

    public static void main(String[] args) {
        MaxHeapPriorityQueue<Integer> pq = new MaxHeapPriorityQueue<>();

        pq.insert(10);
        pq.insert(5);
        pq.insert(15);

        System.out.println("Size: " + pq.size());
        System.out.println("Max Element: " + pq.extractMax());
        System.out.println("Size: " + pq.size());
    }
}

