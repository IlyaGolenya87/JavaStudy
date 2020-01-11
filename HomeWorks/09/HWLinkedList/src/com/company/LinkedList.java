package com.company;

public class LinkedList {
    private Element first;
    private Element last;
    private int count = 0; //счетчик количества элементов в списке

    public int getCount() {
        return count;
    }

    public void add(int value) {
        Element element = new Element(value);
        if (first == null) {
            first = element;
        } else {
            last.nextIndex = element;
        }

        last = element;
        count++;
    }

    public int get(int index) throws Exception {
        Element current = first;

        //Генерация исключения по аналогу с методом get
        if (index > count || index <= 0) {
            throw new Exception("Error. The specified index doesn't exist. ");
        }
        for (int i = 1; i <= count; i++) {
            if (i == index) {
                break;
            }
            current = current.nextIndex;
        }

        return current.value;
    }

    public void remove(int index) throws Exception {
        Element current = first;

        //Генерация исключения по аналогу с методом get
        if (index > count || index <= 0) {
            throw new Exception("Error. The specified index doesn't exist. ");
        }
        if (index == 1) {
            first = first.nextIndex;
            return;
        }

        for (int i = 1; i <= count; i++) {
            if (i == index - 1) {
                current.nextIndex = current.nextIndex.nextIndex;
                count -= 1;
                break;
            }
            current = current.nextIndex;
        }

    }

    public void print() {
        Element current = first;
        while (current != null) {
            System.out.print(current.value);
            System.out.print(" ");
            current = current.nextIndex;
        }
        System.out.println("");
    }

    private class Element {
        int value;
        Element nextIndex;

        Element(int value) {
            this.value = value;
        }
    }

}




