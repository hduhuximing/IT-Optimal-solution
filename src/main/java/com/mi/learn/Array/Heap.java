package com.mi.learn.Array;

/**
 * @author ming
 * @version 1.0
 * @date 2020/2/9 7:26 下午
 * @description 最小的k个数
 */
public class Heap {
    public int[] getMinKNumsByHeap(int[] arr, int k) {
        if (k < 1 || k > arr.length) {
            return arr;
        }
        int[] kHeap = new int[k];
        for (int i = 0; i < k; i++) {
            headInsert(kHeap, arr[i], i);
        }
        for (int j = k; j < arr.length; j++) {
            if (arr[j] < kHeap[0]) {
                kHeap[0] = arr[j];
                heapify(kHeap, 0);
            }
        }
        return kHeap;
    }

    private void heapify(int[] kHeap, int index) {
        int HeapSize = kHeap.length;
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int max = index;
        while (left < HeapSize) {
            if (kHeap[left] > kHeap[max]) {
                max = left;
            }
            if (right < HeapSize && kHeap[right] > kHeap[max]) {
                max = right;
            }
            if (max != index) {
                swap(kHeap, max, index);
            } else {
                break;
            }
            index = max;
            left = 2 * index + 1;
            right = 2 * index + 2;
        }
    }

    //大顶堆
    private void headInsert(int[] kHeap, int value, int index) {
        kHeap[index] = value;
        while (index != 0) {
            int parent = (index - 1) / 2;
            if (kHeap[parent] < kHeap[index]) {
                swap(kHeap, parent, index);
                index=parent;
            } else {
                break;
            }
        }
    }

    private void swap(int[] kHeap, int parent, int index) {
        int temp = kHeap[parent];
        kHeap[parent] = kHeap[index];
        kHeap[index] = temp;
    }


    public static void main(String[] args) {
        Heap h = new Heap();
        int[] i = new int[]{1, 2, 3, 5, 6, 7, 8, 9};
        int[] minKNumsByHeap = h.getMinKNumsByHeap(i, 3);
        for (int i1 : minKNumsByHeap) {
            System.out.println(i1);
        }
    }
}
