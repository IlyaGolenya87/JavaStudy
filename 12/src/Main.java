import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        //GENERIC - обобщение.
        /*Могут быть на уровне класса или на уровне метода
        * обобщение на уровне класса позволяет создать универсальные поля, тип которого может быть любым и задаваться в зависимости от типа указанного при создании объекта*/
        User<String, String> u = new User<>(); //внутри символа <> задается тип объекта, т.к. в классе User задан Generic
        User<Date, Object> u2 = new User<>();

        u.id = "SOME STRING";
        System.out.println(u.id.toLowerCase());
        u2.id = new Date();
        System.out.println(u2.id.getTime());

        Car<User> car = new Car<User>();


        //КОЛЛЕКЦИИ
        //ArrayList (все элементы располагаются друг за другом. Порядок элементов не меняется,
        //возможен доступ к любым элементам в любой момент времени

        ArrayList<String> list = new ArrayList<>(); //внутри <> указывается тип данных, которые будут храниться в коллекции
        //Нельзя указывать примитивные типы, если нужно применить примитивный - нужно использовать оболочку
        list.add("String"); //метод add добавляет элементы в конец списка
        list.add(0,"some string");

        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }

        System.out.println(list);

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(10);
        list2.add(20);
        list2.add(30);

        list2.remove(0); //удаление по индексу
        list2.remove(Integer.valueOf(20)); //удаление конкретного объекта, в случае с примитивным типом нужно взять в оболочку,
        // т.к. метод принимает только объекты



    }
}
