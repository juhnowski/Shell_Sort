package com.company;

import java.util.Random;

public class ShellSort {

    private int[] arr;
    private int arrSize;

    public void sort() {
        int inner, outer, temp;

        int interval = 1;

        while (interval <= arrSize / 3) {
            interval = interval * 3 + 1;
        }

        while (interval > 0) {
            for (outer = interval; outer < arrSize; outer++) {
                temp = arr[outer];
                inner = outer;

                while ((inner > interval - 1) && (arr[inner - interval] >= temp)) {
                    arr[inner] = arr[inner - interval];
                    inner -= interval;
                }

                arr[inner] = temp;
            }

            interval = (interval - 1) / 3;
        }
    }


    public ShellSort(int size) {
        this.arrSize = size;
        arr = new int[size];
        generateRandomArray();
    }

    public void generateRandomArray() {
        Random rand = new Random();
        for (int i = 0; i < arrSize; i++) {
            arr[i] = rand.nextInt();
        }
    }

    public void print() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ShellSort list = new ShellSort(10);
        list.print();
        list.sort();
        list.print();
    }
}
