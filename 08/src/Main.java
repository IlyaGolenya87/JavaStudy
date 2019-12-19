public class Main {
    public static void main(String[] args) {

        User user1 = new User();

        user1.setName("Vova");
        user1.setAge(12);

        User user2 = new User();

        user2.setName("Vova");
        user2.setAge(12);

        /*user1 != user2, т.к. это ссылки на разные объекты, которые записаны в разные
        * области памяти. Поэтому для сравнения объектов используем метод equals, который
        * необходимо переопределить внутри класса User*/


        System.out.println(user1 == user2);

        System.out.println(user1.equals(user2));

        System.out.println(user1.hashCode()); //
        System.out.println(user2.hashCode());

        if (user1.hashCode() == user2.hashCode()){      //Пример сравнения двух обхектов. Вначале сравниваем при хешкоды
            if (user1.equals(user2)){                   // Если они равны сравниваем при помощи equals
                System.out.println("user1 == user2" );
            }else {
                System.out.println("user1 != user2");
            }
        }

        System.out.println(user1.toString());


        new UserFactory()       //Паттерн Фабрика. Пример работы фарбричного класса UserFactory
                .signIn("vova_fender")
                .sentMessage("Hello")
                .deActivate()
                .sentMessage("Hi!")
                .deActivate()
                .signOut();

    }
}
