import java.io.*;

public class MyJVMTest_15671 {

    static int validated = Integer.MAX_VALUE;

    static int priority = 9;

    static Validator next = null;

    void validateObject() throws InvalidObjectException {
        if (validated < priority) {
            System.err.println("\nTEST FAILED: Validations called out " + "of order: Previous priority: " + validated + " < " + "new priority: " + priority);
            throw new Error();
        }
        validated = priority;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15671().validateObject();
    }
}
