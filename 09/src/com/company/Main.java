package com.company;

public class Main {
    public static void main(String[] args) {

        //ИСКЛЮЧЕНИЯ

       /* int i = 15;
        i = i / 0;
*/

        int[] arr = new int[3];

        //У каждого вида исключения свое название
        //Любое исключение в Java является классом

        int index = 2;

        //Для того, чтобы отловить исключение:
        try {
            //Помещаем код, который потенциально МОЖЕТ (т.е. не факт) вызвать исключение.
            arr[index] = 2;
            index /= 0;
            System.out.println("test"); //весь код, который находится в блоке try после выражения, вызвавшего исключение работать не будет.
        } catch (ArrayIndexOutOfBoundsException e) {  //В круглых скобках указыать тип исключения, которое потенциально может возникнуть
            e.printStackTrace(); //стандартный метод любого исключения, который выводит текст в консоль (стандартный)
            System.out.println("Something is wrong");
        } catch (ArithmeticException e) {  //блоков catch может быть несколько
            e.printStackTrace();
            System.out.println("You try / on zero");
        }
        //При использовании try/catch программа не вылетает, а продолжает работать.
        System.out.println("I'm OK))");

        //Т.к. все ислключения это классы - можно создавать свои исключения
        //Для этого класс должен быть наследником класса Exception (для высокоуровневых исключений) или Throwable (Для низкоуровненвых исключений)

        try { //обработка и генерация пользовательских исключений (созданных самостоятельно)
            //throw генерирует исключения
            throw new MyException(); //после throw необходимо создать объект пользовательского исключения

        } catch (MyException e) {
            System.out.println(e.getMessage());
            System.out.println(e.timestamp);
        }

        //Порядок catch-ей имеет значкение,
        //Класс Exception и Throwable должны находиться всегда
        //ниже пользовательских исключений.
        //Если среди catch присутствует класс Exception или Throwable,
        //то он сработает в том случае, если не сработал ни один другой из пользовательских классов - исключений.
        //Для однотипных исключений допускается использовать один общий try/catch с исключением Exception
        try {
            test();
        } catch (MyException e) {
            System.out.println(e.getMessage());
        } catch (RuntimeException e) {

        } catch (Exception e) {

        }

        //Игра "Угадай число"
        System.out.println("Game");
        System.out.println("-----------------------");
        Game game = new Game();
        game.start();

    }

    public static void test() throws MyException, RuntimeException {
        getMoney(100);
    }

    //пример использования пользовательского исключения
    public static void getMoney(int money) throws MyException, RuntimeException { // в сигнатуре метода необходимо писать throws и затем все исключения, которые могут быть и их необходимо обработать
        if (money <= 0 || money >= 1000) {                                          // обработку исключкений можно передавать вверх по иерархии методов, в нашем случае в метод test(), а затем в main
            throw new MyException();                                               // это делается для того, чтобы не обрабатывать исключения в каждом методе, а обработать один раз в первом по иерархии методе
        }
        System.out.println("Operation completed successfully");
        throw new RuntimeException();


    }


}
