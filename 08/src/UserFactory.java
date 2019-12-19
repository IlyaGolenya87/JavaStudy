public class UserFactory {  //Фабричный класс (для реализации паттерна "Фабрика"

    private boolean isBlocked = false;

    public UserFactory signIn (String login){
        System.out.println("User Sign in as " + login);
        return this;
    }

    public UserFactory sentMessage (String message){
        if(this.isBlocked){
            System.out.println("User is blocked");
        }else {
            System.out.println("User recived message "+ message);
        }
        return this;
    }

    public UserFactory activate (){
        this.isBlocked = false;
        return this;
    }

    public UserFactory deActivate (){
        this.isBlocked = true;
        return this;
    }

    public void signOut (){
        System.out.println("User sign out...");
    }


}
