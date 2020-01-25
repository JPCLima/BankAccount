package bank;

public interface Account {

    void addAccount(Double balance);

    void details(int accountNumber);

    void withdrawMoney(int accountNumber, double value);

    void depositMoney(int accountNumber, double value);

    void printList();

    int getAccountNumber();

}
