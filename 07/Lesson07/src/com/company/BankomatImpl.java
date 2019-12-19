package com.company;

public interface BankomatImpl {

    boolean chekPin(String cardId, String pin );
    float getBalance ();
    void getCash (float cash);
    void addCach (float cach);
    void rejectCard ();

}
