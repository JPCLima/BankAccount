package bank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static boolean running;
    public static void main(String[] args) {
	// write your code here

        ClientList customers = new ClientList();
        NormalAccount normalAccount = new NormalAccount();
        PremiumAccount premiumAccount = new PremiumAccount();

        while(true) {
            // Print Menu
            printOptions();
            // Ask for an user input
            int option = -1;
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String s = br.readLine();
                option = Integer.parseInt(s);
            } catch (NumberFormatException ex) {
                System.out.println("Not a number !");
            } catch (IOException e) {
                e.printStackTrace();
            }

            switch(option) {

                // 1 - Client
                case 1: {
                    printOptionsClient();
                    // Ask for an user input
                    int option12 = -1;
                    try {
                        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                        String s = br.readLine();
                        option12 = Integer.parseInt(s);
                    } catch (NumberFormatException ex) {
                        System.out.println("Not a number !");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    // Create Normal Account
                    if (option12 == 1){
                        String name = null;
                        int age = 0;
                        String address = null;
                        double balance = 0;

                        // Try and Catch Name

                        try {
                            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                            System.out.println("Enter your name: ");
                            name = br.readLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        // Try and Catch Age
                        while (age < 18) {
                            try {
                                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                                System.out.println("Enter your age: ");
                                age = Integer.parseInt(br.readLine());
                                if (age <18){
                                    System.out.println("To create an account in  minimum you need to have 18 years old.");
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }catch (NumberFormatException ex) {
                                System.out.println("Not a number!");
                            }
                        }

                        // Try and Catch Address
                        try {
                            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                            System.out.println("Enter your Address: ");
                            address = br.readLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        // Try and Catch Balance
                        while (balance <= 0) {
                            try {
                                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                                System.out.println("How much do you want to deposit: ");
                                balance = Integer.parseInt(br.readLine());
                                if (balance < 0 || balance > 100000){
                                    System.out.println("You cannot deposit negative number. Try again. ");
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }catch (NumberFormatException ex) {
                                System.out.println("Not a number!");
                            }
                        }

                        // Add the personal data to the db "ArrayList"
                        customers.addClient(new Client(name, age, address));
                        // Create Normal Account with the first deposit
                        normalAccount.addAccount(balance);
                        System.out.println("Your account has been created.\nAccount Number: " + normalAccount.getAccountNumber());
                        break;
                    }
                    // Create Premium Account
                    else if (option12 == 2){
                        String name = null;
                        int age = 0;
                        String address = null;
                        double balance = 0;

                        // Try and Catch Name
                        try {
                            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                            System.out.println("Enter your name: ");
                            name = br.readLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        // Try and Catch Age
                        while (age < 18) {
                            try {
                                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                                System.out.println("Enter your age: ");
                                age = Integer.parseInt(br.readLine());
                                if (age <18){
                                    System.out.println("To create an account in  minimum you need to have 18 years old.");
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }catch (NumberFormatException ex) {
                                System.out.println("Not a number!");
                            }
                        }

                        // Try and Catch Address
                        try {
                            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                            System.out.println("Enter your Address: ");
                            address = br.readLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        // Try and Catch Balance
                        while (balance < 100) {
                            try {
                                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                                System.out.println("How much do you want to deposit: ");
                                balance = Integer.parseInt(br.readLine());
                                if (balance <= 100){
                                    System.out.println("Minimum 100 euros of Premium account ");
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }catch (NumberFormatException ex) {
                                System.out.println("Not a number!");
                            }
                        }

                        // Add the personal data to the db "ArrayList"
                        customers.addClient(new Client(name, age, address));
                        // Create Premium Account
                        premiumAccount.addAccount(balance);
                        System.out.println("Your account has been created.\nAccount Number: " + premiumAccount.getAccountNumber());
                        break;
                    }
                    // Deposit
                    else if (option12 == 3){
                        // Try and Catch Account Number
                        int accountNumber = 0;
                        try {
                            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                            System.out.println("Please enter you account number: ");
                            accountNumber = Integer.parseInt(br.readLine());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }catch (NumberFormatException ex) {
                            System.out.println("Not a number!");
                        }

                        // Try and Catch Value
                        double value = 0;
                        try {
                            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                            System.out.println("How much do you want to deposit:");
                            value = Double.parseDouble(br.readLine());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }catch (NumberFormatException ex) {
                            System.out.println("Not a number!");
                        }

                        if (accountNumber <= 999999){
                            normalAccount.depositMoney(accountNumber, value);

                        }else if (accountNumber <= 99999999){
                            premiumAccount.depositMoney(accountNumber, value);

                        }else {
                            System.out.println("The account number is not in our system.");
                        }
                        break;
                    }
                    // Withdraw
                    else if (option12 == 4) {
                        // Try and Catch Account Number
                        int accountNumber = 0;
                        try {
                            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                            System.out.println("Please enter you account number: ");
                            accountNumber = Integer.parseInt(br.readLine());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }catch (NumberFormatException ex) {
                            System.out.println("Not a number!");
                        }

                        // Try and Catch Value
                        double value = 0;
                        try {
                            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                            System.out.println("How much do you want to withdraw:");
                            value = Double.parseDouble(br.readLine());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }catch (NumberFormatException ex) {
                            System.out.println("Not a number!");
                        }

                        if (accountNumber <= 999999){
                            normalAccount.withdrawMoney(accountNumber, value);

                        }else if (accountNumber <= 99999999){
                            premiumAccount.withdrawMoney(accountNumber, value);

                        }else {
                            System.out.println("The account number is not in our system.");
                        }

                        break;
                    }
                    // Details
                    else if (option12 == 5){
                        // Try and Catch Account Number
                        int accountNumber = 0;

                            try {
                                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                                System.out.println("How much do you want to deposit: ");
                                accountNumber = Integer.parseInt(br.readLine());
                                if (accountNumber <= 9999){
                                    System.out.println("Not an account number.");
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }catch (NumberFormatException ex) {
                                System.out.println("Not a number!");
                            }


                        if (accountNumber >= 99999 && accountNumber <= 999999){
                            normalAccount.details(accountNumber);

                        }else if (accountNumber <= 99999999){
                            premiumAccount.details(accountNumber);

                        }else {
                            System.out.println("The account number is not in our system.");
                        }

                        break;
                    }
                    // Other Option
                    else{
                        System.out.println("Please choose valid option.");
                        break;
                    }
                }
                // 2 - Account Management Team
                case 2: {
                    printOptionsBank();
                    // Ask for an user input
                    int option22 = -1;
                    try {
                        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                        String s = br.readLine();
                        option22 = Integer.parseInt(s);
                    } catch (NumberFormatException ex) {
                        System.out.println("Not a number !");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    // 1 - All the Normal Accounts
                    if (option22 == 1){
                        normalAccount.printList();
                        break;
                    }
                    // 2 - All the Premium Accounts
                    else if (option22 == 2){
                        premiumAccount.printList();
                        break;
                    }
                    // 3 -  All the Clients db
                    else if (option22 == 3){
                        customers.printClients();
                        break;
                    }
                    // Other Option
                    else{
                        System.out.println("Please choose valid option.");
                        break;
                    }
                }
                // Quit button
                case 3 : {
                    System.exit(0);
                }

                // Other, in case of any button
                default: {
                    System.out.println("Please choose valid option.");
                }
            }
        }
    }


    // Main Menu
    public static void printOptions() {
        System.out.println("\nChoose option:");
        System.out.println("1 -> For Client");
        System.out.println("2 -> For Bank System Management");

    }

    // Client Menu
    public static void printOptionsClient() {
        System.out.println("\nChoose option");
        System.out.println("1 -> Add Client Normal Account. ");
        System.out.println("2 -> Add Client Premium Account. ");
        System.out.println("3 -> Deposit Money");
        System.out.println("4 -> Withdraw Money");
        System.out.println("5 -> Account Details\n");
    }

    // Bank Menu
    public static void printOptionsBank() {
        System.out.println("\nFor Bank System Management:");
        System.out.println("1 -> All the Normal Accounts");
        System.out.println("2 -> All the Premium Accounts");
        System.out.println("3 -> All the Clients data\n");
    }
}
