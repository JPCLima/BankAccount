package bank;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

public class PremiumAccount implements Account{

    private HashMap<Integer, Double> accounts;

    // Parameters to set a random account between 999999 and 9999999
    private static Random random = null;
    int min = 999999; // 6 Digits
    int max = 9999999; // 7 Digits
    private int accountNumber;

    // Constructor
    public PremiumAccount(){
        accounts = new HashMap<Integer, Double>();
    }

    // Methods
    @Override
    public void addAccount(Double balance) {
        accountNumber = getRandom().nextInt((max - min) + 1) + min;
        if (!accounts.containsKey(accountNumber)) {
            accounts.put(this.getAccountNumber(), balance);
        }
    }

    @Override
    public void details(int accountNumber){
        double currentBalance = accounts.get(accountNumber);
        System.out.println("Account number: " + accountNumber + "\n" +
                            "Balance: " + currentBalance);
    }

    @Override
    public void withdrawMoney(int accountNumber, double value){
        double currentBalance = accounts.get(accountNumber);
        if (currentBalance < value){
            System.out.println("You don't have enough money in you Account\n"
                    + "Current Amount: " + currentBalance);
        }
        accounts.replace(accountNumber, currentBalance - value);
    }

    @Override
    public void depositMoney(int accountNumber, double value){
        double currentBalance = accounts.get(accountNumber);
        accounts.replace(accountNumber, currentBalance + value);
    }

    @Override
    public void printList() {
        for(Map.Entry<Integer, Double> pair: accounts.entrySet()){
            Integer key = pair.getKey();
            Double value = pair.getValue();
            System.out.println("Account Number: " + key + "\n" + "Balance:" + value + "\n");
        }
    }

    // Getters and Setters
    @Override
    public int getAccountNumber() {
        return accountNumber;
    }

    // Method to create random account numbers
    public static Random getRandom() {
        //Creates new Random instance only if random is null
        if (Objects.isNull(random)) {
            random = new Random();
        }
        return random;
    }


}
