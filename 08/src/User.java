public class User {

    private String name;
    private int age;

    public String getName() {       //геттер для name
        return name;
    }

    public void setName(String name) {      //сеттер для name;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age<0 || age>120){
            System.out.println("Недопустимое значение");
        }this.age = age;
    }


    @Override
    public boolean equals(Object obj) { //Переопределение метода equals (стандартный метод класса Object) для возможности сравнения двух объектов по значениям их свойств

        User user = (User)obj;      //явное преобразование. Объект obj явно преобразован к типу User, для того, чтобы у него появились свойства name и age, которые есть у User
        return this.name.equals(user.name)&&this.age == user.age; //свойство name является строковым, поэтому его сравнение выполняется также через метод equlals

        //если явное преобразование невозможно, то в user запишется значение null

    }

    /*ПРАВИЛО
     * Если в классе переопределен медтод equals, обязательно нужно переопределить метод hashCode
     * так, чтобы если x.equals(y) == true, то и x.hashCode() == y.hashCode() == true
     * Но это не тождественно правилу
     * x.hashCode() == y.hashCode() == true, то x.equals(y) == true
     *
     *
     * ВАЖНО!!! x.equals(y) == y.equals(x)*/

    @Override
    public int hashCode(){
        if (this.age > 18){
            return 1;
        }return 2;
    }

    @Override                   //Переопределение метода toString()
    public String toString() {
        return this.name;
    }


}
