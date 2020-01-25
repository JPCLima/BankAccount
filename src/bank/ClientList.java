package bank;

import java.util.ArrayList;
import java.util.Random;

public class ClientList {

    private ArrayList<Client> customers;

    // Constructor
    public ClientList(){
        customers = new ArrayList<Client>();
    }

    // Methods
    public void addClient(Client account) {
        customers.add(account);
    }

    public void printClients() {
        for (Client customer : customers) {
            System.out.println(customer);
        }
    }

}
