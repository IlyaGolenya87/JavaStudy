import java.util.Date;

public class Main {
    public static void main(String[] args) {

        //StringBuilder
        //Отличие от String
        //Заранее выделяет 16 бит памяти, что ускоряет объединение строк

        StringBuilder sb = new StringBuilder("absdefg");
        //append - добавляет значение в конец исходной строки
        sb.append("hijklmnop");

        System.out.println(sb);

        //StringBuffer == StringBuilder, но он потокобезопасный (потоконезависимый)

        //String

        String str = "   Hello World  ";
        str.contains("wor"); //Проверяет содержится ли заданная строка в исходной
        str.charAt(5);      //Вытаскивает символ по указанному индексу
        System.out.println(str.charAt(5));
        System.out.println(str.codePointAt(8)); //Возвращает код символа по заданному индексу
        str.codePointBefore(9);// Возвращает код предыдущего символа
        System.out.println("12345".compareTo("128"));//Сравнивает коды символов
        str.equals("Hello"); //Сравнивает добуквенно с учетом регистра
        System.out.println("abcd".equalsIgnoreCase("ABcD")); //Сравнение строк без учета регистра
        byte[] b = str.getBytes();//Преобразует строку в массив байт
        String strFromBytes = new String(b);    //Конструктора String может превращать массив из байт обратно в строку
        System.out.println(str.indexOf("Wor")); //Возвращает индес символа или строки в исходной строке либо -1, если совпадение не найдено (Регистр учитывается)
        System.out.println(str.indexOf('q'));
        str.lastIndexOf("123"); // то же, что и предыдущий, выводит индекс относительно начала, но начинает с конца,
        str.replace("Hello", "Hi"); //Заменяет подстроку в исходной строке, но не модифицирует исходную строку, а лишь возвращает ее измененную копию
        String [] chanks = "hi lol hello".split(" ");    //Разделяет строку по символу либо строке.
        //Вернет массив из 3-х строк, т.к. разбивает относительно " "
        for (int i = 0; i < chanks.length; i++){
            System.out.println(chanks[i]);
        }

        System.out.println(str.substring(1, 5)); //Выделяет подстроку в строке по начальному и конечному символу
        System.out.println(str.toLowerCase()); //Приводит все к нижнему регистру
        System.out.println(str.toUpperCase()); //Приводит все к верхнему регистру


        //Форматирование строк
        /*Флаги форматирования:
        %s - строка;
        %d - целое число (int, long и т.д)
        %f - вещественное число
        %b - boolean
        %c - символ (тип char)
        %t - дата
        %% - вывод символа %
        \n - переход на новую строку
        \t - символ табуляции
        \b - удаляет предыдущий символ
        \\ - выводит символ '\'
        * */

        //Внутри флага после символа % можно указывать цифры, которые регулируют отступы или для вещественных чисел
        //можно ограничить количество знаков после запятой
        int age = 30;
        Date date = new Date();
        System.out.println(date);
        String sFormat = String.format("\tМеня зовут %3s.\nМне %d лет. Мой рост %.2f см.\nЯ хочу знать Java на 100 %%. Сегодня %tc", "Вова", age, 182.1, date);

        System.out.println(sFormat);

        String sFormat2 = String.format("My love color %2$s. I like number %1$d",40,"red"); //цифра со знаком $ позволяет указывать конкретное значение флага, в порядке отличном от заданного
        //также позволяет несколько раз использовать значение флага.

        //Преобрвзование нестроковых объектов в строку

        int a = 125;
        String sa = String.valueOf(a);
        System.out.println(sa);





    }
}
