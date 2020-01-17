package com.company;

import java.util.*;

public class Main {
    public static void main(String[] args) {
/*        //FILO - first in, last out
        //Коллекция Stack


        Stack<String> stack = new Stack<>();
        //Добавление элементов:
        stack.add("String 1");
        stack.add("String 2");
        stack.add("String 3");
        stack.add("String 4");

        System.out.println(stack);
        //метод pop достает "верхний" элемент стека и удаляет его
        System.out.println(stack.pop());
        System.out.println(stack);

        stack.push("String 5"); // Помещает элемент ВСЕГДА в конец стека
        stack.add("String 6");
        System.out.println(stack);

        System.out.println(stack.peek());    //возвращает "верхний" элемент стека, не удаляя его

        System.out.println(stack.search("String 5"));

        // удаление всех элементов стека
        stack.clear();
        try {
            stack.pop();
        }catch (EmptyStackException e){
            System.out.println("Ошибка, стек пустой!");
        }

        //Коллекция QUEUE (очередь)
        //FIFO first in, first out
        //Первый пришел, первый ушел

        Queue<String> queue = new PriorityQueue<>(3);
        queue.add("q1");
        queue.add("q2");
        queue.add("q3");
        queue.add("q4");

        System.out.println(queue);

        queue.poll();       //достает элемент, стоящий "первым" в очереди и удаляет его, если очередь пустая - происходит исключение
        queue.remove();     //достает элемент, стоящий "первым" в очереди и удаляет его, если очередь пустая - возвращает null

        System.out.println(queue);

        queue.element(); //     возвращает первый элемент в очереди не удаляя его, если очередь пустая - происходит исключение
        queue.peek();//     возвращает первый элемент в очереди не удаляя его, если очередь пустая - возвращает null

        System.out.println(queue.offer("q5"));   //добавляет элементы в пределах заданного Capacity (указывается в скобках в конце)
        */


        //Пример использования коллекции Очередь (сортировка элементов User в очереди в зависимости от объема денег
        Comparator comparator = new UserComparator(); //создаем объект класса UserComparator
        Queue<User> users = new PriorityQueue<>(comparator); //создаем коллекцию Очередь и передаем ей созданыый UserComparator

        Random random = new Random();       //нужен для создания рандомного значения для поля money объекта класса User

        for (int i = 0; i < 10; i++){       //цикл создает 10 объектов класса User, задает значение money и добавляет в коллекцию
            User user = new User();
            user.setMoney(random.nextInt(1000));
            users.offer(user);
        }

        while (true){       //цикл выводит коллекцию в соответствии с приоритетом
            User u  = users.poll();
            if (u == null){
                break;
            }
            System.out.println(u);
        }

        System.out.println(fact1(10));
        System.out.println(fact2(10));
    }

    //Рекурсия - метод внутри самого себя
    //можно использовать для нахождения факториала числа

    public static int fact1 (int n){
        int result = 1;
        for (;n > 1; n--){
            result *= n;
        }
        return result;
    }

    //факториал 5 = 5*факториал 4
    public static int fact2 (int n){
        if (n == 0){
            return 1;
        }
        return n * fact2(n-1);

    }



}
