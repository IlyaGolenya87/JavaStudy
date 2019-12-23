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

    public int get(int index) {
        Element current = first;

        try {   //Генерация исключение в случае ввода несуществующего индекса
            if (index > count || index <= 0) {
                throw new Exception("Error. The specified index doesn't exist. ");
            }
            int i = 1;
            while (current != null) {
                if (i == index) {
                    break;
                }
                current = current.nextIndex;
                i++;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0; //Т.к. метод get должен возвращать int - не придумал ничего, кроме как возвращать 0 при вводе несуществующего индекса
        }
        return current.value;
    }

    public void remove(int index) {
        Element current = first;
        //Генерация исключения по аналогу с методом get
        try {
            if (index > count || index <= 0) {
                throw new Exception("Error. The specified index doesn't exist. ");
            }

            int i = 1;
            if (i == index) {
                first = first.nextIndex;
                return;
            }
            while (current != null) {
                if (i == index - 1) {
                    current.nextIndex = current.nextIndex.nextIndex;
                    count -= 1;
                    break;
                }
                current = current.nextIndex;
                i++;
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
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




