package bank;

import junit.framework.TestCase;

public class ClientTest extends TestCase {


    private final Client C_TEST = new Client("John", 50, "Street ...");

    public void testTestGetName() throws Exception {
        assertEquals(C_TEST.getName(), "John");
    }

    public void testGetAge() {
        assertEquals(C_TEST.getAge(), 50);
    }

    public void testGetAddress() {
        assertEquals(C_TEST.getAddress(), "Street ...");
    }
}