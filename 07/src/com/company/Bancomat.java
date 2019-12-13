package com.company;

public class Bancomat implements BankomatImpl {
    //создаем массив карт
    private Card [] _cards;     //в закрытых полях название начинается с _
    private Card _userCard;     // в данном поле хранится какой именно объект в работе для методов getBalance, getCash


    public Bancomat (){     //создаем конструктор для инициализации массива

        //внутри конструктора создаем базу данных карточек
        //которая будет являться массивом из объектов Card
        //массив заполняем вручную сразу несколькими карточками через запятую, имитируя т.о. базу данных банка
        this._cards = new Card []{
                new Card("85132469","8514", 1254.55f),
                new Card("85255469","8431", 521.25f),
                new Card("15643583","9743", 0.0f),
                new Card("84341535","8462", 12.25f),
        };
    }

    public boolean chekPin(String cardId, String pin ){ //проверка pin и ID

        int i = 0;      //i вынесено наружу цикла чтобы в ней сохранился номер карточки, которую нашел цикл
        for (; i < _cards.length; i++ ){
            if (this._cards[i].ID.equals(cardId)){ // сравнение строк
                _userCard = this._cards[i];     //инициализируем поле _userCard для того, чтобы остальные методы работали именно с этой карточкой
                break;
            }
        }

        System.out.println(this._userCard);

        if (this._userCard == null){
            System.out.println("Неверный ID карточки");
            return false;
        }

        return this._cards[i].PIN.equals(pin);
    }

    public float getBalance (){     // метод возвращает баланс карты

        return this._userCard.money;

    }

    public void getCash(float cash){ //выдача денег клиенту

        if (cash > this._userCard.money){       //cверка запроса пользователя с балансом
            System.out.println("Недостаточно средств");
        }else {
            this._userCard.money -= cash;       //уменьшение баланса после выдачи денег, на сумму, запрошенную пользователем
        }

    }

    public void addCach(float cach){

        this._userCard.money += cach;

    }

    public void rejectCard (){ //извлечение карты из банкомата

        this._userCard = null; //при извлечении карты обнуляем ссылку _userCard для того, чтобы этой ссылке была присвоена карта следующего клиента

    }

    // Для имитации базы данных карточек создаем внутренний класс Card (внутренний, т.к. он больше нигде не будет использоваться)

    class Card{
        String ID;
        String PIN;
        float money;

        //создаем конструктор для класса Card
        //для упрощения процесса создания карточек
        Card (String id, String pin, float money){

            this.ID = id;
            this.PIN = pin;
            this.money = money;

        }


    }
}


