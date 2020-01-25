package bank;

public  class Client extends Person{

    private final String name;
    private final int age;
    private final String address;

    // Constructor
    public Client(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    // Getters and Setters
    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return  "Name: " + getName() + " | " +
                "Age: " + getAge() + " | " +
                "Address: " + getAddress();
    }
}
