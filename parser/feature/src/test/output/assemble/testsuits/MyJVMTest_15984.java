import java.io.*;

public class MyJVMTest_15984 {

    static int a = 5, b = 0;

    static int validates = 1;

    void validateObject() throws InvalidObjectException {
        if (validates > 0)
            throw new Error("Implementation error: Re-validating object " + this.toString());
        validates++;
        System.out.println("Validating " + this.toString());
        if (a > b) {
            throw new InvalidObjectException("Fields cannot be negative");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15984().validateObject();
    }
}
